parser grammar projectParser;

options {
  tokenVocab = projectScanner;
}

program     : statement*                        #progAST;
statement   : LET letStatement                  #stLetAST
            | RETURN returnStatement            #stReturnAST
            | expressionStatement               #stExpressAST;
letStatement: IDENTIFIER ASSIGN expression (PyCOMMA | ) #letStatementAST;
returnStatement: expression (PyCOMMA | ) #returnStatementAST;
expressionStatement: expression (PyCOMMA | ) #expressionStatementAST;
expression : additionExpression comparison #expressionAST;
comparison : ((MENOR|MAYOR|MAYORIGUAL|MAYORIGUAL|IGUAL) additionExpression)* #comparisonAST;
additionExpression  : multiplicationExpression additionFactor   #additionExpressionAST;
additionFactor     : ((SUM|SUB) multiplicationExpression)*  #additionFactorAST;
multiplicationExpression    : elementExpression multiplicationFactor    #multiplicationExpressionASP;
multiplicationFactor        : ((MUL|DIV) elementExpression)*    #multiplicationFactorASP;
elementExpression           : primitiveExpression (elementAccess | callExpression | );
elementAccess               : PCIZQ expression PCDER;
callExpression              : PIZQ expressionList PDER;
primitiveExpression         : INTEGER
                            | STRING
                            | IDENTIFIER
                            |TRUE
                            | FALSE
                            | PIZQ expression PDER
                            | arrayLiteral
                            | arrayFunctions PIZQ expressionList PDER
                            | functionLiteral
                            | hashLiteral
                            | printExpression
                            | ifExpression;
arrayFunctions              : LEN | FIRST | LAST | REST | PUSH;
arrayLiteral                : PCIZQ expressionList PCDER;
functionLiteral             : FN PIZQ functionParameters PDER blockStatement;
functionParameters          : IDENTIFIER moreIdentifiers;
moreIdentifiers             : (COMMA IDENTIFIER)*;
hashLiteral                 : LLAVEIZQ hashContent moreHashContent LLAVEDER;
hashContent                 : expression DOSPUN expression;
moreHashContent             : (COMMA hashContent)*;
expressionList              : expression moreExpressions | ;
moreExpressions             : (COMMA expression)*;
printExpression             : PUTS PIZQ expression PDER;
ifExpression                : IF expression blockStatement (ELSE blockStatement | );
blockStatement              : LLAVEIZQ statement* LLAVEDER;