using Superpower;
using Superpower.Display;
using Superpower.Model;
using Superpower.Parsers;
using Superpower.Tokenizers;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Text;
using System.Xml;

namespace KParser
{
    public enum KToken
    {
        // Punctuation:

        LParam,
        RParam,
        Comma,
        Colon,
        Period,

        // Number:

        Number,

        // Operation:

        ExecInstr,
        UpdateMap,
        ConcatenateMInt,
        ExtractMInt,
        GetParentValue,
        AndMInt,
        Mi,
        NegMInt,
        ShiftLeftMInt,
        UValueMInt,
        AddMInt,
        SubMInt,
        LeftShitMInt,

        // Symbol Operators:

        /// <summary>
        /// |->
        /// </summary>
        AssignExpr,

        /// <summary>
        /// =>
        /// </summary>
        ForwardExpr,

        // Keywords:
        Rule,
        KBegin,
        KEnd,
        DotOperands,
        RegStateBegin,
        RegStateEnd,
        MapState, // RSMap:Map
        RsMap,

        // Descriptor:
        Imm,
        Mem,
        Rh,
        R8,
        R16,
        R32,
        R64,
        Xmm,
        Mm,
        Ymm,

        // OperandValue:
        R1,
        R2,
        R3,

        // Instruction:
        Andb,

        // Flag:
        CF,
        PF,
        AF,
        ZF,
        SF,
        OF,
    }

    public enum TokenKind
    {
        /// <summary>
        /// Built in functions(e.g concatenateMInt, getParentValue)
        /// </summary>
        Operation,

        /// <summary>
        /// 
        /// </summary>
        ControlFlow,

        /// <summary>
        /// Symbol operators(e.g |->, =>)
        /// </summary>
        Symbol,

        /// <summary>
        /// KFramework specific keywords(e.g rule, RSMap:Map, RSMap)
        /// </summary>
        Keyword,

        /// <summary>
        /// Target (e.g R8, R8, R16, Xmm, Mm, etc)
        /// </summary>
        Descriptor,

        /// <summary>
        /// Describes an operand(e.g R1, R2, R3)
        /// </summary>
        OperandValue,

        /// <summary>
        /// x86_64 instruction
        /// </summary>
        Instruction,

        /// <summary>
        /// x86 Flag
        /// </summary>
        Flag,

        Punctuation,
        Number,
    }

    public class Token
    {
        public KToken identifier;
        public TokenKind kind;
        public object value;

        public Token(KToken _identifier, TokenKind _kind, object _value)
        {
            identifier = _identifier;
            kind = _kind;
            value = _value;
        }
    }

    class TokenInfo
    {
        public string tokenName;
        public KToken identifier;
        public TokenKind kind;

        public TokenInfo(string _name, KToken _identifier, TokenKind _kind)
        {
            tokenName = _name;
            identifier = _identifier;
            kind = _kind;
        }
    }

