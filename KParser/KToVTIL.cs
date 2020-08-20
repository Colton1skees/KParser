using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Security.Claims;
using System.Text;

namespace KParser
{

    class CodeGenerator
    {
        private string indent;

        private StringBuilder code = new StringBuilder();

        bool hasIndentedOnCurrentLine = false;

        public void AddIndent(int count = 0)
        {
            while(count > 0)
            {
                count--;
                indent += "    ";
            }
        }

        public void RemoveIndent(int count = 1)
        {
            while(count > 0)
            {
                count--;
                indent = indent.Substring(0, indent.Length - 4);
            }
        }

        public void AppendLine(string text)
        {
            code.AppendLine(indent + text);
        }

        public void Append(string text)
        {
            code.Append(indent + text);
        }

        public void AppendFormat(string text, params object[] args)
        {
            code.AppendFormat(indent + text, args);
        }

        public override string ToString()
        {
            return code.ToString();
        }
    }

    class KToVTIL
    {
        public CodeGenerator code;

        Expression initialExpression;

        string vtilExpressionType = "vtil::symbolic::expression";

        int localVariableCount = 0;

        /// <summary>
        /// Take a parsed expression and generate code to create a VTIL symbolic expression
        /// </summary>
        /// <param name="expression"></param>
        public void GenerateSymEx(Expression expression)
        {
            code = new CodeGenerator();
            initialExpression = expression;

            CreateMethodBody();
            GenerateCode(expression);
            code.AppendLine("");
            CreateMethodEpilogue();
            Console.WriteLine("generated code: ");
            Console.WriteLine(code.ToString());
        }

        private void CreateMethodBody()
        {
            code.AppendLine("void GenerateExpression(int64_t r1, int64_t r2)");
            code.AddIndent();
            code.AppendLine("{");
            code.AddIndent();

            code.AppendLine(string.Format("{0} expr_r1 = ", vtilExpressionType) + "{ r1 }");
            code.AppendLine(string.Format("{0} expr_r2 = ", vtilExpressionType) + "{ r2 }");
        }

        private void CreateMethodEpilogue()
        {
            //code.RemoveIndent();
            code.AppendLine("}");
           // code.RemoveIndent();
        }

        /// <summary>
        /// Generate code to retrieve the result of an expression and return the name of the variable storing the result
        /// </summary>
        /// <param name="expression"></param>
        /// <returns></returns>
        private string GenerateCode(Expression expression)
        {
            // recursively iterate through all parameters that are expressions and store the result
            List<string> expressionResults = new List<string>();
            foreach (var param in expression.parameters.Where(x => x.Value.kind == TokenKind.Operation))
            {
                expressionResults.Add(GenerateCode((Expression)param.Key));
            }

            KeyValuePair<object, Token> param1 = new KeyValuePair<object, Token>();
            KeyValuePair<object, Token> param2 = new KeyValuePair<object, Token>();
            KeyValuePair<object, Token> param3 = new KeyValuePair<object, Token>();

            for (int i = 0; i < expression.parameters.Count; i++)
            {
                if (i == 0)
                {
                    param1 = expression.parameters[0];
                }

                else if (i == 1)
                {
                    param2 = expression.parameters[1];
                }

                else if (i == 2)
                {
                    param3 = expression.parameters[2];
                }
            }

            // create local variable to store result
            string variableName = "result" + localVariableCount;
            localVariableCount++;

            // generate code to represent and store the result of the expression
            switch (expression.expressionToken.identifier)
            {
                case KToken.ExtractMInt:
                    int start = (int)param2.Key;
                    int end = (int)param3.Key;
                    int difference = end - start;


                    code.AppendFormat("{0} {1} = ({2} >> {3}).resize({4})", vtilExpressionType, variableName, expressionResults.First(), start, difference);
                    break;

                case KToken.GetParentValue:
                    if (param1.Value.identifier == KToken.R1 || )
                    {
                        return "expr_r1";
                    }

                    else if (param1.Value.identifier == KToken.R2)
                    {
                        return "expr_r2";
                    }
                    break;

                case KToken.AndMInt:
                    code.AppendFormat("{0} {1} = {2} & {3}", vtilExpressionType, variableName, expressionResults[0], expressionResults[1]);
                    break;

                case KToken.ConcatenateMInt:
                    // operate under the assumption that MInt is always 64 bits wide.
                    code.AppendFormat("{0} {1} = ({2} & vtil::math::fill({3}.size())) | ({4} & vtil::math::fill({5}.size()))", vtilExpressionType, variableName, expressionResults[0], expressionResults[0], expressionResults[1], expressionResults[1]);
                    //code.AppendFormat("{0} {1} = ({2} & vtil::math::fill({3}, {4)) | ({4} & vtil::math:fill)");
                    break;

                case KToken.Mi:
                    code.AppendFormat("{0} {1} = {2}({3}).resize({4})", vtilExpressionType, variableName, vtilExpressionType, (int)param2.Key, (int)param1.Key);
                    break;

                case KToken.AddMInt:
                    code.AppendFormat("{0} {1} = {2} + {3}", vtilExpressionType, variableName, expressionResults[0], expressionResults[1]);
                    break;

                case KToken.NegMInt:
                    code.AppendFormat("{0} {1} = -{2}", vtilExpressionType, variableName, expressionResults[0]);
                    break;

                case KToken.SubMInt:
                   // code.AppendFormat("{0} {1} = {2} - {3}", vtilExpressionType, variableName, expressionResults[0], expressionResults[1]);
                    break;

                case KToken.LeftShitMInt: // lshrMInt   logical shift: filling with zeros. TODO: Doublecheck that VTIL lshift fills with zeroes
                    code.AppendFormat("{0} {1} = {2} << {3}", vtilExpressionType, variableName, expressionResults[0], (int)param2.Value);
                    break;

                default:
                    throw new Exception(String.Format("Unsupported expression token: {0}", expression.expressionToken.identifier));
            }

            code.Append("; \n");
            return variableName;
        }
    }
}
