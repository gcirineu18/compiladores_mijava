grammar Mijava;


program: mainClass classDecl*;

mainClass:
	CLASS ID LBRACE PUBLIC STATIC VOID MAIN LPAREN STRING LBRACK RBRACK ID RPAREN LBRACE statement
		RBRACE RBRACE;

classDecl: CLASS ID (EXTENDS ID)? LBRACE (varDecl)* (methodDecl)* RBRACE;

varDecl: type ID SEMI;

methodDecl:
	PUBLIC type ID LPAREN formalList RPAREN LBRACE (varDecl)* (
		statement
	)* RETURN expression SEMI RBRACE;

formalList: type ID (formalRest)* |;
formalRest: COMMA type ID;

type: INT LBRACK RBRACK | INT | ID | BOOLEAN;

statement:
	LBRACE (statement)* RBRACE
	| IF LPAREN expression RPAREN statement ELSE statement
	| WHILE LPAREN expression RPAREN statement
	| SOUT LPAREN expression RPAREN SEMI
	| ID ASSIGN expression SEMI
	| ID LBRACK expression RBRACK ASSIGN expression SEMI;

expression:
	expression (AND | LT | GT | ADD | SUB | MUL) expression
	| expression LBRACK expression RBRACK
	| expression DOT LENGTH

	| expression DOT ID LPAREN (expression (COMMA expression)*)? RPAREN
	| INTEGER_LITERAL
	| TRUE
	| FALSE
	| ID
	| THIS
	| NEW INT LBRACK expression RBRACK
	| NEW ID LPAREN RPAREN
	| NOT expression
	| LPAREN expression RPAREN;


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