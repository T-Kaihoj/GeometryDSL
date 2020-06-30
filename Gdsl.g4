/*
 * Parser Rules
 */
grammar Gdsl;
//Types must be to find before first use variables must be defined before first use
gdsl: (typeDefinition | functionDefinition |variableDefinition)* ;

typeDefinition: TYPE id=IDENTIFIER '(' declaration (',' declaration)* ')' ;

functionDefinition: functionDeclaration scope ;

functionDeclaration: retType=IDENTIFIER id=IDENTIFIER '(' (declaration (',' declaration)* )? ')' ;

declaration: id=IDENTIFIER ':' valType=IDENTIFIER ;

scope: statement
     | '(' statement* ')' ;

statement: conditional
         | variableDefinition
         | returnStatement ;

variableDefinition: declaration ASSIGNMENT expression ;

returnStatement: 'return' expression;

conditional: iif | caseswitch ;

caseswitch: 'switch'(variables ( ','variables)*) ('case' expression ':' scope)*;

iif: IFT '(' expression ')' scope (iifElset)* elset? ;
iifElset: (IFELSET '(' expression ')' scope);
elset: ELSET scope;



expressionIN:localName=IDENTIFIER IN global=IDENTIFIER ;


expression:
        '(' expression ')' #parenthesisExp
        |'|' expression '|' #absoluteExp
        |setL=Expression operator=(UNION | DIFFERENCE| INTERSECTION) setR=Expression #setOperator
        | quantifier=QUANTIFIER'('expressionIN','  expression ')' #setQuantificationCallExp
        | CHOOSE expression  #setChooseExp
        | expression (POWER) expression #powerExp
        | expression operator=(DIVISION | MULTIPLICATION) expression #divMulExp
        | expression operator=(ADD | SUB) expression #addSubExp
        | expression (COMPARISON) expression #comparisonExp
        | expression (AND) expression #andExp
        | expression (OR) expression #orExp
        | '{' expressionIN ('|'  )? '|' expression '}'#
        | '{' expression  (',' expression )* '}'#setLiteral
        | IDENTIFIER '(' (expression (',' expression)*)? ')' #functionCallExp
        | IDENTIFIER ('.' IDENTIFIER)* #variableExp
        | NUMBER #numberExp ;

variables: IDENTIFIER ('.' IDENTIFIER)*;


/*
 * Lexer Rules
 */
fragment A: ('A'|'a') ;
fragment D: ('D'|'d') ;
fragment E: ('E'|'e') ;
fragment F: ('F'|'f') ;
fragment I: ('I'|'i') ;
fragment L: ('L'|'l') ;
fragment N: ('N'|'n') ;
fragment O: ('O'|'o') ;
fragment P: ('P'|'p') ;
fragment R: ('R'|'r') ;
fragment S: ('S'|'s') ;
fragment T: ('T'|'t') ;
fragment Y: ('Y'|'y') ;

IFT: I F;
IFELSET: E L S E' ' I F ; //'if'|'else'|'ifelse';

ELSET: E L S E ;

TYPE: T Y P E ;

//addSub
ADD: '+' ;

SUB: '-' ;

COMPARISON: '=='
          | '!='
          | '>='
          | '<='
          | '>'
          | '<';

POWER: '^'
     | '**' ;

DIVISION: '/' ;

MULTIPLICATION: '*' ;

AND: '&&'
   | A N D ;

OR: '||'
  | O R ;

ASSIGNMENT: ':=' ;

UNION:'UNION';
DIFFERENCE: 'DIFF' ;
INTERSECTION: 'INTER';
FILLER: 'FILLER' ;
CHOOSE: 'CHOOSE' ;

IN: 'in' ;




NUMBER: ([0-9])+('.'([0-9])*)? ;

IDENTIFIER: ([a-z] | [A-Z])+ ([a-zA-Z_0-9])* ;

WS: [ \t\n\r]+ -> skip ;

COMMENTANALYZE: '//¤ANALYZE' ~[rn]+ -> channel(HIDDEN) ;

COMMENTS: '//' ~[\n]+ -> skip ;
