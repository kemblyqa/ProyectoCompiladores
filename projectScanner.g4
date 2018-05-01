lexer grammar projectScanner;

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
COMILLA : '"';

WS : [ \t\n\r]+ -> skip;

//COMENTARIOS
FULL_COMMENT : '/*' (FULL_COMMENT|.)*? '*/' -> skip ;
LINE_COMMENT  : '//' .*? '\n' -> skip ;

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
ADDOPERATOR: ('+' | '-');
MULOPERATOR: ('*' | '/');
COMPARATOR :  ('<' | '>' | '<=' | '>=' | '==' | '!=');
//cadenas
STRING  : COMILLA ( ~["\r\n] | '""' )* COMILLA ;
INTEGER : DIGIT+;
IDENTIFIER  : LETTER (LETTER | DIGIT)*;
//tipos
fragment LETTER : 'a'..'z' | 'A'..'Z'| '_';
fragment DIGIT : '0'..'9';
