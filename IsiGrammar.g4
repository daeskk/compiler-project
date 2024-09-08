grammar IsiGrammar;

@header 
{
    import compiler.datastructures.*;
    import compiler.exceptions.*;
    import compiler.ast.*;

    import java.util.HashSet;
    import java.util.Set;
    import java.util.List;
    import java.util.ArrayList;
    import java.util.Stack;
}

@members 
{	
	private int _varType;
	private Integer _exprLeftType, _exprRightType = null;
	private boolean _breakUsable = false;

	private String _varName, _exprLeftVarname, top;

	private Stack<String> expressionStack = new Stack<>();
	private Stack<IfCommand> ifCommandStack= new Stack<>();

	private Symbol currentSymbol;
    private SymbolTable _symbolTable = new SymbolTable();

    private Variable _currentVar;

    private IfCommand currentIfCommand;
    private DoWhileCommand currentDoWhileCommand;
    private WhileCommand currentWhileCommand;

    private Stack<List<Command>> commandStack = new Stack<>();

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

	public void checkBreak() {
        if (!_breakUsable)
            throw new SemanticException("Command 'parar' must be used inside a loop.");
    }
}

prog 				: 'programa' IDENTIFIER {
                        codeGenerator.setProgramName(_input.LT(-1).getText());
                        commandStack.push(new ArrayList<>());
                    } (declare)* block 'fimprog' DOT {
                        verifyUnusedVariables();
					    verifyUninitializedList();

                        codeGenerator.setSymbolTable(_symbolTable);
                        codeGenerator.setCommands(commandStack.pop());

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
					| 'double'  { _varType = Variable.DOUBLE;  }
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
				    | cmdbreak
					;

cmdbreak            : 'parar' DOT {
                        checkBreak();
                        BreakCommand cmdBreak = new BreakCommand();
                        commandStack.peek().add(cmdBreak);
                        }
                    ;

cmdread				: 'leia' LEFTPARENTHESIS IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						setAsUsed();
                        Variable _var = (Variable) _symbolTable.get(_varName);
                        _var.setInitialized(true);

					    commandStack.peek().add(new ReadCommand((Variable) _symbolTable.get(_varName)));

					}
					
					RIGHTPARENTHESIS DOT
					;

cmdwrite			: 'escreva' LEFTPARENTHESIS (
					TEXT {
					    commandStack.peek().add(new WriteCommand(_input.LT(-1).getText()));
					}
					| 
					IDENTIFIER {
						_varName = _input.LT(-1).getText();
						verifyIdentifier();
						verifyIfInitialized();
						setAsUsed();

					    commandStack.peek().add(new WriteCommand(_varName));
					}
					) 
					RIGHTPARENTHESIS DOT
					;
			
cmdif				: 'se' {
                            commandStack.push(new ArrayList<>());
                            ifCommandStack.push(new IfCommand());
                            expressionStack.push("");
                        }
                        LEFTPARENTHESIS
                        expr
                        RELOPERATOR {
                             top = expressionStack.pop();
                             top += _input.LT(-1).getText();

                             expressionStack.push(top);
                        }
                        expr
                        RIGHTPARENTHESIS {
                             ifCommandStack.peek().setExpression(expressionStack.pop());
                        }
				        'entao' OPENBRACKETS (cmd)+ CLOSEBRACKETS {
                             ifCommandStack.peek().setTrueList(commandStack.pop());
				        }
                        ('senao' {
                             commandStack.push(new ArrayList<>());
                        }
                        OPENBRACKETS
                        (cmd)+
                        CLOSEBRACKETS {
                            ifCommandStack.peek().setFalseList(commandStack.pop());
                        }
                        )
                        ?
                        {
                            commandStack.peek().add(ifCommandStack.pop());
                        }
					;

cmdexpr 			: IDENTIFIER {
						_varName = _input.LT(-1).getText();
						_exprLeftVarname = _varName;
						verifyIdentifier();
                        _currentVar = (Variable) _symbolTable.get(_input.LT(-1).getText());
                        _exprLeftType = _currentVar.getType();
					} 
					':=' {
                        expressionStack.push("");
					}
					expr
					DOT {
					    if (_exprLeftType != _exprRightType) {

                            throw new SemanticException("Mismatched type assignment at variable '" + _exprLeftVarname + "'");
                        }

                        _currentVar.setInitialized(true);

                        commandStack.peek().add(new AttrCommand(_varName, expressionStack.pop()));
					}
					;
					
cmdwhile			: 'enquanto' {
                        commandStack.push(new ArrayList<>());
                        currentWhileCommand = new WhileCommand();
                        expressionStack.push("");
                        _breakUsable = true;
                    }
                    LEFTPARENTHESIS
                    expr
                    RELOPERATOR {
                         top = expressionStack.pop();
                         top += _input.LT(-1).getText();

                         expressionStack.push(top);
                    }
                    expr
                    RIGHTPARENTHESIS {
                        currentWhileCommand.setExpression(expressionStack.pop());
                    }
                    OPENBRACKETS
                    (cmd)+
                    CLOSEBRACKETS {
                        currentWhileCommand.setCommandList(commandStack.pop());
                        commandStack.peek().add(currentWhileCommand);
                        _breakUsable = false;
                    }
					;

cmddowhile          : 'execute' {
                        commandStack.push(new ArrayList<>());
                        currentDoWhileCommand = new DoWhileCommand();
                        _breakUsable = true;
                    }
                    OPENBRACKETS
                    (cmd)+
                    CLOSEBRACKETS
                    'enquanto' {
                        expressionStack.push("");
                    }
                    LEFTPARENTHESIS
                    expr
                    RELOPERATOR {
                         top = expressionStack.pop();
                         top += _input.LT(-1).getText();

                         expressionStack.push(top);
                    }
                    expr
                    RIGHTPARENTHESIS {
                        currentDoWhileCommand.setExpression(expressionStack.pop());
                    }
                    DOT {
                        currentDoWhileCommand.setCommandList(commandStack.pop());
                        commandStack.peek().add(currentDoWhileCommand);
                        _breakUsable = false;
                    }
                    ;
			
term 				: factor {
                         top = expressionStack.pop();
                         top += _input.LT(-1).getText();

                         expressionStack.push(top);
                    }
                    ((MUL | DIV) {
                         top = expressionStack.pop();
                         top += _input.LT(-1).getText();

                         expressionStack.push(top);
                    }
                    factor {
                         top = expressionStack.pop();
                         top += _input.LT(-1).getText();

                         expressionStack.push(top);
                    }
                    )*
					;
			
expr 				: term
                    ((PLUS | MINUS) {
                         top = expressionStack.pop();
                         top += _input.LT(-1).getText();

                         expressionStack.push(top);
                    }
                    term
                    )*
					;
						
factor				: NUMBER {
                        String numberString = _input.LT(-1).getText();
                        if (numberString.contains(".")) {
                            _exprRightType = Variable.DOUBLE;
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