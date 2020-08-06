/*
 * Parser Rules
 */
grammar Gdsl;
//Types must be to find before first use variables must be defined before first use
gdsl: (typeDefinition | functionDefinition | variableDefinition)* ;

typeDefinition: TYPE id=IDENTIFIER '(' declaration (',' declaration)* ')' ;

functionDefinition: retType=IDENTIFIER functionId=IDENTIFIER '(' (declaration (',' declaration)* )? ')' scope ;

declaration: id=IDENTIFIER ':' type=IDENTIFIER ;

scope: statement
     | '(' statement* ')' ;

statement: conditionalIf
         | switchCase
         | variableDefinition
         | returnStatement ;

variableDefinition: declaration ASSIGNMENT expression ;

returnStatement: 'return' expression;

switchCase: 'switch' (variables (',' variables)*) ('case' expression ':' scope)* ;

conditionalIf: IF '(' condition=expression ')' trueBranch=scope #ifStatement
             | IF '(' condition=expression ')' trueBranch=scope ELSE (elseIfStatement=conditionalIf)? falseBranch=scope #ifElseStatement;

setElementDefinition: localName=IDENTIFIER IN globalName=expression ;

expression: '(' expression ')' #parenthesisExp
          | '|' expression '|' #absoluteExp
          | setL=expression operator=(UNION | DIFFERENCE | INTERSECTION) setR=expression #setOperatorExp
          | quantifier=QUANTIFIER '(' setElementDefinition ',' expression ')' #setQuantificationCallExp
          | CHOOSE expression #setChooseExp // Selects an element from a set
          | expression POWER expression #powerExp
          | expression operator=(DIVISION | MULTIPLICATION) expression #divMulExp
          | expression operator=(ADD | SUB) expression #addSubExp
          | expression operator=COMPARISON expression #comparisonExp
          | expression AND expression #andExp
          | expression OR expression #orExp
          | '{' setElementDefinition ('|' expression)? '|' expression '}'#setComprehensionExp
          | '{' expression  (',' expression)* '}'#setLiteralExp
          | IDENTIFIER '(' (expression (',' expression)*)? ')' #functionCallExp
          | expression '.' IDENTIFIER #dotExp
          | IDENTIFIER #variableExp
          | bool=BOOL #boolExp
          | NUMBER #numberExp ;

variables: IDENTIFIER ('.' IDENTIFIER)*;

/*
 * Lexer Rules
 */
TYPE: 'type' ;

BOOL: 'true' | 'false';
QUANTIFIER: 'exist'
          | 'all'
          | 'select' ;

IF: 'if' ;
ELSE: 'else' ;

COMPARISON: '=='
          | '!='
          | '>='
          | '<='
          | '>'
          | '<' ;

ADD: '+' ;
SUB: '-' ;
DIVISION: '/' ;
MULTIPLICATION: '*' ;
POWER: '^'
     | '**' ;

AND: '&&'
   | 'and' ;
OR: '||'
  | 'or' ;

ASSIGNMENT: ':=' ;

UNION:'UNION';
DIFFERENCE: 'DIFF' ;
INTERSECTION: 'INTER';
FILLER: 'FILLER' ;
CHOOSE: 'CHOOSE' ;
IN: 'in' ;

NUMBER: ([0-9])* '.' ([0-9])+
      | ([0-9])+;

IDENTIFIER: ([a-z] | [A-Z])+ ([a-zA-Z_0-9])* ;

WS: [ \t\n\r]+ -> skip ;
COMMENTS: '//' ~[\n]+ -> skip ;
COMMENTANALYZE: '//¤ANALYZE' ~[rn]+ -> channel(HIDDEN) ;