    class KLexer
    {
        static List<TokenInfo> TokenInfos = new List<TokenInfo>()
        {
            // Operations:
            new TokenInfo("execinstr", KToken.ExecInstr, TokenKind.Operation),
            new TokenInfo("updateMap", KToken.UpdateMap, TokenKind.Operation),
            new TokenInfo("concatenateMInt", KToken.ConcatenateMInt, TokenKind.Operation),
            new TokenInfo("extractMInt", KToken.ExtractMInt, TokenKind.Operation),
            new TokenInfo("getParentValue", KToken.GetParentValue, TokenKind.Operation),
            new TokenInfo("andMInt", KToken.AndMInt, TokenKind.Operation),
            new TokenInfo("negMInt", KToken.NegMInt, TokenKind.Operation),
            new TokenInfo("shiftLeftMInt", KToken.ShiftLeftMInt, TokenKind.Operation),
            new TokenInfo("uvalueMInt", KToken.UValueMInt, TokenKind.Operation),
            new TokenInfo("mi", KToken.Mi, TokenKind.Operation),
            new TokenInfo("addMInt", KToken.AddMInt, TokenKind.Operation),
            new TokenInfo("subMInt", KToken.SubMInt, TokenKind.Operation),
            new TokenInfo("lshrMInt", KToken.LeftShitMInt, TokenKind.Operation),
            //new TokenInfo("mulMInt", KToken.SubMInt, TokenKind.Operation),
            //new TokenInfo("svalueMInt", KToken.SubMInt, TokenKind.Operation),
       


            // Symbols
            new TokenInfo("|->", KToken.AssignExpr, TokenKind.Symbol),
            new TokenInfo("=>", KToken.ForwardExpr, TokenKind.Symbol),

            // Keywords
            new TokenInfo("rule", KToken.Rule, TokenKind.Keyword),
            new TokenInfo("<k>", KToken.KBegin, TokenKind.Keyword),
            new TokenInfo("...</k>", KToken.KEnd, TokenKind.Keyword),
            new TokenInfo(".Operands", KToken.DotOperands, TokenKind.Keyword),
            new TokenInfo("<regstate>", KToken.RegStateBegin, TokenKind.Keyword),
            new TokenInfo("</regstate>", KToken.RegStateEnd, TokenKind.Keyword),
            new TokenInfo("RSMap:Map", KToken.MapState, TokenKind.Keyword),
            new TokenInfo("RSMap", KToken.RsMap, TokenKind.Keyword),

            // Descriptors
            new TokenInfo("Imm", KToken.Imm, TokenKind.Descriptor),
            new TokenInfo("Mem", KToken.Mem, TokenKind.Descriptor),
            new TokenInfo("Rh", KToken.Rh, TokenKind.Descriptor),
            new TokenInfo("R8", KToken.R8, TokenKind.Descriptor),
            new TokenInfo("R16", KToken.R16, TokenKind.Descriptor),
            new TokenInfo("R32", KToken.R32, TokenKind.Descriptor),
            new TokenInfo("R64 ", KToken.R64, TokenKind.Descriptor),
            new TokenInfo("Xmm", KToken.Xmm, TokenKind.Descriptor),
            new TokenInfo("Mm", KToken.Mm, TokenKind.Descriptor),
            new TokenInfo("Ymm", KToken.Ymm, TokenKind.Descriptor),

            // Operand Values:
            new TokenInfo("R1", KToken.R1, TokenKind.OperandValue),
            new TokenInfo("R2", KToken.R2, TokenKind.OperandValue),
            new TokenInfo("R3", KToken.R3, TokenKind.OperandValue),

            // Punctuation
            new TokenInfo("(", KToken.LParam, TokenKind.Punctuation),
            new TokenInfo(")", KToken.RParam, TokenKind.Punctuation),
            new TokenInfo(",", KToken.Comma, TokenKind.Punctuation),
            new TokenInfo(":", KToken.Colon, TokenKind.Punctuation),
            new TokenInfo(".", KToken.Period, TokenKind.Punctuation),
        };

        private List<Token> MatchTokensInString(string text)
        {
            List<Token> tokens = new List<Token>();

            // iterate through to text until we've matched all tokens
            while(text.Length > 0)
            {
                bool bMatchedToken = false;
                foreach (var info in TokenInfos)
                {
                    if (text.StartsWith(info.tokenName))
                    {
                        //Console.WriteLine("found token: " + info.tokenName);
                        bMatchedToken = true;

                        // pop token off buffer, store it, and break out of the loop
                        text = text.Substring(info.tokenName.Length, text.Length - info.tokenName.Length);
                        tokens.Add(new Token(info.identifier, info.kind, 0));
                        break;
                    }

                    else if(Char.IsDigit(text.First()))
                    {
                        // Iterate through the string and read until you find a nondigit character.
                        int digitCount = 0;
                        string textNumber = String.Empty;
                        foreach(var c in text)
                        {
                            if(Char.IsDigit(c))
                            {
                                textNumber += c;
                                digitCount++;
                            }

                            else
                            {
                                break;
                            }
                        }
                        
                        // pop the number off the buffer and store it
                        bMatchedToken = true;
                        text = text.Substring(digitCount, text.Length - digitCount);
                        tokens.Add(new Token(KToken.Number, TokenKind.Number, int.Parse(textNumber)));
                        break;
                    }
                }

                // bail if we could not identify any tokens
                if(!bMatchedToken)
                    throw new Exception(String.Format("Failed to tokenize string: {0}", new string(text)));
            }

            return tokens;
        }

        public List<Token> TokenizeAll(string text)
        {
            List<Token> tokens = new List<Token>();

            // Temporary fix for multiline statements
            text = text.Replace("\n", "");
            text = text.Replace("\r", "");

            // Split the source text by whitespaces and remove empty entries
            var splitText = text.Split(' ', StringSplitOptions.RemoveEmptyEntries);

            // Identify all tokens and store them
            foreach (var split in splitText)
            {
               tokens.AddRange(MatchTokensInString(split));
            }

            return tokens;
        }
    }


}
