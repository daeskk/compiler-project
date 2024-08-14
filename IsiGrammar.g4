grammar IsiGrammar;

@header 
{
    import compiler.datastructures.*;
    import compiler.exceptions.*;
    import compiler.ast.*;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.List;
}

@members 
{	
	private int _varType;
	private Integer _exprLeftType, _exprRightType = null;

	private String _varName, _exprLeftVarname;

	private Symbol currentSymbol;
    private SymbolTable _symbolTable = new SymbolTable();

    private CodeGenerator codeGenerator = new CodeGenerator();

	public void addSymbol() {
		if (_symbolTable.exists(_varName)) {
			throw new SemanticException("variable '" + _varName + "' redeclared");	
		}
		
		_symbolTable.add(new Variable(_varType, _varName, false, false));
	}
	
	public void verifyIdentifier() {
		if (!_symbolTable.exists(_varName)) {
			throw new SemanticException("Variable '" + _varName + "' not declared");
		}
	}

	public void verifyIfInitialized() {
		Variable currentVar = (Variable) _symbolTable.get(_varName);

        if (!currentVar.isInitialized()) {
			throw new SemanticException("Variable '" + _varName + "' might not have been initialized");
        }
	}

	public void setAsUsed() {
	    Variable currentVar = (Variable) _symbolTable.get(_varName);
		currentVar.setUsed(true);
	}

	public void verifyUninitializedList() {
        List<String> uninitializedList = _symbolTable
                                            .generateUninitializedList()
                                            .stream()
                                            .map(x -> x.getName())
                                            .toList();

        if (uninitializedList.size() > 0) {
            System.out.println("Warning: Uninitialized variables: " + uninitializedList);
        }
	}

	public void verifyUnusedVariables() {
        if(_symbolTable.generateUnusedList().size() > 0) {
            System.out.println("Warning: Unused variables: " + _symbolTable.generateUnusedList()
                                                                                .stream()
                                                                                .map(x -> x.getName())
                                                                                .toList());
        }
	}

}

prog 				: 'programa' (declare)* block 'fimprog' DOT {
                        verifyUnusedVariables();
					    verifyUninitializedList();

                        codeGenerator.setSymbolTable(_symbolTable);

                        codeGenerator.generateTarget();
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
					| cmddowhile
					;
			
cmdread				: 'leia' LEFTPARENTHESIS IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						verifyIfInitialized();
						setAsUsed();
					}
					
					RIGHTPARENTHESIS DOT
					;

cmdwrite			: 'escreva' LEFTPARENTHESIS (
					TEXT 
					| 
					IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						verifyIfInitialized();
						setAsUsed();
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
						_exprLeftVarname = _varName;
						verifyIdentifier();
                        Variable _var = (Variable) _symbolTable.get(_input.LT(-1).getText());
                        _var.setInitialized(true);
                        _exprLeftType = _var.getType();
					} 
					':=' expr DOT {
					    if (_exprLeftType != _exprRightType) {

                            throw new SemanticException("Mismatched type assignment at variable '" + _exprLeftVarname + "'");
                        }
					}
					;
					
cmdwhile			: 'enquanto' LEFTPARENTHESIS expr RELOPERATOR expr RIGHTPARENTHESIS
						OPENBRACKETS (cmd)+ CLOSEBRACKETS
					;

cmddowhile          : 'execute' OPENBRACKETS (cmd)+ CLOSEBRACKETS
                      'enquanto' LEFTPARENTHESIS expr RELOPERATOR expr RIGHTPARENTHESIS DOT
                    ;
			
term 				: factor ((MUL | DIV) factor)*
					;
			
expr 				: term ((PLUS | MINUS) term)*
					;
						
factor				: NUMBER {
                        String numberString = _input.LT(-1).getText();
                        if (numberString.contains(".")) {
                            _exprRightType = Variable.FLOAT;
                        } else {
                            _exprRightType = Variable.INTEGER;
                        }
                    }
                    | TEXT {
                        _exprRightType = Variable.STRING;
                    }
					| IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						verifyIfInitialized();
						setAsUsed();

                        Variable _var = (Variable) _symbolTable.get(_input.LT(-1).getText());
                        _exprRightType = _var.getType();
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