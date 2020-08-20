using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KParser
{
    public enum ExpressionType
    {
        ConcatenateMInt,
        ExtractMInt,
        GetParentValue,
    }

    public enum ParameterType
    {
        Integer,
        Expression,
        OperandValue,
    }

    // Represents any KFramework operation like getParentValue(R2, RSMap)
    public class Expression
    {
        public Token expressionToken;
        public List<KeyValuePair<object, Token>> parameters = new List<KeyValuePair<object, Token>>();
    }

    class Parser
    {
        int currentIndex = 0;

        /// <summary>
        /// Attempts to parse a basic
        /// </summary>
        /// <param name="tokens"></param>
        /// <param name="currentExpression"></param>
        /// <returns></returns>
        public Expression ParseExpression(List<Token> tokens, Expression currentExpression)
        {
            //var expressionType = OperationTokenToExpressionType(tokens.ElementAt(currentIndex));

            // set the current expressions token if it hasn't already been set
            if (currentExpression.expressionToken == null)
                currentExpression.expressionToken = tokens[currentIndex];
            else
                throw new Exception("Parsing error. Attempted to overwrite expression's token");
            
            // skip the expression token so we don't end up endlessly parsing the expression
            currentIndex++;

            // Iterate through all tokens and attempt to parse the expression. TODO: Handle edge cases with #IfMint, etc.
            while (currentIndex < tokens.Count)
            {
                var token = tokens[currentIndex];
                if (token.kind == TokenKind.Operation)
                {
                    var newExpression = new Expression();
                    newExpression = ParseExpression(tokens, newExpression);
                    currentExpression.parameters.Add(new KeyValuePair<object, Token>(newExpression, token));
                }

                else if(token.kind == TokenKind.Number)
                {
                    currentExpression.parameters.Add(new KeyValuePair<object, Token>((int)token.value, token));
                }

                else if(token.kind == TokenKind.OperandValue)
                {
                    currentExpression.parameters.Add(new KeyValuePair<object, Token>(token.identifier, token));
                }

                else if(token.identifier == KToken.RsMap)
                {
                    currentExpression.parameters.Add(new KeyValuePair<object, Token>(token.identifier, token));
                }

                else if(token.identifier == KToken.RParam)
                {
                    // Closing param == finished expression
                    return currentExpression;
                }
                currentIndex++;
            }

            return currentExpression;
        }

        public void RecursiveLogExpression(Expression expression)
        {
            Console.WriteLine("Operation: {0}", expression.expressionToken.identifier);
            foreach(var param in expression.parameters)
            {
                Console.WriteLine("Parameter {0} with value {1}", param.Key, param.Value);
            }

            foreach(var param in expression.parameters.Where(x => x.Value.kind == TokenKind.Operation))
            {
                RecursiveLogExpression((Expression)param.Key);
            }
        }

        public Expression ParseTokens(List<Token> tokens)
        {
            var expression = ParseExpression(tokens, new Expression());
            RecursiveLogExpression(expression);
            return expression;  
        }
    }
}
