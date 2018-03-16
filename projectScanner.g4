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

//caracteres
PyCOMMA : ';';
ASSIGN  : '=';
PIZQ : '(';
PDER : ')';
PCIZQ: '[';
PCDER: ']';
LLAVEIZQ: '{';
LLAVEDER: '}';
VIR : '~';
DOSPUN  : ':';
COMMA   : ',';

//accionesArray
LEN     : 'len';
FIRST   : 'first';
LAST    : 'last';
REST    : 'rest';
PUSH    : 'push';
FN      : 'fn';
PUTS    : 'puts';
IF      : 'if';
ELSE    : 'else';

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
ARRAY   : '[' (INTEGER | STRING) (',' (INTEGER | STRING))* ']';
STRING  : '"' .*? '"';
INTEGER : DIGIT+;
IDENTIFIER  : LETTER (LETTER | DIGIT)*;
//tipos
fragment LETTER : 'a'..'z' | 'A'..'Z'| '_';
fragment DIGIT : '0'..'9';
