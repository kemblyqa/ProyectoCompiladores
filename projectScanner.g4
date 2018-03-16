lexer grammar projectScanner;
WS : [ \t\n\r]+ -> skip;

//COMENTARIOS
LINE_COMMENT : '//' ~[\r\n]* -> skip;
FULL_COMMENT :  '/*' .*? '*/' -> skip;

//palabras
TRUE    : 'true';
FALSE   : 'false';
LET     : 'let';
RETURN  : 'return';
INTEGER : 'Integer';
STRING  : 'String';
IDENTIFIER : 'identifier';

//accionesArray
LEN     : 'len';
FIRST   : 'first';
LAST    : 'last';
REST    : 'rest';
PUSH    : 'push';
FN      : 'fn';

//caracteres
PyCOMMA : ';';
ASSIGN  : '=';
PIZQ : '(';
PDER : ')';
PCIZQ: '[';
PCDER: ']';
LLAVEIZQ: '{';
LLAVEDER: '}';
PUTS    : 'puts';
IF      : 'if';
ELSE    : 'else';
VIR : '~';
DOSPUN  : ':';
COMMA   : ',';

//OPERADORES
SUM : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MENOR       : '<';
MENORIGUAL  : '<=';
MAYOR       : '>';
MAYORIGUAL  : '>=';
IGUAL       : '==';
DISTINTO    : '!=';
//cadenas
ARRAY   : '[' (TyINTEGER | TySTRING) (',' (TyINTEGER | TySTRING))* ']';
TySTRING  : '"' .*? '"';
TyINTEGER : DIGIT+;
//tipos
LETTER  : [a-z A-Z _];
DIGIT   : [0-9];
ID      : LETTER {LETTER | DIGIT};
