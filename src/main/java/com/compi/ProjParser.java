package com.compi;
// Generated from C:/Users/Dany/Desktop/Proj.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ProjParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, ID=35, Digitos=36, Cadena=37, NEWLINE=38, 
		BLANKSPACE=39, COMP=40, EQUAL=41;
	public static final int
		RULE_prog = 0, RULE_segvar = 1, RULE_defvar = 2, RULE_segfunct = 3, RULE_deffunct = 4, 
		RULE_bodyfunct = 5, RULE_defarith = 6, RULE_bodysegE = 7, RULE_bodysegE2 = 8, 
		RULE_bodysegT = 9, RULE_bodysegT2 = 10, RULE_itemarith = 11, RULE_body_program = 12, 
		RULE_def_cond = 13, RULE_def_exp = 14, RULE_else_cond = 15, RULE_def_while = 16, 
		RULE_def_w = 17, RULE_call_funct = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "segvar", "defvar", "segfunct", "deffunct", "bodyfunct", "defarith", 
			"bodysegE", "bodysegE2", "bodysegT", "bodysegT2", "itemarith", "body_program", 
			"def_cond", "def_exp", "else_cond", "def_while", "def_w", "call_funct"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'Program'", "'BEGIN'", "'END'", "'VARIABLE'", "':'", "';'", "'int'", 
			"'='", "'float'", "'.'", "'string'", "'bool'", "'true'", "'false'", "'FUNCTION'", 
			"'function'", "'('", "')'", "'{'", "'}'", "'RETURN'", "'+'", "'-'", "'*'", 
			"'/'", "'cond'", "'if'", "'else'", "'loop'", "'while'", "'output'", "'write'", 
			"'input'", "'read'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "ID", 
			"Digitos", "Cadena", "NEWLINE", "BLANKSPACE", "COMP", "EQUAL"
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
	public String getGrammarFileName() { return "Proj.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ProjParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public SegvarContext segvar() {
			return getRuleContext(SegvarContext.class,0);
		}
		public SegfunctContext segfunct() {
			return getRuleContext(SegfunctContext.class,0);
		}
		public Body_programContext body_program() {
			return getRuleContext(Body_programContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ProjParser.EOF, 0); }
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(T__0);
			setState(39);
			segvar();
			setState(40);
			segfunct();
			setState(41);
			match(T__1);
			setState(42);
			body_program();
			setState(43);
			match(T__2);
			setState(44);
			match(EOF);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SegvarContext extends ParserRuleContext {
		public List<DefvarContext> defvar() {
			return getRuleContexts(DefvarContext.class);
		}
		public DefvarContext defvar(int i) {
			return getRuleContext(DefvarContext.class,i);
		}
		public SegvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterSegvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitSegvar(this);
		}
	}

	public final SegvarContext segvar() throws RecognitionException {
		SegvarContext _localctx = new SegvarContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_segvar);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(T__3);
			setState(47);
			match(T__4);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6784L) != 0)) {
				{
				setState(48);
				defvar();
				setState(53);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(49);
						match(T__5);
						setState(50);
						defvar();
						}
						} 
					}
					setState(55);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
				}
				setState(56);
				match(T__5);
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefvarContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjParser.ID, 0); }
		public List<TerminalNode> Digitos() { return getTokens(ProjParser.Digitos); }
		public TerminalNode Digitos(int i) {
			return getToken(ProjParser.Digitos, i);
		}
		public TerminalNode Cadena() { return getToken(ProjParser.Cadena, 0); }
		public DefvarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defvar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDefvar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDefvar(this);
		}
	}

	public final DefvarContext defvar() throws RecognitionException {
		DefvarContext _localctx = new DefvarContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_defvar);
		int _la;
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(T__6);
				setState(61);
				match(ID);
				setState(62);
				match(T__7);
				setState(63);
				match(Digitos);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				match(T__8);
				setState(65);
				match(ID);
				setState(66);
				match(T__7);
				setState(67);
				match(Digitos);
				setState(68);
				match(T__9);
				setState(69);
				match(Digitos);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				match(T__10);
				setState(71);
				match(ID);
				setState(72);
				match(T__7);
				setState(73);
				match(Cadena);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 4);
				{
				setState(74);
				match(T__11);
				setState(75);
				match(ID);
				setState(76);
				match(T__7);
				setState(77);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class SegfunctContext extends ParserRuleContext {
		public DeffunctContext deffunct() {
			return getRuleContext(DeffunctContext.class,0);
		}
		public SegfunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_segfunct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterSegfunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitSegfunct(this);
		}
	}

	public final SegfunctContext segfunct() throws RecognitionException {
		SegfunctContext _localctx = new SegfunctContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_segfunct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__14);
			setState(81);
			match(T__4);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(82);
				deffunct();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class DeffunctContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProjParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjParser.ID, i);
		}
		public BodyfunctContext bodyfunct() {
			return getRuleContext(BodyfunctContext.class,0);
		}
		public DeffunctContext deffunct() {
			return getRuleContext(DeffunctContext.class,0);
		}
		public DeffunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deffunct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDeffunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDeffunct(this);
		}
	}

	public final DeffunctContext deffunct() throws RecognitionException {
		DeffunctContext _localctx = new DeffunctContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_deffunct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__15);
			setState(86);
			match(ID);
			setState(87);
			match(T__16);
			setState(88);
			match(ID);
			setState(89);
			match(T__17);
			setState(90);
			match(T__18);
			setState(91);
			bodyfunct();
			setState(92);
			match(T__19);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(93);
				deffunct();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyfunctContext extends ParserRuleContext {
		public DefarithContext defarith() {
			return getRuleContext(DefarithContext.class,0);
		}
		public TerminalNode ID() { return getToken(ProjParser.ID, 0); }
		public BodyfunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodyfunct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterBodyfunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitBodyfunct(this);
		}
	}

	public final BodyfunctContext bodyfunct() throws RecognitionException {
		BodyfunctContext _localctx = new BodyfunctContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_bodyfunct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			defarith();
			setState(97);
			match(T__5);
			setState(98);
			match(T__20);
			setState(99);
			match(ID);
			setState(100);
			match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefarithContext extends ParserRuleContext {
		public BodysegEContext bodysegE() {
			return getRuleContext(BodysegEContext.class,0);
		}
		public DefarithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defarith; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDefarith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDefarith(this);
		}
	}

	public final DefarithContext defarith() throws RecognitionException {
		DefarithContext _localctx = new DefarithContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_defarith);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			bodysegE();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodysegEContext extends ParserRuleContext {
		public BodysegTContext bodysegT() {
			return getRuleContext(BodysegTContext.class,0);
		}
		public BodysegE2Context bodysegE2() {
			return getRuleContext(BodysegE2Context.class,0);
		}
		public BodysegEContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodysegE; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterBodysegE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitBodysegE(this);
		}
	}

	public final BodysegEContext bodysegE() throws RecognitionException {
		BodysegEContext _localctx = new BodysegEContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_bodysegE);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			bodysegT();
			setState(105);
			bodysegE2();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodysegE2Context extends ParserRuleContext {
		public BodysegTContext bodysegT() {
			return getRuleContext(BodysegTContext.class,0);
		}
		public BodysegE2Context bodysegE2() {
			return getRuleContext(BodysegE2Context.class,0);
		}
		public BodysegE2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodysegE2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterBodysegE2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitBodysegE2(this);
		}
	}

	public final BodysegE2Context bodysegE2() throws RecognitionException {
		BodysegE2Context _localctx = new BodysegE2Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_bodysegE2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				{
				setState(107);
				match(T__21);
				setState(108);
				bodysegT();
				setState(109);
				bodysegE2();
				}
				break;
			case T__22:
				{
				setState(111);
				match(T__22);
				setState(112);
				bodysegT();
				setState(113);
				bodysegE2();
				}
				break;
			case T__5:
			case T__17:
				break;
			default:
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodysegTContext extends ParserRuleContext {
		public ItemarithContext itemarith() {
			return getRuleContext(ItemarithContext.class,0);
		}
		public BodysegT2Context bodysegT2() {
			return getRuleContext(BodysegT2Context.class,0);
		}
		public BodysegTContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodysegT; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterBodysegT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitBodysegT(this);
		}
	}

	public final BodysegTContext bodysegT() throws RecognitionException {
		BodysegTContext _localctx = new BodysegTContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_bodysegT);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			itemarith();
			setState(118);
			bodysegT2();
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodysegT2Context extends ParserRuleContext {
		public ItemarithContext itemarith() {
			return getRuleContext(ItemarithContext.class,0);
		}
		public BodysegT2Context bodysegT2() {
			return getRuleContext(BodysegT2Context.class,0);
		}
		public BodysegT2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bodysegT2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterBodysegT2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitBodysegT2(this);
		}
	}

	public final BodysegT2Context bodysegT2() throws RecognitionException {
		BodysegT2Context _localctx = new BodysegT2Context(_ctx, getState());
		enterRule(_localctx, 20, RULE_bodysegT2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				{
				setState(120);
				match(T__23);
				setState(121);
				itemarith();
				setState(122);
				bodysegT2();
				}
				break;
			case T__24:
				{
				setState(124);
				match(T__24);
				setState(125);
				itemarith();
				setState(126);
				bodysegT2();
				}
				break;
			case T__5:
			case T__17:
			case T__21:
			case T__22:
				break;
			default:
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class ItemarithContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjParser.ID, 0); }
		public TerminalNode Digitos() { return getToken(ProjParser.Digitos, 0); }
		public BodysegEContext bodysegE() {
			return getRuleContext(BodysegEContext.class,0);
		}
		public ItemarithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_itemarith; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterItemarith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitItemarith(this);
		}
	}

	public final ItemarithContext itemarith() throws RecognitionException {
		ItemarithContext _localctx = new ItemarithContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_itemarith);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(ID);
				}
				break;
			case Digitos:
				enterOuterAlt(_localctx, 2);
				{
				setState(131);
				match(Digitos);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				match(T__16);
				setState(133);
				bodysegE();
				setState(134);
				match(T__17);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Body_programContext extends ParserRuleContext {
		public List<Def_condContext> def_cond() {
			return getRuleContexts(Def_condContext.class);
		}
		public Def_condContext def_cond(int i) {
			return getRuleContext(Def_condContext.class,i);
		}
		public List<Def_whileContext> def_while() {
			return getRuleContexts(Def_whileContext.class);
		}
		public Def_whileContext def_while(int i) {
			return getRuleContext(Def_whileContext.class,i);
		}
		public List<Def_wContext> def_w() {
			return getRuleContexts(Def_wContext.class);
		}
		public Def_wContext def_w(int i) {
			return getRuleContext(Def_wContext.class,i);
		}
		public List<Call_functContext> call_funct() {
			return getRuleContexts(Call_functContext.class);
		}
		public Call_functContext call_funct(int i) {
			return getRuleContext(Call_functContext.class,i);
		}
		public Body_programContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterBody_program(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitBody_program(this);
		}
	}

	public final Body_programContext body_program() throws RecognitionException {
		Body_programContext _localctx = new Body_programContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_body_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 45701136384L) != 0)) {
				{
				setState(142);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__25:
					{
					setState(138);
					def_cond();
					}
					break;
				case T__28:
					{
					setState(139);
					def_while();
					}
					break;
				case T__30:
				case T__32:
					{
					setState(140);
					def_w();
					}
					break;
				case ID:
					{
					setState(141);
					call_funct();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Def_condContext extends ParserRuleContext {
		public Def_expContext def_exp() {
			return getRuleContext(Def_expContext.class,0);
		}
		public Def_wContext def_w() {
			return getRuleContext(Def_wContext.class,0);
		}
		public Else_condContext else_cond() {
			return getRuleContext(Else_condContext.class,0);
		}
		public Def_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDef_cond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDef_cond(this);
		}
	}

	public final Def_condContext def_cond() throws RecognitionException {
		Def_condContext _localctx = new Def_condContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_def_cond);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(T__25);
			setState(148);
			match(T__26);
			setState(149);
			match(T__16);
			setState(150);
			def_exp();
			setState(151);
			match(T__17);
			setState(152);
			match(T__18);
			setState(153);
			def_w();
			setState(154);
			match(T__19);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__27) {
				{
				setState(155);
				else_cond();
				}
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

	@SuppressWarnings("CheckReturnValue")
	public static class Def_expContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(ProjParser.ID, 0); }
		public TerminalNode COMP() { return getToken(ProjParser.COMP, 0); }
		public TerminalNode Digitos() { return getToken(ProjParser.Digitos, 0); }
		public TerminalNode EQUAL() { return getToken(ProjParser.EQUAL, 0); }
		public Def_expContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_exp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDef_exp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDef_exp(this);
		}
	}

	public final Def_expContext def_exp() throws RecognitionException {
		Def_expContext _localctx = new Def_expContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_def_exp);
		int _la;
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(ID);
				setState(159);
				match(COMP);
				setState(160);
				match(Digitos);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(ID);
				setState(162);
				match(EQUAL);
				setState(163);
				match(Digitos);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164);
				match(ID);
				setState(165);
				match(EQUAL);
				setState(166);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Else_condContext extends ParserRuleContext {
		public Def_wContext def_w() {
			return getRuleContext(Def_wContext.class,0);
		}
		public Else_condContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_cond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterElse_cond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitElse_cond(this);
		}
	}

	public final Else_condContext else_cond() throws RecognitionException {
		Else_condContext _localctx = new Else_condContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_else_cond);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__27);
			setState(170);
			match(T__18);
			setState(171);
			def_w();
			setState(172);
			match(T__19);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Def_whileContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProjParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjParser.ID, i);
		}
		public TerminalNode COMP() { return getToken(ProjParser.COMP, 0); }
		public TerminalNode Digitos() { return getToken(ProjParser.Digitos, 0); }
		public Def_wContext def_w() {
			return getRuleContext(Def_wContext.class,0);
		}
		public Def_whileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDef_while(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDef_while(this);
		}
	}

	public final Def_whileContext def_while() throws RecognitionException {
		Def_whileContext _localctx = new Def_whileContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_def_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(T__28);
			setState(175);
			match(T__29);
			setState(176);
			match(T__16);
			setState(177);
			match(ID);
			setState(178);
			match(COMP);
			setState(179);
			match(Digitos);
			setState(180);
			match(T__17);
			setState(181);
			match(T__18);
			setState(182);
			def_w();
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(183);
				match(ID);
				setState(184);
				match(T__21);
				}
				break;
			case 2:
				{
				setState(185);
				match(ID);
				setState(186);
				match(T__22);
				}
				break;
			}
			setState(189);
			match(T__5);
			setState(190);
			match(T__19);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Def_wContext extends ParserRuleContext {
		public TerminalNode Cadena() { return getToken(ProjParser.Cadena, 0); }
		public TerminalNode ID() { return getToken(ProjParser.ID, 0); }
		public Def_wContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_def_w; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterDef_w(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitDef_w(this);
		}
	}

	public final Def_wContext def_w() throws RecognitionException {
		Def_wContext _localctx = new Def_wContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_def_w);
		int _la;
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				match(T__30);
				setState(193);
				match(T__31);
				setState(194);
				match(T__16);
				setState(195);
				_la = _input.LA(1);
				if ( !(_la==ID || _la==Cadena) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(196);
				match(T__17);
				setState(197);
				match(T__5);
				}
				break;
			case T__32:
				enterOuterAlt(_localctx, 2);
				{
				setState(198);
				match(T__32);
				setState(199);
				match(ID);
				setState(200);
				match(T__7);
				setState(201);
				match(T__33);
				setState(202);
				match(T__16);
				setState(203);
				match(T__17);
				setState(204);
				match(T__5);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Call_functContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(ProjParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(ProjParser.ID, i);
		}
		public Call_functContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_funct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).enterCall_funct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ProjListener ) ((ProjListener)listener).exitCall_funct(this);
		}
	}

	public final Call_functContext call_funct() throws RecognitionException {
		Call_functContext _localctx = new Call_functContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_call_funct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(ID);
			setState(208);
			match(T__7);
			setState(209);
			match(ID);
			setState(210);
			match(T__16);
			setState(211);
			match(ID);
			setState(212);
			match(T__17);
			setState(213);
			match(T__5);
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
		"\u0004\u0001)\u00d8\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00014\b\u0001\n\u0001\f\u00017\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u0001;\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002O\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0003\u0003T\b\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0003\u0004_\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bt\b\b\u0001\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0081\b\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000b\u0089\b\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f\u008f\b\f"+
		"\n\f\f\f\u0092\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0003\r\u009d\b\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00a8\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0003\u0010\u00bc\b\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0003\u0011\u00ce\b\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0000\u0000\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010"+
		"\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$\u0000\u0002\u0001\u0000"+
		"\r\u000e\u0002\u0000##%%\u00da\u0000&\u0001\u0000\u0000\u0000\u0002.\u0001"+
		"\u0000\u0000\u0000\u0004N\u0001\u0000\u0000\u0000\u0006P\u0001\u0000\u0000"+
		"\u0000\bU\u0001\u0000\u0000\u0000\n`\u0001\u0000\u0000\u0000\ff\u0001"+
		"\u0000\u0000\u0000\u000eh\u0001\u0000\u0000\u0000\u0010s\u0001\u0000\u0000"+
		"\u0000\u0012u\u0001\u0000\u0000\u0000\u0014\u0080\u0001\u0000\u0000\u0000"+
		"\u0016\u0088\u0001\u0000\u0000\u0000\u0018\u0090\u0001\u0000\u0000\u0000"+
		"\u001a\u0093\u0001\u0000\u0000\u0000\u001c\u00a7\u0001\u0000\u0000\u0000"+
		"\u001e\u00a9\u0001\u0000\u0000\u0000 \u00ae\u0001\u0000\u0000\u0000\""+
		"\u00cd\u0001\u0000\u0000\u0000$\u00cf\u0001\u0000\u0000\u0000&\'\u0005"+
		"\u0001\u0000\u0000\'(\u0003\u0002\u0001\u0000()\u0003\u0006\u0003\u0000"+
		")*\u0005\u0002\u0000\u0000*+\u0003\u0018\f\u0000+,\u0005\u0003\u0000\u0000"+
		",-\u0005\u0000\u0000\u0001-\u0001\u0001\u0000\u0000\u0000./\u0005\u0004"+
		"\u0000\u0000/:\u0005\u0005\u0000\u000005\u0003\u0004\u0002\u000012\u0005"+
		"\u0006\u0000\u000024\u0003\u0004\u0002\u000031\u0001\u0000\u0000\u0000"+
		"47\u0001\u0000\u0000\u000053\u0001\u0000\u0000\u000056\u0001\u0000\u0000"+
		"\u000068\u0001\u0000\u0000\u000075\u0001\u0000\u0000\u000089\u0005\u0006"+
		"\u0000\u00009;\u0001\u0000\u0000\u0000:0\u0001\u0000\u0000\u0000:;\u0001"+
		"\u0000\u0000\u0000;\u0003\u0001\u0000\u0000\u0000<=\u0005\u0007\u0000"+
		"\u0000=>\u0005#\u0000\u0000>?\u0005\b\u0000\u0000?O\u0005$\u0000\u0000"+
		"@A\u0005\t\u0000\u0000AB\u0005#\u0000\u0000BC\u0005\b\u0000\u0000CD\u0005"+
		"$\u0000\u0000DE\u0005\n\u0000\u0000EO\u0005$\u0000\u0000FG\u0005\u000b"+
		"\u0000\u0000GH\u0005#\u0000\u0000HI\u0005\b\u0000\u0000IO\u0005%\u0000"+
		"\u0000JK\u0005\f\u0000\u0000KL\u0005#\u0000\u0000LM\u0005\b\u0000\u0000"+
		"MO\u0007\u0000\u0000\u0000N<\u0001\u0000\u0000\u0000N@\u0001\u0000\u0000"+
		"\u0000NF\u0001\u0000\u0000\u0000NJ\u0001\u0000\u0000\u0000O\u0005\u0001"+
		"\u0000\u0000\u0000PQ\u0005\u000f\u0000\u0000QS\u0005\u0005\u0000\u0000"+
		"RT\u0003\b\u0004\u0000SR\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"T\u0007\u0001\u0000\u0000\u0000UV\u0005\u0010\u0000\u0000VW\u0005#\u0000"+
		"\u0000WX\u0005\u0011\u0000\u0000XY\u0005#\u0000\u0000YZ\u0005\u0012\u0000"+
		"\u0000Z[\u0005\u0013\u0000\u0000[\\\u0003\n\u0005\u0000\\^\u0005\u0014"+
		"\u0000\u0000]_\u0003\b\u0004\u0000^]\u0001\u0000\u0000\u0000^_\u0001\u0000"+
		"\u0000\u0000_\t\u0001\u0000\u0000\u0000`a\u0003\f\u0006\u0000ab\u0005"+
		"\u0006\u0000\u0000bc\u0005\u0015\u0000\u0000cd\u0005#\u0000\u0000de\u0005"+
		"\u0006\u0000\u0000e\u000b\u0001\u0000\u0000\u0000fg\u0003\u000e\u0007"+
		"\u0000g\r\u0001\u0000\u0000\u0000hi\u0003\u0012\t\u0000ij\u0003\u0010"+
		"\b\u0000j\u000f\u0001\u0000\u0000\u0000kl\u0005\u0016\u0000\u0000lm\u0003"+
		"\u0012\t\u0000mn\u0003\u0010\b\u0000nt\u0001\u0000\u0000\u0000op\u0005"+
		"\u0017\u0000\u0000pq\u0003\u0012\t\u0000qr\u0003\u0010\b\u0000rt\u0001"+
		"\u0000\u0000\u0000sk\u0001\u0000\u0000\u0000so\u0001\u0000\u0000\u0000"+
		"st\u0001\u0000\u0000\u0000t\u0011\u0001\u0000\u0000\u0000uv\u0003\u0016"+
		"\u000b\u0000vw\u0003\u0014\n\u0000w\u0013\u0001\u0000\u0000\u0000xy\u0005"+
		"\u0018\u0000\u0000yz\u0003\u0016\u000b\u0000z{\u0003\u0014\n\u0000{\u0081"+
		"\u0001\u0000\u0000\u0000|}\u0005\u0019\u0000\u0000}~\u0003\u0016\u000b"+
		"\u0000~\u007f\u0003\u0014\n\u0000\u007f\u0081\u0001\u0000\u0000\u0000"+
		"\u0080x\u0001\u0000\u0000\u0000\u0080|\u0001\u0000\u0000\u0000\u0080\u0081"+
		"\u0001\u0000\u0000\u0000\u0081\u0015\u0001\u0000\u0000\u0000\u0082\u0089"+
		"\u0005#\u0000\u0000\u0083\u0089\u0005$\u0000\u0000\u0084\u0085\u0005\u0011"+
		"\u0000\u0000\u0085\u0086\u0003\u000e\u0007\u0000\u0086\u0087\u0005\u0012"+
		"\u0000\u0000\u0087\u0089\u0001\u0000\u0000\u0000\u0088\u0082\u0001\u0000"+
		"\u0000\u0000\u0088\u0083\u0001\u0000\u0000\u0000\u0088\u0084\u0001\u0000"+
		"\u0000\u0000\u0089\u0017\u0001\u0000\u0000\u0000\u008a\u008f\u0003\u001a"+
		"\r\u0000\u008b\u008f\u0003 \u0010\u0000\u008c\u008f\u0003\"\u0011\u0000"+
		"\u008d\u008f\u0003$\u0012\u0000\u008e\u008a\u0001\u0000\u0000\u0000\u008e"+
		"\u008b\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e"+
		"\u008d\u0001\u0000\u0000\u0000\u008f\u0092\u0001\u0000\u0000\u0000\u0090"+
		"\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000\u0091"+
		"\u0019\u0001\u0000\u0000\u0000\u0092\u0090\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0005\u001a\u0000\u0000\u0094\u0095\u0005\u001b\u0000\u0000\u0095"+
		"\u0096\u0005\u0011\u0000\u0000\u0096\u0097\u0003\u001c\u000e\u0000\u0097"+
		"\u0098\u0005\u0012\u0000\u0000\u0098\u0099\u0005\u0013\u0000\u0000\u0099"+
		"\u009a\u0003\"\u0011\u0000\u009a\u009c\u0005\u0014\u0000\u0000\u009b\u009d"+
		"\u0003\u001e\u000f\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0001\u0000\u0000\u0000\u009d\u001b\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0005#\u0000\u0000\u009f\u00a0\u0005(\u0000\u0000\u00a0\u00a8\u0005$"+
		"\u0000\u0000\u00a1\u00a2\u0005#\u0000\u0000\u00a2\u00a3\u0005)\u0000\u0000"+
		"\u00a3\u00a8\u0005$\u0000\u0000\u00a4\u00a5\u0005#\u0000\u0000\u00a5\u00a6"+
		"\u0005)\u0000\u0000\u00a6\u00a8\u0007\u0000\u0000\u0000\u00a7\u009e\u0001"+
		"\u0000\u0000\u0000\u00a7\u00a1\u0001\u0000\u0000\u0000\u00a7\u00a4\u0001"+
		"\u0000\u0000\u0000\u00a8\u001d\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005"+
		"\u001c\u0000\u0000\u00aa\u00ab\u0005\u0013\u0000\u0000\u00ab\u00ac\u0003"+
		"\"\u0011\u0000\u00ac\u00ad\u0005\u0014\u0000\u0000\u00ad\u001f\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0005\u001d\u0000\u0000\u00af\u00b0\u0005\u001e"+
		"\u0000\u0000\u00b0\u00b1\u0005\u0011\u0000\u0000\u00b1\u00b2\u0005#\u0000"+
		"\u0000\u00b2\u00b3\u0005(\u0000\u0000\u00b3\u00b4\u0005$\u0000\u0000\u00b4"+
		"\u00b5\u0005\u0012\u0000\u0000\u00b5\u00b6\u0005\u0013\u0000\u0000\u00b6"+
		"\u00bb\u0003\"\u0011\u0000\u00b7\u00b8\u0005#\u0000\u0000\u00b8\u00bc"+
		"\u0005\u0016\u0000\u0000\u00b9\u00ba\u0005#\u0000\u0000\u00ba\u00bc\u0005"+
		"\u0017\u0000\u0000\u00bb\u00b7\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd\u00be\u0005"+
		"\u0006\u0000\u0000\u00be\u00bf\u0005\u0014\u0000\u0000\u00bf!\u0001\u0000"+
		"\u0000\u0000\u00c0\u00c1\u0005\u001f\u0000\u0000\u00c1\u00c2\u0005 \u0000"+
		"\u0000\u00c2\u00c3\u0005\u0011\u0000\u0000\u00c3\u00c4\u0007\u0001\u0000"+
		"\u0000\u00c4\u00c5\u0005\u0012\u0000\u0000\u00c5\u00ce\u0005\u0006\u0000"+
		"\u0000\u00c6\u00c7\u0005!\u0000\u0000\u00c7\u00c8\u0005#\u0000\u0000\u00c8"+
		"\u00c9\u0005\b\u0000\u0000\u00c9\u00ca\u0005\"\u0000\u0000\u00ca\u00cb"+
		"\u0005\u0011\u0000\u0000\u00cb\u00cc\u0005\u0012\u0000\u0000\u00cc\u00ce"+
		"\u0005\u0006\u0000\u0000\u00cd\u00c0\u0001\u0000\u0000\u0000\u00cd\u00c6"+
		"\u0001\u0000\u0000\u0000\u00ce#\u0001\u0000\u0000\u0000\u00cf\u00d0\u0005"+
		"#\u0000\u0000\u00d0\u00d1\u0005\b\u0000\u0000\u00d1\u00d2\u0005#\u0000"+
		"\u0000\u00d2\u00d3\u0005\u0011\u0000\u0000\u00d3\u00d4\u0005#\u0000\u0000"+
		"\u00d4\u00d5\u0005\u0012\u0000\u0000\u00d5\u00d6\u0005\u0006\u0000\u0000"+
		"\u00d6%\u0001\u0000\u0000\u0000\u000e5:NS^s\u0080\u0088\u008e\u0090\u009c"+
		"\u00a7\u00bb\u00cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}