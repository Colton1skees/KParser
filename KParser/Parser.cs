using System;
using System.Collections.Generic;
using System.Globalization;
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

    public class ControlFlowExpression
    {
        /// <summary>
        /// Expression which represents a given conditional(e.g #ifMInt eqMInt(mi(1,1)), mi(1,1)).
        /// </summary>
        public Expression condition;

        /// <summary>
        /// Expression which is executed if the condition is met.
        /// </summary>
        public Expression taken;

        /// <summary>
        /// Expression which is executed if the condition is not met.
        /// </summary>
        public Expression notTaken;
    }

    /// <summary>
    /// Represents a KFramework operation(e.g getParentValue, eqMInt, etc).
    /// </summary>
    public class Expression
    {
        public Token expressionToken;
        public List<KeyValuePair<object, Token>> parameters = new List<KeyValuePair<object, Token>>();
    }

    enum CurrentControlFlow
    {
        None,
        If,
        Else,
        Then,
    }

    /// <summary>
    /// Deprecated parser.
    /// </summary>
    class Parser
    {
        int currentIndex = 0;

        Stack<Expression> controlFlowStack = new Stack<Expression>() {};

        private CurrentControlFlow GetControlFlow(Token token)
        {
            switch (token.identifier)
            {
                case KToken.IfMInt:
                    return CurrentControlFlow.If;
                case KToken.Else:
                    return CurrentControlFlow.Else;
                case KToken.Then:
                    return CurrentControlFlow.Then;
                default:
                    return CurrentControlFlow.None;
            }
        }

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
            {
                currentExpression.expressionToken = tokens[currentIndex];
            }
            else
            {
                throw new Exception("Parsing error. Attempted to overwrite expression's token");
            }
            
            // skip the expression token so we don't end up endlessly parsing the expression
            currentIndex++;

            // Iterate through all tokens and attempt to parse the expression. TODO: Handle edge cases with #IfMint, etc.
            while (currentIndex < tokens.Count)
            {
                var token = tokens[currentIndex];
                if (token.kind == TokenKind.Operation)
                {
 
                    if (token.identifier == KToken.IfMInt)
                    {
                        var newExpression = new Expression();
                        newExpression = ParseControlFlowExpression(tokens, newExpression);

                        currentExpression.parameters.Add(new KeyValuePair<object, Token>((Expression)newExpression, token));

                    }
                    
                    else if(token.identifier == KToken.Else || token.identifier == KToken.Then)
                    {
                        /*
                        Console.WriteLine("parsing: {0}", token.identifier);
                        var newExpression = new Expression();
                        newExpression = ParseControlFlowExpression(tokens, newExpression);
                        return newExpression;
                        */
                    }

                    else if(token.identifier == KToken.EndIf)
                    {

                    }


                    else
                    {
                        var newExpression = new Expression();
                        newExpression = ParseExpression(tokens, newExpression);
                        currentExpression.parameters.Add(new KeyValuePair<object, Token>(newExpression, token));
                    }
                }

                else if(token.kind == TokenKind.Number)
                {
                    currentExpression.parameters.Add(new KeyValuePair<object, Token>((int)token.value, token));
                }

                else if(token.kind == TokenKind.Descriptor)
                {
                    currentExpression.parameters.Add(new KeyValuePair<object, Token>(token.identifier, token));
                }

                else if(token.identifier == KToken.RsMap)
                {
                    currentExpression.parameters.Add(new KeyValuePair<object, Token>(token.identifier, token));
                }

                else if(token.identifier == KToken.RParam)
                {
          
                   // Console.WriteLine("ending expression with toklen: {0}", currentExpression.expressionToken.identifier);
                    // Closing param == finished expression
                    
                    return currentExpression;
                }

                currentIndex++;
            }

            return currentExpression;
        }

        public Expression ParseControlFlowExpression(List<Token> tokens, Expression controlFlowExpression)
        {
   
            var token = tokens[currentIndex];
            if (controlFlowExpression.expressionToken == null)
            {
                controlFlowExpression.expressionToken = token;
            }
            else
            {
                throw new Exception("Parsing error. Attempted to overwrite expression's token");
            }

            // keep parsing until the control flow expression has been
            while (currentIndex < tokens.Count)
            {
                token = tokens[currentIndex];
                currentIndex++;


                if(token.identifier == KToken.EndIf)
                {
                    break;
                }

                if(token.kind == TokenKind.Operation)
                {
                   // Console.WriteLine("TOKEN PARSINGG");
                    if (token.identifier == KToken.IfMInt)
                    {
                       // Console.WriteLine("1 parsing ifmint");

                        var newExpression = new Expression();
                        newExpression = ParseExpression(tokens, newExpression);
                        controlFlowExpression.parameters.Add(new KeyValuePair<object, Token>(newExpression, token));

                    }

                    else if (token.identifier == KToken.Then || token.identifier == KToken.Else)
                    {
                       // Console.WriteLine("parsing branch: {0}", token.identifier);
                        var newExpression = new Expression();
                        newExpression = ParseExpression(tokens, newExpression);
                        controlFlowExpression.parameters.Add(new KeyValuePair<object, Token>(newExpression, token));

                    }

                    else
                    {
                        throw new Exception(String.Format("Invalid token passed to ParseControlFlow: {0}", token.identifier));
                    }
                }

                else
                {
                    if(token.identifier == KToken.RParam)
                    {
                       // Console.WriteLine("HANDLING RPARAM");
                        //currentIndex++;
                       // return controlFlowExpression;
                    }

                    else
                    {
                        throw new Exception(String.Format("invalid token: {0}", token.identifier));
                    }
                   // Console.WriteLine("invalid token: {0}", token.identifier);

                   // currentIndex++;
                    //return controlFlowExpression;

                }
            }
            
            return controlFlowExpression;
        }



        public void RecursiveLogExpression(Expression expression)
        {
            Console.WriteLine("Operation: {0}", expression.expressionToken.identifier);
            foreach(var param in expression.parameters)
            {
                object value = param.Value;

                Console.WriteLine("Parameter {0} with value {1}", param.Key, param.Value.identifier);

            }

            foreach(var param in expression.parameters.Where(x => x.Value.kind == TokenKind.Operation))
            {
                RecursiveLogExpression((Expression)param.Key);
            }

            /*
            if(expression.expressionToken.identifier == KToken.IfMInt && expression.parameters.Count == 3)
            {
                Console.WriteLine("found target expr");
                foreach(var param in expression.parameters)
                {
                    Console.WriteLine("logging expr");
                    RecursiveLogExpression((Expression)param.Key);
                }
            }
            */
        }

        public Expression ParseTokens(List<Token> tokens)
        {
            var expression = ParseExpression(tokens, new Expression());
            RecursiveLogExpression(expression);
            return expression;  
        }
    }
}
