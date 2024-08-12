grammar IsiGrammar;

@header 
{
	import compiler.datastructures.*;
	import compiler.exceptions.*;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.List;
}

@members 
{	
	private int _varType;
	private Integer _exprLeftType, _exprRightType = null;

	private String _varName;
	private Set<String> _unusedVariables = new HashSet<>();

	private Symbol currentSymbol;
    private SymbolTable _symbolTable = new SymbolTable();

	public void addSymbol() {
		if (_symbolTable.exists(_varName)) {
			throw new SemanticException("variable '" + _varName + "' redeclared");	
		}
		
		_symbolTable.add(new Variable(_varType, _varName, false));
		_unusedVariables.add(_varName);
	}
	
	public void verifyIdentifier() {
		if (!_symbolTable.exists(_varName)) {
			throw new SemanticException("Variable '" + _varName + "' not declared");
		}
	}

	public void verifyUninitializedList() {
        List<String> uninitializedList = _symbolTable
                                            .generateUninitializedList()
                                            .stream()
                                            .filter(x -> !_unusedVariables.contains(x.getName()))
                                            .map(x -> x.getName())
                                            .toList();

        System.out.println("Warning: Uninitialized variables in use: " + uninitializedList);
	}

}

prog 				: 'programa' (declare)* block 'fimprog' DOT {
					    if(_unusedVariables.size() > 0) {
					        System.out.println("Warning: Unused variables: " + _unusedVariables);
					    }

					    _symbolTable.iterate();

					    verifyUninitializedList();
					}
					;

declare 			: 'declare' vartype IDENTIFIER {
						_varName = _input.LT(-1).getText();

						addSymbol();
					} 
					(COMMA IDENTIFIER {
						_varName = _input.LT(-1).getText();

						addSymbol();
					} 
					)*
					DOT 
					
					;
					
vartype				: 'integer' { _varType = Variable.INTEGER; }
					| 'float'   { _varType = Variable.FLOAT;   }
					| 'string'  { _varType = Variable.STRING;  }
			 		;

block				: (cmd)+
					;
			
cmd					: cmdread 
					| cmdwrite 
					| cmdexpr 
					| cmdif 
					| cmdwhile
					;
			
cmdread				: 'leia' LEFTPARENTHESIS IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						_unusedVariables.remove(_varName);
					}
					
					RIGHTPARENTHESIS DOT
					;

cmdwrite			: 'escreva' LEFTPARENTHESIS (
					TEXT 
					| 
					IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						_unusedVariables.remove(_varName);
					}
					) 
					RIGHTPARENTHESIS DOT
					;
			
cmdif				: 'se' LEFTPARENTHESIS expr RELOPERATOR expr RIGHTPARENTHESIS 
						'entao' OPENBRACKETS (cmd)+ CLOSEBRACKETS 
							('senao' OPENBRACKETS (cmd)+ CLOSEBRACKETS)?
					;

cmdexpr 			: IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
                        Variable _var = (Variable) _symbolTable.get(_input.LT(-1).getText());
                        _var.setInitialized(true);
                        _exprLeftType = _var.getType();
					} 
					':=' expr DOT {

					}
					;
					
cmdwhile			: 'enquanto' LEFTPARENTHESIS expr RELOPERATOR expr RIGHTPARENTHESIS
						OPENBRACKETS (cmd)+ CLOSEBRACKETS
					;
			
term 				: factor ((MUL | DIV) factor)*
					;
			
expr 				: term ((PLUS | MINUS) term)*
					;
						
factor				: NUMBER {
                        if (_exprRightType == null) {
                            _exprRightType = Variable.INTEGER;
                        }
                    }
                    | TEXT {
                        if (_exprRightType == null) {
                            _exprRightType = Variable.STRING;
                        }

                    }
					| IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						_unusedVariables.remove(_varName);
					}
					| LEFTPARENTHESIS expr RIGHTPARENTHESIS
					;










RELOPERATOR 		: '<' | '>' | '<=' | '>=' | '!=' | '==' 
					;
					
TEXT 				: DOUBLEQUOTE ( [a-z] | [A-Z] | [0-9] | ' ' )+ DOUBLEQUOTE
					;

NUMBER				: [0-9]+ ('.' [0-9]+)?
					;

IDENTIFIER 			: ( [a-z] | [A-Z] ) ( [a-z] | [A-Z] | [0-9] )* 
					;
					
PLUS    			: '+'
					;
		
MINUS   			: '-'
					;
		
MUL     			: '*'
					;
		
DIV     			: '/'
					;
		
COMMA				: ','
					;
				
LEFTPARENTHESIS 	: '('
					;
				
RIGHTPARENTHESIS 	: ')'
					;

OPENBRACKETS  		: '{'
     				;

CLOSEBRACKETS  		: '}'
     				;

DP					: ':'
		    		;
		    
DOT					: '.'
					;
					
DOUBLEQUOTE			: '"'
					;
		    		
WS					: (' ' | '\n' | '\r' | '\t' ) -> skip
					;