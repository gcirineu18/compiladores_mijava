grammar Mijava;


program: mainClass (classDecl)* EOF;

mainClass:
	CLASS ID LBRACE PUBLIC STATIC VOID MAIN LPAREN STRING LBRACK RBRACK ID RPAREN LBRACE statement
		RBRACE RBRACE;

classDecl: CLASS ID (EXTENDS ID)? LBRACE (varDecl)* (methodDecl)* RBRACE;

varDecl: type ID SEMI;

methodDecl:
	PUBLIC type ID LPAREN (formalList(COMMA formalList)*)? RPAREN LBRACE (varDecl)* (
		statement
	)* RETURN expression SEMI RBRACE;

formalList: type ID;

type: INT LBRACK RBRACK # intArrayType
	| INT 				# integerType
	| ID 				# identifierType
	| BOOLEAN           # booleanType;

statement:
	LBRACE (statement)* RBRACE                             # blockStatement
	| IF LPAREN expression RPAREN statement ELSE statement # ifStatement 
	| WHILE LPAREN expression RPAREN statement			   # whileStatement 		
	| SOUT LPAREN expression RPAREN SEMI				   # printStatement
	| ID ASSIGN expression SEMI                            # assignStatement
	| ID LBRACK expression RBRACK ASSIGN expression SEMI   # arrayAssignStatement ;

expression:
	expression (AND | LT | GT | ADD | SUB | MUL) expression              # binaryExpression
	| expression LBRACK expression RBRACK                                # arrayAccessExpression
	| expression DOT LENGTH                                              # arrayLengthExpression 
	| expression DOT ID LPAREN (expression (COMMA expression)*)? RPAREN  # methodCallExpression
	| INTEGER_LITERAL                                                    # intergerLiteralExpression 
	| TRUE																 # trueExpression	
	| FALSE																 # falseExpression
    | ID 																 # identifierExpression
    | THIS                           									 # thisExpression
	| NEW INT LBRACK expression RBRACK                                   # newArrayExpression         
	| NEW ID LPAREN RPAREN												 # newObjectExpression
	| NOT expression													 # notExpression	
	| LPAREN expression RPAREN											 # innerExpression;


identifier: ID;

LPAREN: '(';
RPAREN: ')';
LBRACE: '{';
RBRACE: '}';
LBRACK: '[';
RBRACK: ']';
SEMI: ';';
COMMA: ',';
DOT: '.';
NOT: '!';
ASSIGN: '=';
AND: '&&';
LT: '<';
GT: '>';

ADD: '+';
SUB: '-';
DIV: '/';
MUL: '*';

MAIN: 'main';
CLASS: 'class';
EXTENDS: 'extends';
PUBLIC: 'public';
STATIC: 'static';
VOID: 'void';
RETURN: 'return';
STRING: 'String';
INT: 'int';
BOOLEAN: 'boolean';
IF: 'if';
ELSE: 'else';
WHILE: 'while';
SOUT: 'System.out.println';
LENGTH: 'length';
TRUE: 'true';
FALSE: 'false';
THIS: 'this';
NEW: 'new';

ID: [a-zA-Z]+ [a-zA-Z0-9_]*;
INTEGER_LITERAL: [0-9]+;

LINECOMMENT: '//' ~[\r\n]* -> skip;
COMMENT: '/*' .*? '*/' -> skip;
WS: [ \t\r\n]+ -> skip;