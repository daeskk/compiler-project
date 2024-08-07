grammar IsiGrammar;

// TODO: do the check for unused variables

prog 				: 'programa' declare block 'fimprog' DOT 
					;

declare 			: 'declare' IDENTIFIER (COMMA IDENTIFIER)* DOT
					;

block				: (cmd DOT)+
					;
			
cmd					: cmdread | cmdwrite | cmdexpr | cmdif
					;
			
cmdread				: 'leia' LEFTPARENTHESIS IDENTIFIER RIGHTPARENTHESIS
					;

cmdwrite			: 'escreva' LEFTPARENTHESIS (TEXT | IDENTIFIER) RIGHTPARENTHESIS
					;
			
cmdif				: 'se' LEFTPARENTHESIS expr RELOPERATOR expr RIGHTPARENTHESIS 
						'entao' OPENBRACKETS cmd+ CLOSEBRACKETS 
							('senao' OPENBRACKETS cmd+ CLOSEBRACKETS)?
					;

cmdexpr 			: IDENTIFIER ':=' expr
					;
			
term 				: factor ((MUL | DIV) factor)*
					;
			
expr 				: term ((PLUS | MINUS) term)*
					;
						
factor				: NUMBER | IDENTIFIER | LEFTPARENTHESIS expr RIGHTPARENTHESIS
					;

RELOPERATOR 		: '<' | '>' | '<=' | '>=' | '!=' | '==' 
					;
					
TEXT 				: DOUBLEQUOTE ( [a-z] | [A-Z] | [0-9] | ' ' )+ DOUBLEQUOTE
					;

NUMBER				: [0-9]+
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