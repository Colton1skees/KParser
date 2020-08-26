using Antlr4.Runtime.Misc;
using KDetails;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace KParser
{
    class CodeBuilder
    {
        private string indent;

        private StringBuilder builder = new StringBuilder();

        bool hasIndentedOnCurrentLine = false;

        int localVariableCount = 0;

        string vtilExpressionType = "vtil::symbolic::expression";

        public void AddIndent(int count = 0)
        {
            while (count > 0)
            {
                count--;
                indent += "    ";
            }
        }

        public void RemoveIndent(int count = 1)
        {
            while (count > 0)
            {
                count--;
                indent = indent.Substring(0, indent.Length - 4);
            }
        }

        public void AppendLine(string text)
        {
            builder.AppendLine(indent + text);
        }

        public void Append(string text)
        {
            builder.Append(indent + text);
        }

        public void AppendFormat(string text, params object[] args)
        {
            builder.AppendFormat(indent + text, args);
        }

        public override string ToString()
        {
            return builder.ToString();
        }

        /// Create a local variable to store the given input and returns the variable name.
        /// </summary>
        /// <param name="text">Value format string</param>
        /// <param name="args"></param>
        /// <returns></returns>
        public string AppendSymbolicVariable(string text, params object[] args)
        {
            localVariableCount++;
            string variableName = "result" + localVariableCount;
            builder.AppendFormat("{0} {1} = ", vtilExpressionType, variableName);
            builder.AppendFormat(text, args);
            builder.Append(';');
            builder.AppendLine();
            return variableName;
        }
    }

    class SymbolicListener : KDetails.KGramBaseListener
    {
        public CodeBuilder code = new CodeBuilder();

        Dictionary<Antlr4.Runtime.ParserRuleContext, string> variables = new Dictionary<Antlr4.Runtime.ParserRuleContext, string>();

        public override void EnterIdentifierExpression([NotNull] KGramParser.IdentifierExpressionContext context)
        {
            var text = context.GetText();

            string reg = String.Empty;
            if (text.Contains("%"))
                reg = text.Substring(1).ToUpper();

            switch (text)
            {
                // source regs
                case "R1":
                    variables.Add(context, "expr_r1");
                    break;
                case "R2":
                    variables.Add(context, "expr_r2");
                    break;

                // explicitly referenced regs
                case "%rax":
                    {
                        string result = code.AppendSymbolicVariable("vtil::symbolic::expression(vtil::symbolic::variable(operand(X86_REG_{0}).reg()), 64)", reg);
                        variables.Add(context, result);
                        break;
                    }

                case "%rcx":
                    {
                        string result = code.AppendSymbolicVariable("vtil::symbolic::expression(vtil::symbolic::variable(operand(X86_REG_{0}).reg()), 64)", reg);
                        variables.Add(context, result);
                        break;
                    }

                case "%rdx":
                    {
                        string result = code.AppendSymbolicVariable("vtil::symbolic::expression(vtil::symbolic::variable(operand(X86_REG_{0}).reg()), 64)", reg);
                        variables.Add(context, result);
                        break;
                    }
            }
        }

        public override void ExitStringExpression([NotNull] KGramParser.StringExpressionContext context)
        {
            switch (context.GetText())
            {
                case "\"CF\"":
                    variables.Add(context, "CF");
                    break;
                case "\"PF\"":
                    variables.Add(context, "PF");
                    break;
                case "\"AF\"":
                    variables.Add(context, "AF");
                    break;
                case "\"ZF\"":
                    variables.Add(context, "ZF");
                    break;
                case "\"SF\"":
                    variables.Add(context, "SF");
                    break;
                case "\"OF\"":
                    variables.Add(context, "OF");
                    break;
 
            }
        }

        public override void ExitIntegerExpression([NotNull] KGramParser.IntegerExpressionContext context)
        {
            variables.Add(context, context.GetText());
        }

        public override void ExitCallExpression([NotNull] KGramParser.CallExpressionContext context)
        {
            // getParentValue(65, 55)
            switch (context.ID().GetText())
            {
                case "getParentValue":
                    {
                        var register = variables[context.expression(0)];
                        //var source = variables[context.expression(1)];

                        variables.Add(context, register);
                        break;
                    }

                // bits 56-64 == lowest bits in expr? Bits may need to be reversed. TODO: Validate
                case "extractMInt":
                    {
                        var source = variables[context.expression(0)];
                        var start = variables[context.expression(1)];
                        var end = variables[context.expression(2)];
                        string result = code.AppendSymbolicVariable("({0} >> {1}).resize({2})", source, start, (Int32.Parse(end) - Int32.Parse(start)));
                        variables.Add(context, result);
                        break;
                    }

                case "concatenateMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("({0} & vtil::math::fill({1}.size())) | ({2} & vtil::math::fill({3}.size()))", expr1, expr1, expr2, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "mi":
                    {
                        var width = variables[context.expression(0)];
                        var value = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0}({1}).resize({2})", "vtil::symbolic::expression", value, width);
                        variables.Add(context, result);
                        break;
                    }

                case "addMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} + {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "subMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} - {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "negMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        string result = code.AppendSymbolicVariable("-{0}", expr1);
                        variables.Add(context, result);
                        break;
                    }

                // TODO: Validate
                case "lshrMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} >> {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                // Doesn't seem to be documented either. Seems to be an arithmetic shift: filling with leftmost bit(sign extension). Almost 100% sure the current implementation is wrong
                case "aShiftRightMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} >> {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                // The shiftLeftMInt operator isn't documented. Output may be incorrect. TODO: Validate
                case "shiftLeftMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} << {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "xorMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} ^ {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "andMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} & {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                // TODO: Properly handle signed/unsigned interpretations.
                case "uvalueMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        string result = code.AppendSymbolicVariable("{0} // Unsigned interpretation. Output may be incorrect", expr1);
                        variables.Add(context, result);
                        break;
                    }

                case "svalueMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        string result = code.AppendSymbolicVariable("{0} // Signed interpretation. Output may be incorrect", expr1);
                        variables.Add(context, result);
                        break;
                    }

                case "eqMInt":
                    {
                        var expr1 = variables[context.expression(0)];
                        var expr2 = variables[context.expression(1)];
                        string result = code.AppendSymbolicVariable("{0} == {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }


                case "getFlag":
                    {
                        var flagName = variables[context.expression(0)];
                        string result = code.AppendSymbolicVariable("vtil::symbolic::expression(vtil::symbolic::variable(operand(vtil::lifter::amd64::flags::{0}).reg()), 1)", flagName);
                        variables.Add(context, result);
                        break;
                    }

            }
        }

        public override void ExitBinaryBoolExpression([NotNull] KGramParser.BinaryBoolExpressionContext context)
        {
            var expr1 = variables[context.expression(0)];
            var expr2 = variables[context.expression(1)];
            switch (context.BOOL_BIN_OP().GetText())
            {
                case "==Bool":
                    {
                        string result = code.AppendSymbolicVariable("{0} == {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "=/=Bool":
                    {
                        string result = code.AppendSymbolicVariable("{0} != {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "andBool":
                    {
                        string result = code.AppendSymbolicVariable("{0} & {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "xorBool":
                    {
                        string result = code.AppendSymbolicVariable("{0} ^ {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }

                case "orBool":
                    {
                        string result = code.AppendSymbolicVariable("{0} | {1}", expr1, expr2);
                        variables.Add(context, result);
                        break;
                    }
            }
        }

        public override void ExitUnaryBoolExpression([NotNull] KGramParser.UnaryBoolExpressionContext context)
        {
            var expr1 = variables[context.expression()];
            switch (context.BOOL_UNARY_OP().GetText())
            {
                case "notBool":
                    {
                        string result = code.AppendSymbolicVariable("~{0}", expr1);
                        variables.Add(context, result);
                        break;
                    }
            }
        }

        public override void ExitIfExpression([NotNull] KGramParser.IfExpressionContext context)
        {
            var conditional = variables[context.expression(0)];
            var condThen = variables[context.expression(1)];
            var condElse = variables[context.expression(2)];
            string result = code.AppendSymbolicVariable("__if({0}, {1}) | __if(~({2}), {3})", conditional, condThen, conditional, condElse);
            variables.Add(context, result);
        }

        public override void ExitParenthesizedExpression([NotNull] KGramParser.ParenthesizedExpressionContext context)
        {
            variables.Add(context, variables[context.expression()]);
        }
    }

    public class SymbolicExpressionBuilder
    {
        KDetails.KGramParser.RootContext rootContext;

        public SymbolicExpressionBuilder(KDetails.KGramParser.RootContext _rootContext)
        {
            rootContext = _rootContext;
        }

        public string BuildExpression()
        {
            SymbolicListener listener = new SymbolicListener();
            Antlr4.Runtime.Tree.ParseTreeWalker walker = new Antlr4.Runtime.Tree.ParseTreeWalker();
            walker.Walk(listener, rootContext);
            return listener.code.ToString();
        }


    }
}
