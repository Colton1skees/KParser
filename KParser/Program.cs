
using Antlr4.Runtime.Misc;
using Antlr4.Runtime.Tree;
using KDetails;
using Superpower.Model;
using Superpower.Parsers;
using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.Data;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;
using System.Text;

namespace KParser
{

    class CodeGen
    {
        private string indent;

        private StringBuilder code = new StringBuilder();

        bool hasIndentedOnCurrentLine = false;

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

    class Program
    {

        static void CompletenessTest()
        {
             var fileNames = Directory.GetFiles(@"C:\Users\colton\Desktop\registerInstructions");
            fileNames = fileNames.Where(x => !x.Contains("xmm") && !x.Contains("ymm")).ToArray(); // ignore fpu operations
 
            var files = fileNames.Select(x => File.ReadAllLines(x));

            int successful = 0;
            int count = 0;
            foreach(var fileName in fileNames)
            {
                string[] fileLines = File.ReadAllLines(fileName);
                var targetLines = fileLines.Where(x => x.Contains("convToRegKeys") && x.Contains("|->"));
                foreach (var targetLine in targetLines)
                {
                    var source = targetLine.Split("|->", StringSplitOptions.RemoveEmptyEntries)[1];
                    try
                    {
                        Antlr4.Runtime.ICharStream target = new Antlr4.Runtime.AntlrInputStream(source);
                        Antlr4.Runtime.ITokenSource lexer = new KDetails.KGramLexer(target);
                        Antlr4.Runtime.ITokenStream tokens = new Antlr4.Runtime.CommonTokenStream(lexer);
                        KDetails.KGramParser parser = new KDetails.KGramParser(tokens);
                        parser.BuildParseTree = true;

                        var root = parser.root();
                        SymbolicExpressionBuilder symex = new SymbolicExpressionBuilder(root);
                        var expression = symex.BuildExpression();
                        successful++;
                    }

                    catch(Exception ex)
                    {
                        Console.WriteLine("failed to parse semantics: {0} \n  {1}", "", source);
                        for(int i = 0; i < 2; i++)
                        {
                            Console.WriteLine();
                        }
                    }

                    count++;
                }
            }

            Console.WriteLine("success count: {0}", successful );
            Console.WriteLine("total items parsed: {0}", count);
            Console.WriteLine("success percent: {0}%", ((float)successful / (float)count) * 100);
        }
        static void Test()
        {
            string source = @"concatenateMInt( mi(32, 0), extractMInt( getParentValue(%rax, RSMap), 32, 64))";
            Antlr4.Runtime.ICharStream target = new Antlr4.Runtime.AntlrInputStream(source);
            Antlr4.Runtime.ITokenSource lexer = new KDetails.KGramLexer(target);
            Antlr4.Runtime.ITokenStream tokens = new Antlr4.Runtime.CommonTokenStream(lexer);
            KDetails.KGramParser parser = new KDetails.KGramParser(tokens);
            parser.BuildParseTree = true;
         
            var root = parser.root();
            SymbolicExpressionBuilder symex = new SymbolicExpressionBuilder(root);
            var expression = symex.BuildExpression();

            Console.WriteLine("Generated Symbolic Expression: \n{0}", expression);

            //CompletenessTest();
        } 

        static void Main(string[] args)
        {
            Test();
            Console.ReadLine();
        }
    }
}
