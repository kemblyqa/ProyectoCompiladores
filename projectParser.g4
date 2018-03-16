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
elementExpression           : primitiveExpression (elementAccess | callExpression | )   #elementExpressionASP;
elementAccess               : PCIZQ expression PCDER    #elementAccessASP;
callExpression              : PIZQ expressionList PDER  #callExpressionASP;
primitiveExpression         : INTEGER   #pExprIntASP
                            | STRING    #pExpStrASP
                            | IDENTIFIER #pExpIDASP
                            |TRUE           #pExpTrueASP
                            | FALSE         #pExpFalseASP
                            | PIZQ expression PDER  #pExpParExpParASP
                            | arrayLiteral          #pExpArrayLitASP
                            | arrayFunctions PIZQ expressionList PDER #pExpArrayFuncASP
                            | functionLiteral   #pExpFunLitASP
                            | hashLiteral       #pExpHashLitASP
                            | printExpression   #pExpPrintExpASP
                            | ifExpression  #pExpIfASP;
arrayFunctions              : LEN | FIRST | LAST | REST | PUSH  #arrayFunctionsASP;
arrayLiteral                : PCIZQ expressionList PCDER    #arrayLiteralASP;
functionLiteral             : FN PIZQ functionParameters PDER blockStatement    #functionLiteralASP;
functionParameters          : IDENTIFIER moreIdentifiers    #functionParametersASP;
moreIdentifiers             : (COMMA IDENTIFIER)*   #moreIdentifiersASP;
hashLiteral                 : LLAVEIZQ hashContent moreHashContent LLAVEDER #hashLiteralASP;
hashContent                 : expression DOSPUN expression  #hashContentASP;
moreHashContent             : (COMMA hashContent)*  #moreHashContentASP;
expressionList              : expression moreExpressions #expressionListF| #expressionListE;
moreExpressions             : (COMMA expression)*   #moreExpressionsASP;
printExpression             : PUTS PIZQ expression PDER #printExpressionASP;
ifExpression                : IF expression blockStatement (ELSE blockStatement | ) #ifExpressionASP;
blockStatement              : LLAVEIZQ statement* LLAVEDER  #blockStatementASP;