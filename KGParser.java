// Generated from KG.g4 by ANTLR 4.8
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KGParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, T__61=62, T__62=63, T__63=64, T__64=65, T__65=66, 
		T__66=67, T__67=68, T__68=69, T__69=70, T__70=71, T__71=72, T__72=73, 
		T__73=74, T__74=75, T__75=76, T__76=77, T__77=78, T__78=79, T__79=80, 
		T__80=81, T__81=82, T__82=83, T__83=84, T__84=85, T__85=86, T__86=87, 
		T__87=88, T__88=89, T__89=90, T__90=91, T__91=92, T__92=93, T__93=94, 
		T__94=95, T__95=96, T__96=97, T__97=98, T__98=99, T__99=100, T__100=101, 
		T__101=102, T__102=103, T__103=104, T__104=105, T__105=106, T__106=107, 
		T__107=108, T__108=109, T__109=110, T__110=111, T__111=112, T__112=113, 
		T__113=114, T__114=115, T__115=116, T__116=117, T__117=118, T__118=119, 
		T__119=120, T__120=121, T__121=122, T__122=123, NUMBER=124, WHITESPACE=125, 
		LPARAM=126, RPARAM=127, Comma=128, GETPARENTVALUE=129, EXTRACTMINT=130, 
		CONCATENATEMINT=131, MI=132, ADDMINT=133, ANDMINT=134, R1=135, R2=136, 
		R3=137, RSMAP=138;
	public static final int
		RULE_lit_rh = 0, RULE_lit_r8 = 1, RULE_lit_r16 = 2, RULE_lit_r32 = 3, 
		RULE_lit_r64 = 4, RULE_lit_sreg = 5, RULE_lit_st = 6, RULE_lit_xmm = 7, 
		RULE_lit_mm = 8, RULE_lit_ymm = 9, RULE_lit_reg = 10, RULE_operand = 11, 
		RULE_function = 12, RULE_functionCall = 13;
	private static String[] makeRuleNames() {
		return new String[] {
			"lit_rh", "lit_r8", "lit_r16", "lit_r32", "lit_r64", "lit_sreg", "lit_st", 
			"lit_xmm", "lit_mm", "lit_ymm", "lit_reg", "operand", "function", "functionCall"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'\"%ah\"'", "'\"%bh\"'", "'\"%ch\"'", "'\"%dh\"'", "'\"%al\"'", 
			"'\"%bl\"'", "'\"%cl\"'", "'\"%dl\"'", "'\"%sil\"'", "'\"%dil\"'", "'\"%spl\"'", 
			"'\"%bpl\"'", "'\"%r8b\"'", "'\"%r9b\"'", "'\"%r10b\"'", "'\"%r11b\"'", 
			"'\"%r12b\"'", "'\"%r13b\"'", "'\"%r14b\"'", "'\"%r15b\"'", "'\"%ax\"'", 
			"'\"%bx\"'", "'\"%cx\"'", "'\"%dx\"'", "'\"%si\"'", "'\"%di\"'", "'\"%sp\"'", 
			"'\"%bp\"'", "'\"%r8w\"'", "'\"%r9w\"'", "'\"%r10w\"'", "'\"%r11w\"'", 
			"'\"%r12w\"'", "'\"%r13w\"'", "'\"%r14w\"'", "'\"%r15w\"'", "'\"%eax\"'", 
			"'\"%ebx\"'", "'\"%ecx\"'", "'\"%edx\"'", "'\"%esi\"'", "'\"%edi\"'", 
			"'\"%esp\"'", "'\"%ebp\"'", "'\"%r8d\"'", "'\"%r9d\"'", "'\"%r10d\"'", 
			"'\"%r11d\"'", "'\"%r12d\"'", "'\"%r13d\"'", "'\"%r14d\"'", "'\"%r15d\"'", 
			"'\"%rax\"'", "'\"%rbx\"'", "'\"%rcx\"'", "'\"%rdx\"'", "'\"%rsi\"'", 
			"'\"%rdi\"'", "'\"%rsp\"'", "'\"%rbp\"'", "'\"%r8\"'", "'\"%r9\"'", "'\"%r10\"'", 
			"'\"%r11\"'", "'\"%r12\"'", "'\"%r13\"'", "'\"%r14\"'", "'\"%r15\"'", 
			"'\"%es\"'", "'\"%cs\"'", "'\"%ss\"'", "'\"%ds\"'", "'\"%fs\"'", "'\"%gs\"'", 
			"'\"%st\"'", "'\"%st(0)\"'", "'\"%st(1)\"'", "'\"%st(2)\"'", "'\"%st(3)\"'", 
			"'\"%st(4)\"'", "'\"%st(5)\"'", "'\"%st(6)\"'", "'\"%st(7)\"'", "'\"%xmm0\"'", 
			"'\"%xmm1\"'", "'\"%xmm2\"'", "'\"%xmm3\"'", "'\"%xmm4\"'", "'\"%xmm5\"'", 
			"'\"%xmm6\"'", "'\"%xmm7\"'", "'\"%xmm8\"'", "'\"%xmm9\"'", "'\"%xmm10\"'", 
			"'\"%xmm11\"'", "'\"%xmm12\"'", "'\"%xmm13\"'", "'\"%xmm14\"'", "'\"%xmm15\"'", 
			"'\"%mmx0\"'", "'\"%mmx1\"'", "'\"%mmx2\"'", "'\"%mmx3\"'", "'\"%mmx4\"'", 
			"'\"%mmx5\"'", "'\"%mmx6\"'", "'\"%mmx7\"'", "'\"%ymm0\"'", "'\"%ymm1\"'", 
			"'\"%ymm2\"'", "'\"%ymm3\"'", "'\"%ymm4\"'", "'\"%ymm5\"'", "'\"%ymm6\"'", 
			"'\"%ymm7\"'", "'\"%ymm8\"'", "'\"%ymm9\"'", "'\"%ymm10\"'", "'\"%ymm11\"'", 
			"'\"%ymm12\"'", "'\"%ymm13\"'", "'\"%ymm14\"'", "'\"%ymm15\"'", null, 
			"' '", "'('", "')'", "','", "'getParentValue'", "'extractMInt'", "'concatenateMInt'", 
			"'mi'", "'addMInt'", "'andMInt'", "'R1'", "'R2'", "'R3'", "'RSMap'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "NUMBER", "WHITESPACE", "LPARAM", "RPARAM", "Comma", 
			"GETPARENTVALUE", "EXTRACTMINT", "CONCATENATEMINT", "MI", "ADDMINT", 
			"ANDMINT", "R1", "R2", "R3", "RSMAP"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "KG.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KGParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Lit_rhContext extends ParserRuleContext {
		public Lit_rhContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_rh; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_rh(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_rh(this);
		}
	}

	public final Lit_rhContext lit_rh() throws RecognitionException {
		Lit_rhContext _localctx = new Lit_rhContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_lit_rh);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_r8Context extends ParserRuleContext {
		public Lit_r8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_r8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_r8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_r8(this);
		}
	}

	public final Lit_r8Context lit_r8() throws RecognitionException {
		Lit_r8Context _localctx = new Lit_r8Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_lit_r8);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_r16Context extends ParserRuleContext {
		public Lit_r16Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_r16; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_r16(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_r16(this);
		}
	}

	public final Lit_r16Context lit_r16() throws RecognitionException {
		Lit_r16Context _localctx = new Lit_r16Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_lit_r16);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_r32Context extends ParserRuleContext {
		public Lit_r32Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_r32; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_r32(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_r32(this);
		}
	}

	public final Lit_r32Context lit_r32() throws RecognitionException {
		Lit_r32Context _localctx = new Lit_r32Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_lit_r32);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_r64Context extends ParserRuleContext {
		public Lit_r64Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_r64; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_r64(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_r64(this);
		}
	}

	public final Lit_r64Context lit_r64() throws RecognitionException {
		Lit_r64Context _localctx = new Lit_r64Context(_ctx, getState());
		enterRule(_localctx, 8, RULE_lit_r64);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_la = _input.LA(1);
			if ( !(((((_la - 53)) & ~0x3f) == 0 && ((1L << (_la - 53)) & ((1L << (T__52 - 53)) | (1L << (T__53 - 53)) | (1L << (T__54 - 53)) | (1L << (T__55 - 53)) | (1L << (T__56 - 53)) | (1L << (T__57 - 53)) | (1L << (T__58 - 53)) | (1L << (T__59 - 53)) | (1L << (T__60 - 53)) | (1L << (T__61 - 53)) | (1L << (T__62 - 53)) | (1L << (T__63 - 53)) | (1L << (T__64 - 53)) | (1L << (T__65 - 53)) | (1L << (T__66 - 53)) | (1L << (T__67 - 53)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_sregContext extends ParserRuleContext {
		public Lit_sregContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_sreg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_sreg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_sreg(this);
		}
	}

	public final Lit_sregContext lit_sreg() throws RecognitionException {
		Lit_sregContext _localctx = new Lit_sregContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_lit_sreg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & ((1L << (T__68 - 69)) | (1L << (T__69 - 69)) | (1L << (T__70 - 69)) | (1L << (T__71 - 69)) | (1L << (T__72 - 69)) | (1L << (T__73 - 69)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_stContext extends ParserRuleContext {
		public Lit_stContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_st; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_st(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_st(this);
		}
	}

	public final Lit_stContext lit_st() throws RecognitionException {
		Lit_stContext _localctx = new Lit_stContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_lit_st);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			_la = _input.LA(1);
			if ( !(((((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & ((1L << (T__74 - 75)) | (1L << (T__75 - 75)) | (1L << (T__76 - 75)) | (1L << (T__77 - 75)) | (1L << (T__78 - 75)) | (1L << (T__79 - 75)) | (1L << (T__80 - 75)) | (1L << (T__81 - 75)) | (1L << (T__82 - 75)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_xmmContext extends ParserRuleContext {
		public Lit_xmmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_xmm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_xmm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_xmm(this);
		}
	}

	public final Lit_xmmContext lit_xmm() throws RecognitionException {
		Lit_xmmContext _localctx = new Lit_xmmContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lit_xmm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_la = _input.LA(1);
			if ( !(((((_la - 84)) & ~0x3f) == 0 && ((1L << (_la - 84)) & ((1L << (T__83 - 84)) | (1L << (T__84 - 84)) | (1L << (T__85 - 84)) | (1L << (T__86 - 84)) | (1L << (T__87 - 84)) | (1L << (T__88 - 84)) | (1L << (T__89 - 84)) | (1L << (T__90 - 84)) | (1L << (T__91 - 84)) | (1L << (T__92 - 84)) | (1L << (T__93 - 84)) | (1L << (T__94 - 84)) | (1L << (T__95 - 84)) | (1L << (T__96 - 84)) | (1L << (T__97 - 84)) | (1L << (T__98 - 84)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_mmContext extends ParserRuleContext {
		public Lit_mmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_mm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_mm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_mm(this);
		}
	}

	public final Lit_mmContext lit_mm() throws RecognitionException {
		Lit_mmContext _localctx = new Lit_mmContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_lit_mm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			_la = _input.LA(1);
			if ( !(((((_la - 100)) & ~0x3f) == 0 && ((1L << (_la - 100)) & ((1L << (T__99 - 100)) | (1L << (T__100 - 100)) | (1L << (T__101 - 100)) | (1L << (T__102 - 100)) | (1L << (T__103 - 100)) | (1L << (T__104 - 100)) | (1L << (T__105 - 100)) | (1L << (T__106 - 100)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_ymmContext extends ParserRuleContext {
		public Lit_ymmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_ymm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_ymm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_ymm(this);
		}
	}

	public final Lit_ymmContext lit_ymm() throws RecognitionException {
		Lit_ymmContext _localctx = new Lit_ymmContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_lit_ymm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			_la = _input.LA(1);
			if ( !(((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & ((1L << (T__107 - 108)) | (1L << (T__108 - 108)) | (1L << (T__109 - 108)) | (1L << (T__110 - 108)) | (1L << (T__111 - 108)) | (1L << (T__112 - 108)) | (1L << (T__113 - 108)) | (1L << (T__114 - 108)) | (1L << (T__115 - 108)) | (1L << (T__116 - 108)) | (1L << (T__117 - 108)) | (1L << (T__118 - 108)) | (1L << (T__119 - 108)) | (1L << (T__120 - 108)) | (1L << (T__121 - 108)) | (1L << (T__122 - 108)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Lit_regContext extends ParserRuleContext {
		public Lit_rhContext lit_rh() {
			return getRuleContext(Lit_rhContext.class,0);
		}
		public Lit_r8Context lit_r8() {
			return getRuleContext(Lit_r8Context.class,0);
		}
		public Lit_r16Context lit_r16() {
			return getRuleContext(Lit_r16Context.class,0);
		}
		public Lit_r32Context lit_r32() {
			return getRuleContext(Lit_r32Context.class,0);
		}
		public Lit_r64Context lit_r64() {
			return getRuleContext(Lit_r64Context.class,0);
		}
		public Lit_sregContext lit_sreg() {
			return getRuleContext(Lit_sregContext.class,0);
		}
		public Lit_stContext lit_st() {
			return getRuleContext(Lit_stContext.class,0);
		}
		public Lit_xmmContext lit_xmm() {
			return getRuleContext(Lit_xmmContext.class,0);
		}
		public Lit_mmContext lit_mm() {
			return getRuleContext(Lit_mmContext.class,0);
		}
		public Lit_ymmContext lit_ymm() {
			return getRuleContext(Lit_ymmContext.class,0);
		}
		public Lit_regContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lit_reg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterLit_reg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitLit_reg(this);
		}
	}

	public final Lit_regContext lit_reg() throws RecognitionException {
		Lit_regContext _localctx = new Lit_regContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_lit_reg);
		try {
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				lit_rh();
				}
				break;
			case T__4:
			case T__5:
			case T__6:
			case T__7:
			case T__8:
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case T__14:
			case T__15:
			case T__16:
			case T__17:
			case T__18:
			case T__19:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				lit_r8();
				}
				break;
			case T__20:
			case T__21:
			case T__22:
			case T__23:
			case T__24:
			case T__25:
			case T__26:
			case T__27:
			case T__28:
			case T__29:
			case T__30:
			case T__31:
			case T__32:
			case T__33:
			case T__34:
			case T__35:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				lit_r16();
				}
				break;
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
			case T__44:
			case T__45:
			case T__46:
			case T__47:
			case T__48:
			case T__49:
			case T__50:
			case T__51:
				enterOuterAlt(_localctx, 4);
				{
				setState(51);
				lit_r32();
				}
				break;
			case T__52:
			case T__53:
			case T__54:
			case T__55:
			case T__56:
			case T__57:
			case T__58:
			case T__59:
			case T__60:
			case T__61:
			case T__62:
			case T__63:
			case T__64:
			case T__65:
			case T__66:
			case T__67:
				enterOuterAlt(_localctx, 5);
				{
				setState(52);
				lit_r64();
				}
				break;
			case T__68:
			case T__69:
			case T__70:
			case T__71:
			case T__72:
			case T__73:
				enterOuterAlt(_localctx, 6);
				{
				setState(53);
				lit_sreg();
				}
				break;
			case T__74:
			case T__75:
			case T__76:
			case T__77:
			case T__78:
			case T__79:
			case T__80:
			case T__81:
			case T__82:
				enterOuterAlt(_localctx, 7);
				{
				setState(54);
				lit_st();
				}
				break;
			case T__83:
			case T__84:
			case T__85:
			case T__86:
			case T__87:
			case T__88:
			case T__89:
			case T__90:
			case T__91:
			case T__92:
			case T__93:
			case T__94:
			case T__95:
			case T__96:
			case T__97:
			case T__98:
				enterOuterAlt(_localctx, 8);
				{
				setState(55);
				lit_xmm();
				}
				break;
			case T__99:
			case T__100:
			case T__101:
			case T__102:
			case T__103:
			case T__104:
			case T__105:
			case T__106:
				enterOuterAlt(_localctx, 9);
				{
				setState(56);
				lit_mm();
				}
				break;
			case T__107:
			case T__108:
			case T__109:
			case T__110:
			case T__111:
			case T__112:
			case T__113:
			case T__114:
			case T__115:
			case T__116:
			case T__117:
			case T__118:
			case T__119:
			case T__120:
			case T__121:
			case T__122:
				enterOuterAlt(_localctx, 10);
				{
				setState(57);
				lit_ymm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperandContext extends ParserRuleContext {
		public TerminalNode R1() { return getToken(KGParser.R1, 0); }
		public TerminalNode R2() { return getToken(KGParser.R2, 0); }
		public TerminalNode R3() { return getToken(KGParser.R3, 0); }
		public OperandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operand; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterOperand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitOperand(this);
		}
	}

	public final OperandContext operand() throws RecognitionException {
		OperandContext _localctx = new OperandContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_operand);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			_la = _input.LA(1);
			if ( !(((((_la - 135)) & ~0x3f) == 0 && ((1L << (_la - 135)) & ((1L << (R1 - 135)) | (1L << (R2 - 135)) | (1L << (R3 - 135)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionContext extends ParserRuleContext {
		public TerminalNode GETPARENTVALUE() { return getToken(KGParser.GETPARENTVALUE, 0); }
		public TerminalNode EXTRACTMINT() { return getToken(KGParser.EXTRACTMINT, 0); }
		public TerminalNode CONCATENATEMINT() { return getToken(KGParser.CONCATENATEMINT, 0); }
		public TerminalNode MI() { return getToken(KGParser.MI, 0); }
		public TerminalNode ADDMINT() { return getToken(KGParser.ADDMINT, 0); }
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_function);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			_la = _input.LA(1);
			if ( !(((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (GETPARENTVALUE - 129)) | (1L << (EXTRACTMINT - 129)) | (1L << (CONCATENATEMINT - 129)) | (1L << (MI - 129)) | (1L << (ADDMINT - 129)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionContext function() {
			return getRuleContext(FunctionContext.class,0);
		}
		public TerminalNode LPARAM() { return getToken(KGParser.LPARAM, 0); }
		public TerminalNode RPARAM() { return getToken(KGParser.RPARAM, 0); }
		public List<TerminalNode> Comma() { return getTokens(KGParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(KGParser.Comma, i);
		}
		public List<FunctionCallContext> functionCall() {
			return getRuleContexts(FunctionCallContext.class);
		}
		public FunctionCallContext functionCall(int i) {
			return getRuleContext(FunctionCallContext.class,i);
		}
		public List<TerminalNode> NUMBER() { return getTokens(KGParser.NUMBER); }
		public TerminalNode NUMBER(int i) {
			return getToken(KGParser.NUMBER, i);
		}
		public List<Lit_regContext> lit_reg() {
			return getRuleContexts(Lit_regContext.class);
		}
		public Lit_regContext lit_reg(int i) {
			return getRuleContext(Lit_regContext.class,i);
		}
		public List<OperandContext> operand() {
			return getRuleContexts(OperandContext.class);
		}
		public OperandContext operand(int i) {
			return getRuleContext(OperandContext.class,i);
		}
		public List<TerminalNode> RSMAP() { return getTokens(KGParser.RSMAP); }
		public TerminalNode RSMAP(int i) {
			return getToken(KGParser.RSMAP, i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KGListener ) ((KGListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			function();
			setState(65);
			match(LPARAM);
			setState(74); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(71);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case GETPARENTVALUE:
				case EXTRACTMINT:
				case CONCATENATEMINT:
				case MI:
				case ADDMINT:
					{
					setState(66);
					functionCall();
					}
					break;
				case NUMBER:
					{
					setState(67);
					match(NUMBER);
					}
					break;
				case T__0:
				case T__1:
				case T__2:
				case T__3:
				case T__4:
				case T__5:
				case T__6:
				case T__7:
				case T__8:
				case T__9:
				case T__10:
				case T__11:
				case T__12:
				case T__13:
				case T__14:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__19:
				case T__20:
				case T__21:
				case T__22:
				case T__23:
				case T__24:
				case T__25:
				case T__26:
				case T__27:
				case T__28:
				case T__29:
				case T__30:
				case T__31:
				case T__32:
				case T__33:
				case T__34:
				case T__35:
				case T__36:
				case T__37:
				case T__38:
				case T__39:
				case T__40:
				case T__41:
				case T__42:
				case T__43:
				case T__44:
				case T__45:
				case T__46:
				case T__47:
				case T__48:
				case T__49:
				case T__50:
				case T__51:
				case T__52:
				case T__53:
				case T__54:
				case T__55:
				case T__56:
				case T__57:
				case T__58:
				case T__59:
				case T__60:
				case T__61:
				case T__62:
				case T__63:
				case T__64:
				case T__65:
				case T__66:
				case T__67:
				case T__68:
				case T__69:
				case T__70:
				case T__71:
				case T__72:
				case T__73:
				case T__74:
				case T__75:
				case T__76:
				case T__77:
				case T__78:
				case T__79:
				case T__80:
				case T__81:
				case T__82:
				case T__83:
				case T__84:
				case T__85:
				case T__86:
				case T__87:
				case T__88:
				case T__89:
				case T__90:
				case T__91:
				case T__92:
				case T__93:
				case T__94:
				case T__95:
				case T__96:
				case T__97:
				case T__98:
				case T__99:
				case T__100:
				case T__101:
				case T__102:
				case T__103:
				case T__104:
				case T__105:
				case T__106:
				case T__107:
				case T__108:
				case T__109:
				case T__110:
				case T__111:
				case T__112:
				case T__113:
				case T__114:
				case T__115:
				case T__116:
				case T__117:
				case T__118:
				case T__119:
				case T__120:
				case T__121:
				case T__122:
					{
					setState(68);
					lit_reg();
					}
					break;
				case R1:
				case R2:
				case R3:
					{
					setState(69);
					operand();
					}
					break;
				case RSMAP:
					{
					setState(70);
					match(RSMAP);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(73);
				match(Comma);
				}
				}
				setState(76); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << T__23) | (1L << T__24) | (1L << T__25) | (1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33) | (1L << T__34) | (1L << T__35) | (1L << T__36) | (1L << T__37) | (1L << T__38) | (1L << T__39) | (1L << T__40) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45) | (1L << T__46) | (1L << T__47) | (1L << T__48) | (1L << T__49) | (1L << T__50) | (1L << T__51) | (1L << T__52) | (1L << T__53) | (1L << T__54) | (1L << T__55) | (1L << T__56) | (1L << T__57) | (1L << T__58) | (1L << T__59) | (1L << T__60) | (1L << T__61) | (1L << T__62))) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & ((1L << (T__63 - 64)) | (1L << (T__64 - 64)) | (1L << (T__65 - 64)) | (1L << (T__66 - 64)) | (1L << (T__67 - 64)) | (1L << (T__68 - 64)) | (1L << (T__69 - 64)) | (1L << (T__70 - 64)) | (1L << (T__71 - 64)) | (1L << (T__72 - 64)) | (1L << (T__73 - 64)) | (1L << (T__74 - 64)) | (1L << (T__75 - 64)) | (1L << (T__76 - 64)) | (1L << (T__77 - 64)) | (1L << (T__78 - 64)) | (1L << (T__79 - 64)) | (1L << (T__80 - 64)) | (1L << (T__81 - 64)) | (1L << (T__82 - 64)) | (1L << (T__83 - 64)) | (1L << (T__84 - 64)) | (1L << (T__85 - 64)) | (1L << (T__86 - 64)) | (1L << (T__87 - 64)) | (1L << (T__88 - 64)) | (1L << (T__89 - 64)) | (1L << (T__90 - 64)) | (1L << (T__91 - 64)) | (1L << (T__92 - 64)) | (1L << (T__93 - 64)) | (1L << (T__94 - 64)) | (1L << (T__95 - 64)) | (1L << (T__96 - 64)) | (1L << (T__97 - 64)) | (1L << (T__98 - 64)) | (1L << (T__99 - 64)) | (1L << (T__100 - 64)) | (1L << (T__101 - 64)) | (1L << (T__102 - 64)) | (1L << (T__103 - 64)) | (1L << (T__104 - 64)) | (1L << (T__105 - 64)) | (1L << (T__106 - 64)) | (1L << (T__107 - 64)) | (1L << (T__108 - 64)) | (1L << (T__109 - 64)) | (1L << (T__110 - 64)) | (1L << (T__111 - 64)) | (1L << (T__112 - 64)) | (1L << (T__113 - 64)) | (1L << (T__114 - 64)) | (1L << (T__115 - 64)) | (1L << (T__116 - 64)) | (1L << (T__117 - 64)) | (1L << (T__118 - 64)) | (1L << (T__119 - 64)) | (1L << (T__120 - 64)) | (1L << (T__121 - 64)) | (1L << (T__122 - 64)) | (1L << (NUMBER - 64)))) != 0) || ((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & ((1L << (GETPARENTVALUE - 129)) | (1L << (EXTRACTMINT - 129)) | (1L << (CONCATENATEMINT - 129)) | (1L << (MI - 129)) | (1L << (ADDMINT - 129)) | (1L << (R1 - 129)) | (1L << (R2 - 129)) | (1L << (R3 - 129)) | (1L << (RSMAP - 129)))) != 0) );
			setState(78);
			match(RPARAM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\u008cS\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\5\f=\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\5\17J\n\17\3\17\6\17M\n\17\r\17\16\17N\3\17\3\17\3\17"+
		"\2\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\16\3\2\3\6\3\2\7\26\3\2"+
		"\27&\3\2\'\66\3\2\67F\3\2GL\3\2MU\3\2Ve\3\2fm\3\2n}\3\2\u0089\u008b\3"+
		"\2\u0083\u0087\2R\2\36\3\2\2\2\4 \3\2\2\2\6\"\3\2\2\2\b$\3\2\2\2\n&\3"+
		"\2\2\2\f(\3\2\2\2\16*\3\2\2\2\20,\3\2\2\2\22.\3\2\2\2\24\60\3\2\2\2\26"+
		"<\3\2\2\2\30>\3\2\2\2\32@\3\2\2\2\34B\3\2\2\2\36\37\t\2\2\2\37\3\3\2\2"+
		"\2 !\t\3\2\2!\5\3\2\2\2\"#\t\4\2\2#\7\3\2\2\2$%\t\5\2\2%\t\3\2\2\2&\'"+
		"\t\6\2\2\'\13\3\2\2\2()\t\7\2\2)\r\3\2\2\2*+\t\b\2\2+\17\3\2\2\2,-\t\t"+
		"\2\2-\21\3\2\2\2./\t\n\2\2/\23\3\2\2\2\60\61\t\13\2\2\61\25\3\2\2\2\62"+
		"=\5\2\2\2\63=\5\4\3\2\64=\5\6\4\2\65=\5\b\5\2\66=\5\n\6\2\67=\5\f\7\2"+
		"8=\5\16\b\29=\5\20\t\2:=\5\22\n\2;=\5\24\13\2<\62\3\2\2\2<\63\3\2\2\2"+
		"<\64\3\2\2\2<\65\3\2\2\2<\66\3\2\2\2<\67\3\2\2\2<8\3\2\2\2<9\3\2\2\2<"+
		":\3\2\2\2<;\3\2\2\2=\27\3\2\2\2>?\t\f\2\2?\31\3\2\2\2@A\t\r\2\2A\33\3"+
		"\2\2\2BC\5\32\16\2CL\7\u0080\2\2DJ\5\34\17\2EJ\7~\2\2FJ\5\26\f\2GJ\5\30"+
		"\r\2HJ\7\u008c\2\2ID\3\2\2\2IE\3\2\2\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2J"+
		"K\3\2\2\2KM\7\u0082\2\2LI\3\2\2\2MN\3\2\2\2NL\3\2\2\2NO\3\2\2\2OP\3\2"+
		"\2\2PQ\7\u0081\2\2Q\35\3\2\2\2\5<IN";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}