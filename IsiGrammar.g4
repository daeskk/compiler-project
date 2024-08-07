grammar IsiGrammar;

// TODO: do the check for unused variables

prog 		: 'programa' Declara Bloco 'fimprog' DOT 
			;


Declara 	: 'declare' Id (COMMA Id)* DOT
			;

Bloco 		: (Cmd DOT)+
			;
			
Cmd			: CmdLeitura | CmdEscrita | CmdExpr | CmdIf
			;
			
CmdLeitura	: 'leia' LEFTPARENTHESIS Id RIGHTPARENTHESIS
			;

CmdEscrita	: 'escreva' LEFTPARENTHESIS Texto | Id RIGHTPARENTHESIS
			;
			
CmdIf		: 'se' LEFTPARENTHESIS Expr Op_rel Expr RIGHTPARENTHESIS 
				'entao' OPENBRACKETS Cmd+ CLOSEBRACKETS 
					('senao' OPENBRACKETS Cmd+ CLOSEBRACKETS)?
			;

CmdExpr 	: Id ':=' Expr
			;
			
Op_rel 		: '<' | '>' | '<=' | '>=' | '!=' | '==' 
			;
			
Termo 		: Fator ((MUL | DIV) Fator)*
			;
			
Expr 		: Termo ((PLUS | MINUS) Termo)*
			;
						
Fator		: Num | Id | LEFTPARENTHESIS Expr RIGHTPARENTHESIS
			;
			
Texto 		: DOUBLEQUOTE ( [a-z] | [A-Z] | [0-9] | ' ' )+ DOUBLEQUOTE
			;

Num			: [0-9]+
			;

Id 			: ( [a-z] | [A-Z] ) ( [a-z] | [A-Z] | [0-9] )*
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