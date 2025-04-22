// Generated from d:/ESTUDO/COMPILADORES/trabalho_final/team-08/src/main/java/com/example/mijava/antlr/mijava.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class mijavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		MAIN=1, CLASS=2, PUBLIC=3, STATIC=4, VOID=5, RETURN=6, ID=7, INT=8, BOOLEAN=9, 
		STRING=10, INTEGER_LITERAL=11, ADD=12, SUB=13, DIV=14, MUL=15, LPAREN=16, 
		RPAREN=17, LBRACE=18, RBRACE=19, LBRACK=20, RBRACK=21, SEMI=22, COMMA=23, 
		DOT=24, NOT=25, ASSIGN=26, AND=27, LT=28, GT=29, IF=30, ELSE=31, WHILE=32, 
		SOUT=33, LENGTH=34, TRUE=35, FALSE=36, THIS=37, NEW=38;
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDecl = 2, RULE_varDecl = 3, 
		RULE_methodDecl = 4, RULE_formalList = 5, RULE_formalRest = 6, RULE_type = 7, 
		RULE_statement = 8, RULE_expression = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainClass", "classDecl", "varDecl", "methodDecl", "formalList", 
			"formalRest", "type", "statement", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'main'", "'class'", "'public'", "'static'", "'void'", "'return'", 
			null, "'int'", "'boolean'", "'String'", null, "'+'", "'-'", "'/'", "'*'", 
			"'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", "'!'", 
			"'='", "'&&'", "'<'", "'>'", "'if'", "'else'", "'while'", "'System.out.println'", 
			"'length'", "'true'", "'false'", "'this'", "'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "MAIN", "CLASS", "PUBLIC", "STATIC", "VOID", "RETURN", "ID", "INT", 
			"BOOLEAN", "STRING", "INTEGER_LITERAL", "ADD", "SUB", "DIV", "MUL", "LPAREN", 
			"RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", 
			"NOT", "ASSIGN", "AND", "LT", "GT", "IF", "ELSE", "WHILE", "SOUT", "LENGTH", 
			"TRUE", "FALSE", "THIS", "NEW"
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
	public String getGrammarFileName() { return "mijava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public mijavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			mainClass();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(21);
				classDecl();
				}
				}
				setState(26);
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
	public static class MainClassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(mijavaParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(mijavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(mijavaParser.ID, i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(mijavaParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(mijavaParser.LBRACE, i);
		}
		public TerminalNode PUBLIC() { return getToken(mijavaParser.PUBLIC, 0); }
		public TerminalNode STATIC() { return getToken(mijavaParser.STATIC, 0); }
		public TerminalNode VOID() { return getToken(mijavaParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(mijavaParser.MAIN, 0); }
		public TerminalNode LPAREN() { return getToken(mijavaParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(mijavaParser.STRING, 0); }
		public TerminalNode LBRACK() { return getToken(mijavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(mijavaParser.RBRACK, 0); }
		public TerminalNode RPAREN() { return getToken(mijavaParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<TerminalNode> RBRACE() { return getTokens(mijavaParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(mijavaParser.RBRACE, i);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(27);
			match(CLASS);
			setState(28);
			match(ID);
			setState(29);
			match(LBRACE);
			setState(30);
			match(PUBLIC);
			setState(31);
			match(STATIC);
			setState(32);
			match(VOID);
			setState(33);
			match(MAIN);
			setState(34);
			match(LPAREN);
			setState(35);
			match(STRING);
			setState(36);
			match(LBRACK);
			setState(37);
			match(RBRACK);
			setState(38);
			match(ID);
			setState(39);
			match(RPAREN);
			setState(40);
			match(LBRACE);
			setState(41);
			statement();
			setState(42);
			match(RBRACE);
			setState(43);
			match(RBRACE);
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
	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(mijavaParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(mijavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(mijavaParser.RBRACK, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<MethodDeclContext> methodDecl() {
			return getRuleContexts(MethodDeclContext.class);
		}
		public MethodDeclContext methodDecl(int i) {
			return getRuleContext(MethodDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(CLASS);
			setState(46);
			match(ID);
			setState(47);
			match(LBRACK);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 896L) != 0)) {
				{
				{
				setState(48);
				varDecl();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(54);
				methodDecl();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(60);
			match(RBRACK);
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
	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(mijavaParser.SEMI, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			type();
			setState(63);
			match(ID);
			setState(64);
			match(SEMI);
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
	public static class MethodDeclContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(mijavaParser.PUBLIC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(mijavaParser.LPAREN, 0); }
		public FormalListContext formalList() {
			return getRuleContext(FormalListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(mijavaParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(mijavaParser.LBRACE, 0); }
		public TerminalNode RETURN() { return getToken(mijavaParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(mijavaParser.SEMI, 0); }
		public TerminalNode RBRACE() { return getToken(mijavaParser.RBRACE, 0); }
		public List<VarDeclContext> varDecl() {
			return getRuleContexts(VarDeclContext.class);
		}
		public VarDeclContext varDecl(int i) {
			return getRuleContext(VarDeclContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDecl; }
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(PUBLIC);
			setState(67);
			type();
			setState(68);
			match(ID);
			setState(69);
			match(LPAREN);
			setState(70);
			formalList();
			setState(71);
			match(RPAREN);
			setState(72);
			match(LBRACE);
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(73);
					varDecl();
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13958905984L) != 0)) {
				{
				{
				setState(79);
				statement();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
			match(RETURN);
			setState(86);
			expression(0);
			setState(87);
			match(SEMI);
			setState(88);
			match(RBRACE);
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
	public static class FormalListContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public List<FormalRestContext> formalRest() {
			return getRuleContexts(FormalRestContext.class);
		}
		public FormalRestContext formalRest(int i) {
			return getRuleContext(FormalRestContext.class,i);
		}
		public FormalListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalList; }
	}

	public final FormalListContext formalList() throws RecognitionException {
		FormalListContext _localctx = new FormalListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalList);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
			case INT:
			case BOOLEAN:
				enterOuterAlt(_localctx, 1);
				{
				setState(90);
				type();
				setState(91);
				match(ID);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(92);
					formalRest();
					}
					}
					setState(97);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case RPAREN:
				enterOuterAlt(_localctx, 2);
				{
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
	public static class FormalRestContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(mijavaParser.COMMA, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public FormalRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalRest; }
	}

	public final FormalRestContext formalRest() throws RecognitionException {
		FormalRestContext _localctx = new FormalRestContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formalRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(COMMA);
			setState(102);
			type();
			setState(103);
			match(ID);
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(mijavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(mijavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(mijavaParser.RBRACK, 0); }
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public TerminalNode BOOLEAN() { return getToken(mijavaParser.BOOLEAN, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(111);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(105);
				match(INT);
				setState(106);
				match(LBRACK);
				setState(107);
				match(RBRACK);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
				match(INT);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(ID);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(110);
				match(BOOLEAN);
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
	public static class StatementContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(mijavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(mijavaParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode IF() { return getToken(mijavaParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(mijavaParser.LPAREN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RPAREN() { return getToken(mijavaParser.RPAREN, 0); }
		public TerminalNode ELSE() { return getToken(mijavaParser.ELSE, 0); }
		public TerminalNode WHILE() { return getToken(mijavaParser.WHILE, 0); }
		public TerminalNode SOUT() { return getToken(mijavaParser.SOUT, 0); }
		public TerminalNode SEMI() { return getToken(mijavaParser.SEMI, 0); }
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(mijavaParser.ASSIGN, 0); }
		public TerminalNode LBRACK() { return getToken(mijavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(mijavaParser.RBRACK, 0); }
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(LBRACE);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 13958905984L) != 0)) {
					{
					{
					setState(114);
					statement();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(IF);
				setState(122);
				match(LPAREN);
				setState(123);
				expression(0);
				setState(124);
				match(RPAREN);
				setState(125);
				statement();
				setState(126);
				match(ELSE);
				setState(127);
				statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(WHILE);
				setState(130);
				match(LPAREN);
				setState(131);
				expression(0);
				setState(132);
				match(RPAREN);
				setState(133);
				statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(135);
				match(SOUT);
				setState(136);
				match(LPAREN);
				setState(137);
				expression(0);
				setState(138);
				match(RPAREN);
				setState(139);
				match(SEMI);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(141);
				match(ID);
				setState(142);
				match(ASSIGN);
				setState(143);
				expression(0);
				setState(144);
				match(SEMI);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(146);
				match(ID);
				setState(147);
				match(LBRACK);
				setState(148);
				expression(0);
				setState(149);
				match(RBRACK);
				setState(150);
				match(ASSIGN);
				setState(151);
				expression(0);
				setState(152);
				match(SEMI);
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
	public static class ExpressionContext extends ParserRuleContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(mijavaParser.INTEGER_LITERAL, 0); }
		public TerminalNode TRUE() { return getToken(mijavaParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(mijavaParser.FALSE, 0); }
		public TerminalNode ID() { return getToken(mijavaParser.ID, 0); }
		public TerminalNode THIS() { return getToken(mijavaParser.THIS, 0); }
		public TerminalNode NEW() { return getToken(mijavaParser.NEW, 0); }
		public TerminalNode INT() { return getToken(mijavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(mijavaParser.LBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(mijavaParser.RBRACK, 0); }
		public TerminalNode LBRACE() { return getToken(mijavaParser.LBRACE, 0); }
		public TerminalNode RPAREN() { return getToken(mijavaParser.RPAREN, 0); }
		public TerminalNode NOT() { return getToken(mijavaParser.NOT, 0); }
		public TerminalNode LPAREN() { return getToken(mijavaParser.LPAREN, 0); }
		public TerminalNode AND() { return getToken(mijavaParser.AND, 0); }
		public TerminalNode LT() { return getToken(mijavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(mijavaParser.GT, 0); }
		public TerminalNode ADD() { return getToken(mijavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(mijavaParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(mijavaParser.MUL, 0); }
		public TerminalNode DOT() { return getToken(mijavaParser.DOT, 0); }
		public TerminalNode LENGTH() { return getToken(mijavaParser.LENGTH, 0); }
		public List<TerminalNode> COMMA() { return getTokens(mijavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(mijavaParser.COMMA, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(157);
				match(INTEGER_LITERAL);
				}
				break;
			case 2:
				{
				setState(158);
				match(TRUE);
				}
				break;
			case 3:
				{
				setState(159);
				match(FALSE);
				}
				break;
			case 4:
				{
				setState(160);
				match(ID);
				}
				break;
			case 5:
				{
				setState(161);
				match(THIS);
				}
				break;
			case 6:
				{
				setState(162);
				match(NEW);
				setState(163);
				match(INT);
				setState(164);
				match(LBRACK);
				setState(165);
				expression(0);
				setState(166);
				match(RBRACK);
				}
				break;
			case 7:
				{
				setState(168);
				match(NEW);
				setState(169);
				match(ID);
				setState(170);
				match(LBRACE);
				setState(171);
				match(RPAREN);
				}
				break;
			case 8:
				{
				setState(172);
				match(NOT);
				setState(173);
				expression(2);
				}
				break;
			case 9:
				{
				setState(174);
				match(LPAREN);
				setState(175);
				expression(0);
				setState(176);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(208);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(206);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(180);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(181);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 939569152L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(182);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(184);
						match(LBRACK);
						setState(185);
						expression(0);
						setState(186);
						match(RBRACK);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(189);
						match(DOT);
						setState(190);
						match(LENGTH);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(192);
						match(DOT);
						setState(193);
						match(ID);
						setState(194);
						match(LPAREN);
						setState(203);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 515429697664L) != 0)) {
							{
							setState(195);
							expression(0);
							setState(200);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(196);
								match(COMMA);
								setState(197);
								expression(0);
								}
								}
								setState(202);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(205);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(210);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 12);
		case 2:
			return precpred(_ctx, 11);
		case 3:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001&\u00d4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0005\u0000\u0017\b"+
		"\u0000\n\u0000\f\u0000\u001a\t\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u00022\b\u0002\n\u0002\f\u00025\t\u0002\u0001\u0002"+
		"\u0005\u00028\b\u0002\n\u0002\f\u0002;\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0005\u0004K\b\u0004\n\u0004\f\u0004N\t\u0004\u0001\u0004\u0005\u0004"+
		"Q\b\u0004\n\u0004\f\u0004T\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005"+
		"^\b\u0005\n\u0005\f\u0005a\t\u0005\u0001\u0005\u0003\u0005d\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007p\b\u0007\u0001"+
		"\b\u0001\b\u0005\bt\b\b\n\b\f\bw\t\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u009b\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003"+
		"\t\u00b3\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0005\t\u00c7\b\t\n\t\f\t\u00ca\t\t\u0003\t\u00cc\b\t\u0001"+
		"\t\u0005\t\u00cf\b\t\n\t\f\t\u00d2\t\t\u0001\t\u0000\u0001\u0012\n\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0001\u0003\u0000\f\r"+
		"\u000f\u000f\u001b\u001d\u00e7\u0000\u0014\u0001\u0000\u0000\u0000\u0002"+
		"\u001b\u0001\u0000\u0000\u0000\u0004-\u0001\u0000\u0000\u0000\u0006>\u0001"+
		"\u0000\u0000\u0000\bB\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000"+
		"\fe\u0001\u0000\u0000\u0000\u000eo\u0001\u0000\u0000\u0000\u0010\u009a"+
		"\u0001\u0000\u0000\u0000\u0012\u00b2\u0001\u0000\u0000\u0000\u0014\u0018"+
		"\u0003\u0002\u0001\u0000\u0015\u0017\u0003\u0004\u0002\u0000\u0016\u0015"+
		"\u0001\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u0016"+
		"\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u0001"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0005\u0002\u0000\u0000\u001c\u001d\u0005\u0007\u0000\u0000\u001d\u001e"+
		"\u0005\u0012\u0000\u0000\u001e\u001f\u0005\u0003\u0000\u0000\u001f \u0005"+
		"\u0004\u0000\u0000 !\u0005\u0005\u0000\u0000!\"\u0005\u0001\u0000\u0000"+
		"\"#\u0005\u0010\u0000\u0000#$\u0005\n\u0000\u0000$%\u0005\u0014\u0000"+
		"\u0000%&\u0005\u0015\u0000\u0000&\'\u0005\u0007\u0000\u0000\'(\u0005\u0011"+
		"\u0000\u0000()\u0005\u0012\u0000\u0000)*\u0003\u0010\b\u0000*+\u0005\u0013"+
		"\u0000\u0000+,\u0005\u0013\u0000\u0000,\u0003\u0001\u0000\u0000\u0000"+
		"-.\u0005\u0002\u0000\u0000./\u0005\u0007\u0000\u0000/3\u0005\u0014\u0000"+
		"\u000002\u0003\u0006\u0003\u000010\u0001\u0000\u0000\u000025\u0001\u0000"+
		"\u0000\u000031\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000049\u0001"+
		"\u0000\u0000\u000053\u0001\u0000\u0000\u000068\u0003\b\u0004\u000076\u0001"+
		"\u0000\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000"+
		"9:\u0001\u0000\u0000\u0000:<\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000"+
		"\u0000<=\u0005\u0015\u0000\u0000=\u0005\u0001\u0000\u0000\u0000>?\u0003"+
		"\u000e\u0007\u0000?@\u0005\u0007\u0000\u0000@A\u0005\u0016\u0000\u0000"+
		"A\u0007\u0001\u0000\u0000\u0000BC\u0005\u0003\u0000\u0000CD\u0003\u000e"+
		"\u0007\u0000DE\u0005\u0007\u0000\u0000EF\u0005\u0010\u0000\u0000FG\u0003"+
		"\n\u0005\u0000GH\u0005\u0011\u0000\u0000HL\u0005\u0012\u0000\u0000IK\u0003"+
		"\u0006\u0003\u0000JI\u0001\u0000\u0000\u0000KN\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MR\u0001\u0000\u0000"+
		"\u0000NL\u0001\u0000\u0000\u0000OQ\u0003\u0010\b\u0000PO\u0001\u0000\u0000"+
		"\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000RS\u0001\u0000"+
		"\u0000\u0000SU\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000\u0000UV\u0005"+
		"\u0006\u0000\u0000VW\u0003\u0012\t\u0000WX\u0005\u0016\u0000\u0000XY\u0005"+
		"\u0013\u0000\u0000Y\t\u0001\u0000\u0000\u0000Z[\u0003\u000e\u0007\u0000"+
		"[_\u0005\u0007\u0000\u0000\\^\u0003\f\u0006\u0000]\\\u0001\u0000\u0000"+
		"\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000\u0000_`\u0001\u0000"+
		"\u0000\u0000`d\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000bd\u0001"+
		"\u0000\u0000\u0000cZ\u0001\u0000\u0000\u0000cb\u0001\u0000\u0000\u0000"+
		"d\u000b\u0001\u0000\u0000\u0000ef\u0005\u0017\u0000\u0000fg\u0003\u000e"+
		"\u0007\u0000gh\u0005\u0007\u0000\u0000h\r\u0001\u0000\u0000\u0000ij\u0005"+
		"\b\u0000\u0000jk\u0005\u0014\u0000\u0000kp\u0005\u0015\u0000\u0000lp\u0005"+
		"\b\u0000\u0000mp\u0005\u0007\u0000\u0000np\u0005\t\u0000\u0000oi\u0001"+
		"\u0000\u0000\u0000ol\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"on\u0001\u0000\u0000\u0000p\u000f\u0001\u0000\u0000\u0000qu\u0005\u0012"+
		"\u0000\u0000rt\u0003\u0010\b\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000"+
		"\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vx\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000x\u009b\u0005\u0013\u0000"+
		"\u0000yz\u0005\u001e\u0000\u0000z{\u0005\u0010\u0000\u0000{|\u0003\u0012"+
		"\t\u0000|}\u0005\u0011\u0000\u0000}~\u0003\u0010\b\u0000~\u007f\u0005"+
		"\u001f\u0000\u0000\u007f\u0080\u0003\u0010\b\u0000\u0080\u009b\u0001\u0000"+
		"\u0000\u0000\u0081\u0082\u0005 \u0000\u0000\u0082\u0083\u0005\u0010\u0000"+
		"\u0000\u0083\u0084\u0003\u0012\t\u0000\u0084\u0085\u0005\u0011\u0000\u0000"+
		"\u0085\u0086\u0003\u0010\b\u0000\u0086\u009b\u0001\u0000\u0000\u0000\u0087"+
		"\u0088\u0005!\u0000\u0000\u0088\u0089\u0005\u0010\u0000\u0000\u0089\u008a"+
		"\u0003\u0012\t\u0000\u008a\u008b\u0005\u0011\u0000\u0000\u008b\u008c\u0005"+
		"\u0016\u0000\u0000\u008c\u009b\u0001\u0000\u0000\u0000\u008d\u008e\u0005"+
		"\u0007\u0000\u0000\u008e\u008f\u0005\u001a\u0000\u0000\u008f\u0090\u0003"+
		"\u0012\t\u0000\u0090\u0091\u0005\u0016\u0000\u0000\u0091\u009b\u0001\u0000"+
		"\u0000\u0000\u0092\u0093\u0005\u0007\u0000\u0000\u0093\u0094\u0005\u0014"+
		"\u0000\u0000\u0094\u0095\u0003\u0012\t\u0000\u0095\u0096\u0005\u0015\u0000"+
		"\u0000\u0096\u0097\u0005\u001a\u0000\u0000\u0097\u0098\u0003\u0012\t\u0000"+
		"\u0098\u0099\u0005\u0016\u0000\u0000\u0099\u009b\u0001\u0000\u0000\u0000"+
		"\u009aq\u0001\u0000\u0000\u0000\u009ay\u0001\u0000\u0000\u0000\u009a\u0081"+
		"\u0001\u0000\u0000\u0000\u009a\u0087\u0001\u0000\u0000\u0000\u009a\u008d"+
		"\u0001\u0000\u0000\u0000\u009a\u0092\u0001\u0000\u0000\u0000\u009b\u0011"+
		"\u0001\u0000\u0000\u0000\u009c\u009d\u0006\t\uffff\uffff\u0000\u009d\u00b3"+
		"\u0005\u000b\u0000\u0000\u009e\u00b3\u0005#\u0000\u0000\u009f\u00b3\u0005"+
		"$\u0000\u0000\u00a0\u00b3\u0005\u0007\u0000\u0000\u00a1\u00b3\u0005%\u0000"+
		"\u0000\u00a2\u00a3\u0005&\u0000\u0000\u00a3\u00a4\u0005\b\u0000\u0000"+
		"\u00a4\u00a5\u0005\u0014\u0000\u0000\u00a5\u00a6\u0003\u0012\t\u0000\u00a6"+
		"\u00a7\u0005\u0015\u0000\u0000\u00a7\u00b3\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0005&\u0000\u0000\u00a9\u00aa\u0005\u0007\u0000\u0000\u00aa\u00ab"+
		"\u0005\u0012\u0000\u0000\u00ab\u00b3\u0005\u0011\u0000\u0000\u00ac\u00ad"+
		"\u0005\u0019\u0000\u0000\u00ad\u00b3\u0003\u0012\t\u0002\u00ae\u00af\u0005"+
		"\u0010\u0000\u0000\u00af\u00b0\u0003\u0012\t\u0000\u00b0\u00b1\u0005\u0011"+
		"\u0000\u0000\u00b1\u00b3\u0001\u0000\u0000\u0000\u00b2\u009c\u0001\u0000"+
		"\u0000\u0000\u00b2\u009e\u0001\u0000\u0000\u0000\u00b2\u009f\u0001\u0000"+
		"\u0000\u0000\u00b2\u00a0\u0001\u0000\u0000\u0000\u00b2\u00a1\u0001\u0000"+
		"\u0000\u0000\u00b2\u00a2\u0001\u0000\u0000\u0000\u00b2\u00a8\u0001\u0000"+
		"\u0000\u0000\u00b2\u00ac\u0001\u0000\u0000\u0000\u00b2\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b3\u00d0\u0001\u0000\u0000\u0000\u00b4\u00b5\n\r\u0000"+
		"\u0000\u00b5\u00b6\u0007\u0000\u0000\u0000\u00b6\u00cf\u0003\u0012\t\u000e"+
		"\u00b7\u00b8\n\f\u0000\u0000\u00b8\u00b9\u0005\u0014\u0000\u0000\u00b9"+
		"\u00ba\u0003\u0012\t\u0000\u00ba\u00bb\u0005\u0015\u0000\u0000\u00bb\u00cf"+
		"\u0001\u0000\u0000\u0000\u00bc\u00bd\n\u000b\u0000\u0000\u00bd\u00be\u0005"+
		"\u0018\u0000\u0000\u00be\u00cf\u0005\"\u0000\u0000\u00bf\u00c0\n\n\u0000"+
		"\u0000\u00c0\u00c1\u0005\u0018\u0000\u0000\u00c1\u00c2\u0005\u0007\u0000"+
		"\u0000\u00c2\u00cb\u0005\u0010\u0000\u0000\u00c3\u00c8\u0003\u0012\t\u0000"+
		"\u00c4\u00c5\u0005\u0017\u0000\u0000\u00c5\u00c7\u0003\u0012\t\u0000\u00c6"+
		"\u00c4\u0001\u0000\u0000\u0000\u00c7\u00ca\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c6\u0001\u0000\u0000\u0000\u00c8\u00c9\u0001\u0000\u0000\u0000\u00c9"+
		"\u00cc\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000\u0000\u0000\u00cb"+
		"\u00c3\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc"+
		"\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005\u0011\u0000\u0000\u00ce"+
		"\u00b4\u0001\u0000\u0000\u0000\u00ce\u00b7\u0001\u0000\u0000\u0000\u00ce"+
		"\u00bc\u0001\u0000\u0000\u0000\u00ce\u00bf\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d2\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d1\u0013\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d0\u0001\u0000\u0000\u0000\u000f\u001839LR_cou\u009a\u00b2\u00c8\u00cb"+
		"\u00ce\u00d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}