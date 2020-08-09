using Superpower.Parsers;
using System;
using System.Runtime.InteropServices;

namespace KParser
{
    class Program
    {
        static void Main(string[] args)
        {
            // source: https://github.com/kframework/X86-64-semantics/blob/master/semantics/registerInstructions/addb_r8_r8.k
            string source = @" concatenateMInt( extractMInt( getParentValue(R2, RSMap), 0, 56), extractMInt( addMInt( concatenateMInt( mi(1, 0), extractMInt( getParentValue(R1, RSMap), 56, 64)), concatenateMInt( mi(1, 0), extractMInt( getParentValue(R2, RSMap), 56, 64))), 1, 9))";
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
            parser.ParseTokens(tokens);
        }
    }
}
