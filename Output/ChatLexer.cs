//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     ANTLR Version: 4.8
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

// Generated from C:/Users/colton/.IdeaIC2019.2/config/scratches\Chat.g4 by ANTLR 4.8

// Unreachable code detected
#pragma warning disable 0162
// The variable '...' is assigned but its value is never used
#pragma warning disable 0219
// Missing XML comment for publicly visible type or member '...'
#pragma warning disable 1591
// Ambiguous reference in cref attribute
#pragma warning disable 419

using System;
using System.IO;
using System.Text;
using Antlr4.Runtime;
using Antlr4.Runtime.Atn;
using Antlr4.Runtime.Misc;
using DFA = Antlr4.Runtime.Dfa.DFA;

[System.CodeDom.Compiler.GeneratedCode("ANTLR", "4.8")]
[System.CLSCompliant(false)]
public partial class ChatLexer : Lexer {
	protected static DFA[] decisionToDFA;
	protected static PredictionContextCache sharedContextCache = new PredictionContextCache();
	public const int
		NUMBER=1, WHITESPACE=2, LPARAM=3, RPARAM=4, Comma=5, GETPARENTVALUE=6, 
		EXTRACTMINT=7, MI=8, ADDMINT=9;
	public static string[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static string[] modeNames = {
		"DEFAULT_MODE"
	};

	public static readonly string[] ruleNames = {
		"NUMBER", "WHITESPACE", "LPARAM", "RPARAM", "Comma", "GETPARENTVALUE", 
		"EXTRACTMINT", "MI", "ADDMINT"
	};


	public ChatLexer(ICharStream input)
	: this(input, Console.Out, Console.Error) { }

	public ChatLexer(ICharStream input, TextWriter output, TextWriter errorOutput)
	: base(input, output, errorOutput)
	{
		Interpreter = new LexerATNSimulator(this, _ATN, decisionToDFA, sharedContextCache);
	}

	private static readonly string[] _LiteralNames = {
		null, null, "' '", "'('", "')'", "','", "'getParentValue'", "'extractMInt'", 
		"'mi'", "'addMInt'"
	};
	private static readonly string[] _SymbolicNames = {
		null, "NUMBER", "WHITESPACE", "LPARAM", "RPARAM", "Comma", "GETPARENTVALUE", 
		"EXTRACTMINT", "MI", "ADDMINT"
	};
	public static readonly IVocabulary DefaultVocabulary = new Vocabulary(_LiteralNames, _SymbolicNames);

	[NotNull]
	public override IVocabulary Vocabulary
	{
		get
		{
			return DefaultVocabulary;
		}
	}

	public override string GrammarFileName { get { return "Chat.g4"; } }

	public override string[] RuleNames { get { return ruleNames; } }

	public override string[] ChannelNames { get { return channelNames; } }

	public override string[] ModeNames { get { return modeNames; } }

	public override string SerializedAtn { get { return new string(_serializedATN); } }

	static ChatLexer() {
		decisionToDFA = new DFA[_ATN.NumberOfDecisions];
		for (int i = 0; i < _ATN.NumberOfDecisions; i++) {
			decisionToDFA[i] = new DFA(_ATN.GetDecisionState(i), i);
		}
	}
	private static char[] _serializedATN = {
		'\x3', '\x608B', '\xA72A', '\x8133', '\xB9ED', '\x417C', '\x3BE7', '\x7786', 
		'\x5964', '\x2', '\v', 'J', '\b', '\x1', '\x4', '\x2', '\t', '\x2', '\x4', 
		'\x3', '\t', '\x3', '\x4', '\x4', '\t', '\x4', '\x4', '\x5', '\t', '\x5', 
		'\x4', '\x6', '\t', '\x6', '\x4', '\a', '\t', '\a', '\x4', '\b', '\t', 
		'\b', '\x4', '\t', '\t', '\t', '\x4', '\n', '\t', '\n', '\x3', '\x2', 
		'\x6', '\x2', '\x17', '\n', '\x2', '\r', '\x2', '\xE', '\x2', '\x18', 
		'\x3', '\x3', '\x3', '\x3', '\x3', '\x3', '\x3', '\x3', '\x3', '\x4', 
		'\x3', '\x4', '\x3', '\x5', '\x3', '\x5', '\x3', '\x6', '\x3', '\x6', 
		'\x3', '\a', '\x3', '\a', '\x3', '\a', '\x3', '\a', '\x3', '\a', '\x3', 
		'\a', '\x3', '\a', '\x3', '\a', '\x3', '\a', '\x3', '\a', '\x3', '\a', 
		'\x3', '\a', '\x3', '\a', '\x3', '\a', '\x3', '\a', '\x3', '\b', '\x3', 
		'\b', '\x3', '\b', '\x3', '\b', '\x3', '\b', '\x3', '\b', '\x3', '\b', 
		'\x3', '\b', '\x3', '\b', '\x3', '\b', '\x3', '\b', '\x3', '\b', '\x3', 
		'\t', '\x3', '\t', '\x3', '\t', '\x3', '\n', '\x3', '\n', '\x3', '\n', 
		'\x3', '\n', '\x3', '\n', '\x3', '\n', '\x3', '\n', '\x3', '\n', '\x2', 
		'\x2', '\v', '\x3', '\x3', '\x5', '\x4', '\a', '\x5', '\t', '\x6', '\v', 
		'\a', '\r', '\b', '\xF', '\t', '\x11', '\n', '\x13', '\v', '\x3', '\x2', 
		'\x3', '\x3', '\x2', '\x32', ';', '\x2', 'J', '\x2', '\x3', '\x3', '\x2', 
		'\x2', '\x2', '\x2', '\x5', '\x3', '\x2', '\x2', '\x2', '\x2', '\a', '\x3', 
		'\x2', '\x2', '\x2', '\x2', '\t', '\x3', '\x2', '\x2', '\x2', '\x2', '\v', 
		'\x3', '\x2', '\x2', '\x2', '\x2', '\r', '\x3', '\x2', '\x2', '\x2', '\x2', 
		'\xF', '\x3', '\x2', '\x2', '\x2', '\x2', '\x11', '\x3', '\x2', '\x2', 
		'\x2', '\x2', '\x13', '\x3', '\x2', '\x2', '\x2', '\x3', '\x16', '\x3', 
		'\x2', '\x2', '\x2', '\x5', '\x1A', '\x3', '\x2', '\x2', '\x2', '\a', 
		'\x1E', '\x3', '\x2', '\x2', '\x2', '\t', ' ', '\x3', '\x2', '\x2', '\x2', 
		'\v', '\"', '\x3', '\x2', '\x2', '\x2', '\r', '$', '\x3', '\x2', '\x2', 
		'\x2', '\xF', '\x33', '\x3', '\x2', '\x2', '\x2', '\x11', '?', '\x3', 
		'\x2', '\x2', '\x2', '\x13', '\x42', '\x3', '\x2', '\x2', '\x2', '\x15', 
		'\x17', '\t', '\x2', '\x2', '\x2', '\x16', '\x15', '\x3', '\x2', '\x2', 
		'\x2', '\x17', '\x18', '\x3', '\x2', '\x2', '\x2', '\x18', '\x16', '\x3', 
		'\x2', '\x2', '\x2', '\x18', '\x19', '\x3', '\x2', '\x2', '\x2', '\x19', 
		'\x4', '\x3', '\x2', '\x2', '\x2', '\x1A', '\x1B', '\a', '\"', '\x2', 
		'\x2', '\x1B', '\x1C', '\x3', '\x2', '\x2', '\x2', '\x1C', '\x1D', '\b', 
		'\x3', '\x2', '\x2', '\x1D', '\x6', '\x3', '\x2', '\x2', '\x2', '\x1E', 
		'\x1F', '\a', '*', '\x2', '\x2', '\x1F', '\b', '\x3', '\x2', '\x2', '\x2', 
		' ', '!', '\a', '+', '\x2', '\x2', '!', '\n', '\x3', '\x2', '\x2', '\x2', 
		'\"', '#', '\a', '.', '\x2', '\x2', '#', '\f', '\x3', '\x2', '\x2', '\x2', 
		'$', '%', '\a', 'i', '\x2', '\x2', '%', '&', '\a', 'g', '\x2', '\x2', 
		'&', '\'', '\a', 'v', '\x2', '\x2', '\'', '(', '\a', 'R', '\x2', '\x2', 
		'(', ')', '\a', '\x63', '\x2', '\x2', ')', '*', '\a', 't', '\x2', '\x2', 
		'*', '+', '\a', 'g', '\x2', '\x2', '+', ',', '\a', 'p', '\x2', '\x2', 
		',', '-', '\a', 'v', '\x2', '\x2', '-', '.', '\a', 'X', '\x2', '\x2', 
		'.', '/', '\a', '\x63', '\x2', '\x2', '/', '\x30', '\a', 'n', '\x2', '\x2', 
		'\x30', '\x31', '\a', 'w', '\x2', '\x2', '\x31', '\x32', '\a', 'g', '\x2', 
		'\x2', '\x32', '\xE', '\x3', '\x2', '\x2', '\x2', '\x33', '\x34', '\a', 
		'g', '\x2', '\x2', '\x34', '\x35', '\a', 'z', '\x2', '\x2', '\x35', '\x36', 
		'\a', 'v', '\x2', '\x2', '\x36', '\x37', '\a', 't', '\x2', '\x2', '\x37', 
		'\x38', '\a', '\x63', '\x2', '\x2', '\x38', '\x39', '\a', '\x65', '\x2', 
		'\x2', '\x39', ':', '\a', 'v', '\x2', '\x2', ':', ';', '\a', 'O', '\x2', 
		'\x2', ';', '<', '\a', 'K', '\x2', '\x2', '<', '=', '\a', 'p', '\x2', 
		'\x2', '=', '>', '\a', 'v', '\x2', '\x2', '>', '\x10', '\x3', '\x2', '\x2', 
		'\x2', '?', '@', '\a', 'o', '\x2', '\x2', '@', '\x41', '\a', 'k', '\x2', 
		'\x2', '\x41', '\x12', '\x3', '\x2', '\x2', '\x2', '\x42', '\x43', '\a', 
		'\x63', '\x2', '\x2', '\x43', '\x44', '\a', '\x66', '\x2', '\x2', '\x44', 
		'\x45', '\a', '\x66', '\x2', '\x2', '\x45', '\x46', '\a', 'O', '\x2', 
		'\x2', '\x46', 'G', '\a', 'K', '\x2', '\x2', 'G', 'H', '\a', 'p', '\x2', 
		'\x2', 'H', 'I', '\a', 'v', '\x2', '\x2', 'I', '\x14', '\x3', '\x2', '\x2', 
		'\x2', '\x4', '\x2', '\x18', '\x3', '\b', '\x2', '\x2',
	};

	public static readonly ATN _ATN =
		new ATNDeserializer().Deserialize(_serializedATN);


}
