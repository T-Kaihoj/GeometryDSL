/*
 * Parser Rules
 */
grammar Gdsl;
//Types must be to find before first use variables must be defined before first use
gdsl: (typeDefinition | functionDefinition | variableDefinition)* ;

typeDefinition: TYPE id=IDENTIFIER '(' declaration (',' declaration)* ')' ;

functionDefinition: functionDeclaration scope ;

functionDeclaration: retType=IDENTIFIER functionId=IDENTIFIER '(' (declaration (',' declaration)* )? ')' ;

declaration: id=IDENTIFIER ':' type=IDENTIFIER ;

scope: statement
     | '(' statement* ')' ;

statement: iif
            | switchCase
            | variableDefinition
            | returnStatement ;

variableDefinition: declaration ASSIGNMENT expression ;

returnStatement: 'return' expression;

switchCase: 'switch'(variables ( ','variables)*) ('case' expression ':' scope)*;

iif: IFT '(' expression ')' scope (iifElset)* elset? ;
iifElset: (IFELSET '(' expression ')' scope);
elset: ELSET scope;

setElementDefinition:localName=IDENTIFIER IN globalName=expression ;


expression:
        '(' expression ')' #parenthesisExp
        | '|' expression '|' #absoluteExp
        | setL=expression operator=(UNION | DIFFERENCE| INTERSECTION) setR=expression #setOperatorExp
        | quantifier=QUANTIFIER '(' setElementDefinition ','  expression ')' #setQuantificationCallExp
        //Selects an element from a set
        | CHOOSE expression  #setChooseExp
        | expression POWER expression #powerExp
        | expression operator=(DIVISION | MULTIPLICATION) expression #divMulExp
        | expression operator=(ADD | SUB) expression #addSubExp
        | expression operator=COMPARISON expression #comparisonExp
        | expression AND expression #andExp
        | expression OR expression #orExp
        | '{' setElementDefinition ('|' )? '|' expression '}'#setComprehensionExp
        | '{' expression  (',' expression )* '}'#setLiteralExp
        | IDENTIFIER '(' (expression (',' expression)*)? ')' #functionCallExp
        | expression ('.' IDENTIFIER)+ #dotExp
        | IDENTIFIER  #variableExp
        | BOOL #boolExp
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

TYPE: 'type' ;

//addSub
ADD: '+' ;
SUB: '-' ;

BOOL: 'true' |'false';
QUANTIFIER: 'exist'
          | 'all'
          | 'select' ;

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




NUMBER: ([0-9])* '.'([0-9])+
 |([0-9])+;

IDENTIFIER: ([a-z] | [A-Z])+ ([a-zA-Z_0-9])* ;

WS: [ \t\n\r]+ -> skip ;

COMMENTANALYZE: '//¤ANALYZE' ~[rn]+ -> channel(HIDDEN) ;

COMMENTS: '//' ~[\n]+ -> skip ;
