grammar KGram;

/* Required preprocessing to make parsing successful:
    1. Replace all calls to execinstr() with nop()
    2. Put commas at the end of all flag write expressions
*/

// TODO: Modify grammar so that preprocessing is not necessary

expression : BEGIN_RULE expression END_RULE                        #RuleExpression
           | BEGIN_REGSTATE expression END_REGSTATE                #RegstateExpression
           | LPARAM expression RPARAM                              #ParenthesizedExpression
           | expression ':' ID                                     #PostedfixedExpression // This handles edge cases like memLoadValue(Mem32:MInt):MemLoadValue. TODO: Validate and ensure it is applicable in edge cases like this.
           | expression '|->' expression                           #AssignmentExpression
           | IF expression THEN expression (ELSE  expression)? FI  #IfExpression
           | ID LPARAM (expression (COMMA expression)*)? RPARAM    #CallExpression
           | expression BOOL_BIN_OP expression                     #BinaryBoolExpression
           | BOOL_UNARY_OP expression                              #UnaryBoolExpression
           | expression FORWARD_OPERATOR expression                #ForwarderExpression
           | STRING                                                #StringExpression
           | NUMBER                                                #IntegerExpression
           | ID                                                    #IdentifierExpression
           | '.'                                                   #EmptyExpression
           ;



// Initialization / State constructs
BEGIN_RULE : 'rule <k>';
END_RULE : '...</k>';
FORWARD_OPERATOR : '=>' | '~>';
BEGIN_REGSTATE : '<regstate>';
END_REGSTATE : '</regstate>';

// Expression constructs
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
ID          : ([a-zA-Z][a-zA-Z0-9]+) | (([a-zA-Z][a-zA-Z0-9]+) ':' ([a-zA-Z][a-zA-Z0-9]+)) | ('%' ID); // The second option is a giant hack to allow instruction references like adc:Opcode

WS          : [ \t\r\n]+ -> skip ;

root: expression;
