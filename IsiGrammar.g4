grammar IsiGrammar;

@header 
{
	import compiler.datastructures.*;
	import compiler.exceptions.*;

    import java.util.HashSet;
    import java.util.Set;
}

@members 
{	
	private int _varType;
	private String _varName;
	private String _varValue;
	
	private Symbol currentSymbol;
		
	private SymbolTable _symbolTable = new SymbolTable();
	
	private Set<String> _unusedVariables = new HashSet<>();
		
	public void addSymbol() {
		if (_symbolTable.exists(_varName)) {
			throw new SemanticException("variable '" + _varName + "' redeclared");	
		}
		
		_symbolTable.add(new Variable(_varType, _varName, _varValue));
		_unusedVariables.add(_varName);
	}
	
	public void verifyIdentifier() {
		if (!_symbolTable.exists(_varName)) {
			throw new SemanticException("Variable '" + _varName + "' not declared");
		}
	}
}

prog 				: 'programa' (declare)* block 'fimprog' DOT {
					    if(_unusedVariables.size() > 0) {
					        System.out.println("Warning: Unused variables: " + _unusedVariables);
					    }
					}
					;

declare 			: 'declare' vartype IDENTIFIER {
						_varName = _input.LT(-1).getText();
						_varValue = null;

						addSymbol();
					} 
					(COMMA IDENTIFIER {
						_varName = _input.LT(-1).getText();
						_varValue = null;

						addSymbol();
					} 
					)*
					DOT 
					
					;
					
vartype				: 'number' { _varType = Variable.NUMBER; }
					| 'string' { _varType = Variable.STRING; }
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
					}
					
					RIGHTPARENTHESIS DOT
					;

cmdwrite			: 'escreva' LEFTPARENTHESIS (
					TEXT 
					| 
					IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
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
						_unusedVariables.remove(_varName);
					} 
					':=' expr DOT
					;
					
cmdwhile			: 'enquanto' LEFTPARENTHESIS expr RELOPERATOR expr RIGHTPARENTHESIS
						OPENBRACKETS (cmd)+ CLOSEBRACKETS
					;
			
term 				: factor ((MUL | DIV) factor)*
					;
			
expr 				: term ((PLUS | MINUS) term)*
					;
						
factor				: NUMBER 
					| IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
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