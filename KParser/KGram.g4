grammar KGram;

expression : LPARAM expression RPARAM                              #ParenthesizedExpression
           | IF expression THEN expression (ELSE  expression)? FI  #IfExpression
           | ID LPARAM (expression (COMMA expression)*)? RPARAM    #CallExpression
           | expression BOOL_BIN_OP expression                     #BinaryBoolExpression

           | BOOL_UNARY_OP expression                              #UnaryBoolExpression
           | STRING                                                #StringExpression
           | NUMBER                                                #IntegerExpression
           | ID                                                    #IdentifierExpression
           ;

IF          : '#ifMInt';
THEN        : '#then';
ELSE        : '#else';
FI          : '#fi';
LPARAM      : '(';
RPARAM      : ')';
COMMA       : ',';
BOOL_BIN_OP : '==Bool' | '!=Bool' | 'andBool' | 'orBool' | 'xorBool';
BOOL_UNARY_OP: 'notBool';

STRING      : ('"' ~["]* '"') | '%' STRING;
NUMBER      : [0-9]+;
ID          : ([a-zA-Z][a-zA-Z0-9]+) | ('%' ID);

WS          : [ \t\r\n]+ -> skip ;

root: expression;