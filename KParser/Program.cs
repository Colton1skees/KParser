using Superpower.Parsers;
using System;
using System.Collections.Generic;
using System.Collections.Specialized;
using System.IO;
using System.Linq;
using System.Runtime.InteropServices;

namespace KParser
{
    class Program
    {

        static void CompletenessTest()
        {
             var fileNames = Directory.GetFiles(@"C:\Users\colton\Desktop\registerInstructions");
           // var fileNames = new List<string>() { @"C:\Users\colton\Desktop\registerInstructions\imulw_r16_r16.k" };
            var files = fileNames.Select(x => File.ReadAllLines(x));

            int successful = 0;
            int count = 0;
            foreach(var fileName in fileNames)
            {
                string[] fileLines = File.ReadAllLines(fileName);
               // Console.WriteLine("file lines: " + fileLines.Count());
                for (int i = 0; i < 10; i++)
                {
                   // Console.WriteLine("");
                }
                var targetLines = fileLines.Where(x => x.Contains("convToRegKeys") && x.Contains("|->"));
                foreach (var targetLine in targetLines)
                {
                    var source = targetLine.Split("|->", StringSplitOptions.RemoveEmptyEntries)[1];
                   // Console.WriteLine("source: " + source);

                    for(int i = 0; i < 10; i++)
                    {
                     //   Console.WriteLine("");
                    }
                  
                    try
                    {
                        KLexer lexer = new KLexer();
                        var tokens = lexer.TokenizeAll(source);

                        Parser parser = new Parser();
                        var expression = parser.ParseTokens(tokens);

                        KToVTIL converter = new KToVTIL();
                        converter.GenerateSymEx(expression);

                        successful++;
                       // Console.WriteLine("Successfully parsed semantics: {0} \n  {1}", fileName,  source);
                        //Console.WriteLine("Successfully parsed semantics: {0}", fileNames.ElementAt(count));

                     
                    }

                    catch(Exception ex)
                    {
                        Console.WriteLine("failed to semantics: {0} \n  {1}", "", source);
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

        static void Main(string[] args)
        {
            // source: https://github.com/kframework/X86-64-semantics/blob/master/semantics/registerInstructions/andb_r8_r8.k
            string source = @"concatenateMInt( extractMInt( getParentValue(R1, RSMap), 0, 56), subMInt( extractMInt( getParentValue(R1, RSMap), 56, 64), mi(8, 1)))";
            //string source = @"concatenateMInt( extractMInt( getParentValue(R2, RSMap), 0, 56), andMInt( extractMInt( getParentValue(R2, RSMap), 56, 64), extractMInt( getParentValue(R1, RSMap), 56, 64)))";
            //string source = @"concatenateMInt( extractMInt( getParentValue(R2, RSMap), 0, 56), andMInt( extractMInt( getParentValue(R2, RSMap), 56, 64), extractMInt( getParentValue(R1, RSMap), 56, 64)))";
            //string source = @" concatenateMInt( extractMInt( getParentValue(R2, RSMap), 0, 56), extractMInt( getParentValue(R1, RSMap), 56, 64))";
            //string source = @"concatenateMInt( mi(32, 0), extractMInt( getParentValue(R1, RSMap), 32, 64))";
            Console.WriteLine("source: {0}", source);
            KLexer lexer = new KLexer();
            var tokens = lexer.TokenizeAll(source);
            foreach(var token in tokens)
            {
                if(token.kind == TokenKind.Number)
                    Console.WriteLine("Token: {0}, Kind: {1}", (int)token.value, token.kind);
                else
                    Console.WriteLine("Token: {0}, Kind: {1}", token.identifier, token.kind);
            }

            Parser parser = new Parser();
            var expression = parser.ParseTokens(tokens);

            KToVTIL converter = new KToVTIL();
           // converter.GenerateSymEx(expression);

            CompletenessTest();
            Console.ReadLine();
        }
    }
}
