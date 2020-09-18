/*
 * Parser Rules
 */
grammar Gdsl;
// Types and variables must be defined before first use
gdsl: (typeDefinition | functionDefinition | variableDefinition)* ;

typeDefinition: TYPE id=IDENTIFIER '(' declaration (',' declaration)* ')' ;

functionDefinition: retType=IDENTIFIER functionId=IDENTIFIER '(' (declaration (',' declaration)* )? ')' scope ;

number: INTEGER
      | FLOAT ;

declaration: id=IDENTIFIER ':' type=IDENTIFIER ;

scope: statement
     | '(' statement* ')' ;

statement: conditionalIf
         | switchCase
         | variableDefinition
         | returnStatement ;

variableDefinition: declaration ASSIGNMENT expression ;

returnStatement: RETURN expression;

switchCase: 'switch' '(' ('case' expression '=>' scope)*  ('default' '=>'defaultscope= scope)? ')' ;

conditionalIf: IF '(' condition=expression ')' trueBranch=scope #ifStatement
             | IF '(' condition=expression ')' trueBranch=scope ELSE (elseIfStatement=conditionalIf)? falseBranch=scope #ifElseStatement;

setElementDefinition: localName=IDENTIFIER IN globalName=expression ;

expression: '(' expression ')' #parenthesisExp
          | '|' expression '|' #absoluteExp
          | expression '.' IDENTIFIER #dotExp
          | NOT expression #notExp
          | setL=expression operator=(UNION | DIFFERENCE | INTERSECTION) setR=expression #setOperatorExp
          | quantifier=QUANTIFIER '(' setElementDefinition ',' expression ')' #setQuantificationExp
          | extractor=EXTRACTOR '(' setElementDefinition ',' expression ')' #setExtractionExp
          | expression POWER expression #powerExp
          | expression operator=(DIVISION | MULTIPLICATION) expression #divMulExp
          | expression operator=(ADD | SUB) expression #addSubExp
          | expression operator=COMPARISON expression #comparisonExp
          | expression AND expression #andExp
          | expression OR expression #orExp
          | '{' setElementDefinition ('|' expression)? '|' expression '}'#setComprehensionExp
          | '{' expression  (',' expression)* '}'#setLiteralExp
          | IDENTIFIER '(' (expression (',' expression)*)? ')' #functionCallExp
          | IDENTIFIER #variableExp
          | bool=BOOL #boolExp
          | num=number #numberExp ;

/*
 * Lexer Rules
 */
TYPE: 'type' ;

BOOL: 'true'
    | 'false';
QUANTIFIER: 'exist'
          | 'all';
EXTRACTOR: 'select'
         | 'choose' ;

IF: 'if' ;
ELSE: 'else' ;

RETURN: 'return' ;

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
NOT: '!'
   | 'not' ;

ASSIGNMENT: ':=' ;

UNION: 'union' ;
DIFFERENCE: 'diff' ;
INTERSECTION: 'inter' ;
IN: 'in' ;

INTEGER: ([0-9])+ ;
FLOAT: ([0-9])* '.' ([0-9])+ ;
IDENTIFIER: ([a-z] | [A-Z])+ ([a-zA-Z_0-9])* ;

WS: [ \t\n\r]+ -> skip ;
COMMENTS: '//' ~[\n]+ -> skip ;
COMMENTANALYZE: '//¤ANALYZE' ~[rn]+ -> channel(HIDDEN) ;
