grammar IsiGrammar;

@header{
    import java.util.ArrayList;
    import java.util.List;
}

prog 		: 'programa' Declara Bloco 'fimprog' DOT
			;

Declara 	: 'declare' Id (COMMA Id)* DOT
			;

Bloco 		: (Cmd DOT)+
			;
			
Cmd			: CmdLeitura | CmdEscrita | CmdExpr | CmdIf
			;
			
CmdLeitura	: 'leia' OPENPARENTHESIS Id CLOSEPARENTHESIS
			;

CmdEscrita	: 'escreva' OPENPARENTHESIS Texto | Id CLOSEPARENTHESIS
			;
			
CmdIf		: 'se' OPENPARENTHESIS Expr Op_rel Expr CLOSEPARENTHESIS 
				'entao' OPENBRACKETS Cmd+ CLOSEBRACKETS 
					('senao' OPENBRACKETS Cmd+ CLOSEBRACKETS)?
			
			;

CmdExpr 	: Id ':=' Expr
			;
			
Op_rel 		: '<' | '>' | '<=' | '>=' | '!=' | '==' 
			;
			
Termo 		: Termo '*' Fator | Termo '/' Fator | Fator
			;
		
Expr 		: Expr '+' Termo | Expr '-' Termo | Termo
			;
						
Fator		: Num | Id | '(' Expr ')'
			;
			
Texto 		: DOUBLEQUOTE ( [a-z] | [A-Z] | [0-9] | ' ' )+ DOUBLEQUOTE
			;

Num			: [0-9]+
			;

Id 			: ( [a-z] | [A-Z] ) ( [a-z] | [A-Z] | [0-9] )*
			;
			
			
DOUBLEQUOTE			: '"'
					;
					
OPERATOR			: '+' | '-' | '*' | '/' | '**'
					;
		
COMMA				: ','
					;
				
OPENPARENTHESIS 	: '('
					;
				
CLOSEPARENTHESIS 	: ')'
					;

OPENBRACKETS  		: '{'
     				;

CLOSEBRACKETS  		: '}'
     				;

DP					: ':'
		    		;
		    
DOT					: '.'
					;
		    		
WS					: (' ' | '\n' | '\r' | '\t' ) -> skip
					;