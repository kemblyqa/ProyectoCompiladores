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
expression : additionExpression (COMPARATOR additionExpression)* #expressionAST;
additionExpression  :ADDOPERATOR* multiplicationExpression (ADDOPERATOR multiplicationExpression)*  #additionExpressionAST;
multiplicationExpression    : elementExpression (MULOPERATOR elementExpression)*    #multiplicationExpressionASP;
elementExpression           : elementExpression elementAccess     #eleExpEleAcc
                            | elementExpression callExpression    #eleExpCall
                            | primitiveExpression                   #eleExpPriOnly;
elementAccess               : PCIZQ expression PCDER    #elementAccessASP;
callExpression              : PIZQ expressionList PDER  #callExpressionASP;
primitiveExpression         : INTEGER   #pExprIntASP
                            | STRING    #pExpStrASP
                            | IDENTIFIER #pExpIDASP
                            | TRUE           #pExpTrueASP
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
functionParameters          : IDENTIFIER (COMMA IDENTIFIER)*    #functionParametersASP;
hashLiteral                 : LLAVEIZQ hashContent (COMMA hashContent)* LLAVEDER #hashLiteralASP;
hashContent                 : expression DOSPUN expression  #hashContentASP;
expressionList              : expression (COMMA expression)* #expressionListF;
printExpression             : PUTS PIZQ expression PDER #printExpressionASP;
ifExpression                : IF expression blockStatement ((ELSE blockStatement) | ) #ifExpressionASP;
blockStatement
locals [boolean returns = false]
: LLAVEIZQ statement* LLAVEDER  #blockStatementASP;