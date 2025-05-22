// Generated from /home/guilherme/Documentos/Documentos_Importantes/UFC/7_semestre/Compiladores/mijava/src/main/java/com/example/mijava/antlr/Mijava.g4 by ANTLR 4.13.2
package com.example.mijava.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class MijavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LPAREN=1, RPAREN=2, LBRACE=3, RBRACE=4, LBRACK=5, RBRACK=6, SEMI=7, COMMA=8, 
		DOT=9, NOT=10, ASSIGN=11, AND=12, LT=13, GT=14, ADD=15, SUB=16, DIV=17, 
		MUL=18, MAIN=19, CLASS=20, EXTENDS=21, PUBLIC=22, STATIC=23, VOID=24, 
		RETURN=25, STRING=26, INT=27, BOOLEAN=28, IF=29, ELSE=30, WHILE=31, SOUT=32, 
		LENGTH=33, TRUE=34, FALSE=35, THIS=36, NEW=37, ID=38, INTEGER_LITERAL=39, 
		LINECOMMENT=40, COMMENT=41, WS=42;
	public static final int
		RULE_program = 0, RULE_mainClass = 1, RULE_classDecl = 2, RULE_varDecl = 3, 
		RULE_methodDecl = 4, RULE_formalList = 5, RULE_formalRest = 6, RULE_type = 7, 
		RULE_statement = 8, RULE_expression = 9, RULE_identifier = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainClass", "classDecl", "varDecl", "methodDecl", "formalList", 
			"formalRest", "type", "statement", "expression", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "'{'", "'}'", "'['", "']'", "';'", "','", "'.'", 
			"'!'", "'='", "'&&'", "'<'", "'>'", "'+'", "'-'", "'/'", "'*'", "'main'", 
			"'class'", "'extends'", "'public'", "'static'", "'void'", "'return'", 
			"'String'", "'int'", "'boolean'", "'if'", "'else'", "'while'", "'System.out.println'", 
			"'length'", "'true'", "'false'", "'this'", "'new'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LPAREN", "RPAREN", "LBRACE", "RBRACE", "LBRACK", "RBRACK", "SEMI", 
			"COMMA", "DOT", "NOT", "ASSIGN", "AND", "LT", "GT", "ADD", "SUB", "DIV", 
			"MUL", "MAIN", "CLASS", "EXTENDS", "PUBLIC", "STATIC", "VOID", "RETURN", 
			"STRING", "INT", "BOOLEAN", "IF", "ELSE", "WHILE", "SOUT", "LENGTH", 
			"TRUE", "FALSE", "THIS", "NEW", "ID", "INTEGER_LITERAL", "LINECOMMENT", 
			"COMMENT", "WS"
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
	public String getGrammarFileName() { return "Mijava.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MijavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public MainClassContext mainClass() {
			return getRuleContext(MainClassContext.class,0);
		}
		public TerminalNode EOF() { return getToken(MijavaParser.EOF, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			mainClass();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(23);
				classDecl();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
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
	public static class MainClassContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MijavaParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(MijavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MijavaParser.ID, i);
		}
		public List<TerminalNode> LBRACE() { return getTokens(MijavaParser.LBRACE); }
		public TerminalNode LBRACE(int i) {
			return getToken(MijavaParser.LBRACE, i);
		}
		public TerminalNode PUBLIC() { return getToken(MijavaParser.PUBLIC, 0); }
		public TerminalNode STATIC() { return getToken(MijavaParser.STATIC, 0); }
		public TerminalNode VOID() { return getToken(MijavaParser.VOID, 0); }
		public TerminalNode MAIN() { return getToken(MijavaParser.MAIN, 0); }
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public TerminalNode STRING() { return getToken(MijavaParser.STRING, 0); }
		public TerminalNode LBRACK() { return getToken(MijavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MijavaParser.RBRACK, 0); }
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<TerminalNode> RBRACE() { return getTokens(MijavaParser.RBRACE); }
		public TerminalNode RBRACE(int i) {
			return getToken(MijavaParser.RBRACE, i);
		}
		public MainClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterMainClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitMainClass(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitMainClass(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MainClassContext mainClass() throws RecognitionException {
		MainClassContext _localctx = new MainClassContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_mainClass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(31);
			match(CLASS);
			setState(32);
			match(ID);
			setState(33);
			match(LBRACE);
			setState(34);
			match(PUBLIC);
			setState(35);
			match(STATIC);
			setState(36);
			match(VOID);
			setState(37);
			match(MAIN);
			setState(38);
			match(LPAREN);
			setState(39);
			match(STRING);
			setState(40);
			match(LBRACK);
			setState(41);
			match(RBRACK);
			setState(42);
			match(ID);
			setState(43);
			match(RPAREN);
			setState(44);
			match(LBRACE);
			setState(45);
			statement();
			setState(46);
			match(RBRACE);
			setState(47);
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
		public TerminalNode CLASS() { return getToken(MijavaParser.CLASS, 0); }
		public List<TerminalNode> ID() { return getTokens(MijavaParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(MijavaParser.ID, i);
		}
		public TerminalNode LBRACE() { return getToken(MijavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MijavaParser.RBRACE, 0); }
		public TerminalNode EXTENDS() { return getToken(MijavaParser.EXTENDS, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(CLASS);
			setState(50);
			match(ID);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(51);
				match(EXTENDS);
				setState(52);
				match(ID);
				}
			}

			setState(55);
			match(LBRACE);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 275280560128L) != 0)) {
				{
				{
				setState(56);
				varDecl();
				}
				}
				setState(61);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(62);
				methodDecl();
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68);
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
	public static class VarDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(MijavaParser.SEMI, 0); }
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterVarDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitVarDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			type();
			setState(71);
			match(ID);
			setState(72);
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
		public TerminalNode PUBLIC() { return getToken(MijavaParser.PUBLIC, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public FormalListContext formalList() {
			return getRuleContext(FormalListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MijavaParser.LBRACE, 0); }
		public TerminalNode RETURN() { return getToken(MijavaParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MijavaParser.SEMI, 0); }
		public TerminalNode RBRACE() { return getToken(MijavaParser.RBRACE, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterMethodDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitMethodDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitMethodDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclContext methodDecl() throws RecognitionException {
		MethodDeclContext _localctx = new MethodDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDecl);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(PUBLIC);
			setState(75);
			type();
			setState(76);
			match(ID);
			setState(77);
			match(LPAREN);
			setState(78);
			formalList();
			setState(79);
			match(RPAREN);
			setState(80);
			match(LBRACE);
			setState(84);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(81);
					varDecl();
					}
					} 
				}
				setState(86);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281857228808L) != 0)) {
				{
				{
				setState(87);
				statement();
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(93);
			match(RETURN);
			setState(94);
			expression(0);
			setState(95);
			match(SEMI);
			setState(96);
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
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
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
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterFormalList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitFormalList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitFormalList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalListContext formalList() throws RecognitionException {
		FormalListContext _localctx = new FormalListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formalList);
		int _la;
		try {
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOLEAN:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				type();
				setState(99);
				match(ID);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(100);
					formalRest();
					}
					}
					setState(105);
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
		public TerminalNode COMMA() { return getToken(MijavaParser.COMMA, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public FormalRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalRest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterFormalRest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitFormalRest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitFormalRest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalRestContext formalRest() throws RecognitionException {
		FormalRestContext _localctx = new FormalRestContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formalRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			match(COMMA);
			setState(110);
			type();
			setState(111);
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
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanTypeContext extends TypeContext {
		public TerminalNode BOOLEAN() { return getToken(MijavaParser.BOOLEAN, 0); }
		public BooleanTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterBooleanType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitBooleanType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitBooleanType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerTypeContext extends TypeContext {
		public TerminalNode INT() { return getToken(MijavaParser.INT, 0); }
		public IntegerTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterIntegerType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitIntegerType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitIntegerType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntArrayTypeContext extends TypeContext {
		public TerminalNode INT() { return getToken(MijavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(MijavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MijavaParser.RBRACK, 0); }
		public IntArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterIntArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitIntArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitIntArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierTypeContext extends TypeContext {
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public IdentifierTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterIdentifierType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitIdentifierType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitIdentifierType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new IntArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(113);
				match(INT);
				setState(114);
				match(LBRACK);
				setState(115);
				match(RBRACK);
				}
				break;
			case 2:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(116);
				match(INT);
				}
				break;
			case 3:
				_localctx = new IdentifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(ID);
				}
				break;
			case 4:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(118);
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
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(MijavaParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitWhileStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatementContext extends StatementContext {
		public TerminalNode SOUT() { return getToken(MijavaParser.SOUT, 0); }
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(MijavaParser.SEMI, 0); }
		public PrintStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterPrintStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitPrintStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitPrintStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends StatementContext {
		public TerminalNode LBRACE() { return getToken(MijavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(MijavaParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitBlockStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitBlockStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAssignStatementContext extends StatementContext {
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public TerminalNode LBRACK() { return getToken(MijavaParser.LBRACK, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RBRACK() { return getToken(MijavaParser.RBRACK, 0); }
		public TerminalNode ASSIGN() { return getToken(MijavaParser.ASSIGN, 0); }
		public TerminalNode SEMI() { return getToken(MijavaParser.SEMI, 0); }
		public ArrayAssignStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterArrayAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitArrayAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitArrayAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignStatementContext extends StatementContext {
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(MijavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MijavaParser.SEMI, 0); }
		public AssignStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterAssignStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitAssignStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitAssignStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends StatementContext {
		public TerminalNode IF() { return getToken(MijavaParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MijavaParser.ELSE, 0); }
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		int _la;
		try {
			setState(162);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(LBRACE);
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281857228808L) != 0)) {
					{
					{
					setState(122);
					statement();
					}
					}
					setState(127);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(128);
				match(RBRACE);
				}
				break;
			case 2:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(129);
				match(IF);
				setState(130);
				match(LPAREN);
				setState(131);
				expression(0);
				setState(132);
				match(RPAREN);
				setState(133);
				statement();
				setState(134);
				match(ELSE);
				setState(135);
				statement();
				}
				break;
			case 3:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(WHILE);
				setState(138);
				match(LPAREN);
				setState(139);
				expression(0);
				setState(140);
				match(RPAREN);
				setState(141);
				statement();
				}
				break;
			case 4:
				_localctx = new PrintStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(143);
				match(SOUT);
				setState(144);
				match(LPAREN);
				setState(145);
				expression(0);
				setState(146);
				match(RPAREN);
				setState(147);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new AssignStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(149);
				match(ID);
				setState(150);
				match(ASSIGN);
				setState(151);
				expression(0);
				setState(152);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new ArrayAssignStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(154);
				match(ID);
				setState(155);
				match(LBRACK);
				setState(156);
				expression(0);
				setState(157);
				match(RBRACK);
				setState(158);
				match(ASSIGN);
				setState(159);
				expression(0);
				setState(160);
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
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterIdentifierExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitIdentifierExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitIdentifierExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DOT() { return getToken(MijavaParser.DOT, 0); }
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public List<TerminalNode> COMMA() { return getTokens(MijavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MijavaParser.COMMA, i);
		}
		public MethodCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterMethodCallExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitMethodCallExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitMethodCallExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseExpressionContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(MijavaParser.FALSE, 0); }
		public FalseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterFalseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitFalseExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitFalseExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(MijavaParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterNotExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitNotExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitNotExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntergerLiteralExpressionContext extends ExpressionContext {
		public TerminalNode INTEGER_LITERAL() { return getToken(MijavaParser.INTEGER_LITERAL, 0); }
		public IntergerLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterIntergerLiteralExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitIntergerLiteralExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitIntergerLiteralExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinaryExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(MijavaParser.AND, 0); }
		public TerminalNode LT() { return getToken(MijavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(MijavaParser.GT, 0); }
		public TerminalNode ADD() { return getToken(MijavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(MijavaParser.SUB, 0); }
		public TerminalNode MUL() { return getToken(MijavaParser.MUL, 0); }
		public BinaryExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitBinaryExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitBinaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayAccessExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LBRACK() { return getToken(MijavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(MijavaParser.RBRACK, 0); }
		public ArrayAccessExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterArrayAccessExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitArrayAccessExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitArrayAccessExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewObjectExpressionContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(MijavaParser.NEW, 0); }
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public NewObjectExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterNewObjectExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitNewObjectExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitNewObjectExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueExpressionContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(MijavaParser.TRUE, 0); }
		public TrueExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterTrueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitTrueExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitTrueExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ThisExpressionContext extends ExpressionContext {
		public TerminalNode THIS() { return getToken(MijavaParser.THIS, 0); }
		public ThisExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterThisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitThisExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitThisExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayLengthExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(MijavaParser.DOT, 0); }
		public TerminalNode LENGTH() { return getToken(MijavaParser.LENGTH, 0); }
		public ArrayLengthExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterArrayLengthExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitArrayLengthExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitArrayLengthExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewArrayExpressionContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(MijavaParser.NEW, 0); }
		public TerminalNode INT() { return getToken(MijavaParser.INT, 0); }
		public TerminalNode LBRACK() { return getToken(MijavaParser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(MijavaParser.RBRACK, 0); }
		public NewArrayExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterNewArrayExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitNewArrayExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitNewArrayExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InnerExpressionContext extends ExpressionContext {
		public TerminalNode LPAREN() { return getToken(MijavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public InnerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterInnerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitInnerExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitInnerExpression(this);
			else return visitor.visitChildren(this);
		}
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
			setState(186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new IntergerLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(165);
				match(INTEGER_LITERAL);
				}
				break;
			case 2:
				{
				_localctx = new TrueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				match(TRUE);
				}
				break;
			case 3:
				{
				_localctx = new FalseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				match(FALSE);
				}
				break;
			case 4:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ThisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(169);
				match(THIS);
				}
				break;
			case 6:
				{
				_localctx = new NewArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				match(NEW);
				setState(171);
				match(INT);
				setState(172);
				match(LBRACK);
				setState(173);
				expression(0);
				setState(174);
				match(RBRACK);
				}
				break;
			case 7:
				{
				_localctx = new NewObjectExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176);
				match(NEW);
				setState(177);
				match(ID);
				setState(178);
				match(LPAREN);
				setState(179);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180);
				match(NOT);
				setState(181);
				expression(2);
				}
				break;
			case 9:
				{
				_localctx = new InnerExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(182);
				match(LPAREN);
				setState(183);
				expression(0);
				setState(184);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(214);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(188);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(189);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 389120L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(190);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ArrayAccessExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(192);
						match(LBRACK);
						setState(193);
						expression(0);
						setState(194);
						match(RBRACK);
						}
						break;
					case 3:
						{
						_localctx = new ArrayLengthExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(196);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(197);
						match(DOT);
						setState(198);
						match(LENGTH);
						}
						break;
					case 4:
						{
						_localctx = new MethodCallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(199);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(200);
						match(DOT);
						setState(201);
						match(ID);
						setState(202);
						match(LPAREN);
						setState(211);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082331759618L) != 0)) {
							{
							setState(203);
							expression(0);
							setState(208);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(204);
								match(COMMA);
								setState(205);
								expression(0);
								}
								}
								setState(210);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(213);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MijavaParser.ID, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MijavaListener ) ((MijavaListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MijavaVisitor ) return ((MijavaVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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
		"\u0004\u0001*\u00de\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0019\b\u0000\n\u0000\f\u0000\u001c\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00026\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0005\u0002:\b\u0002\n\u0002\f\u0002=\t\u0002"+
		"\u0001\u0002\u0005\u0002@\b\u0002\n\u0002\f\u0002C\t\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0005\u0004S\b\u0004\n\u0004\f\u0004V\t\u0004\u0001\u0004"+
		"\u0005\u0004Y\b\u0004\n\u0004\f\u0004\\\t\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005f\b\u0005\n\u0005\f\u0005i\t\u0005\u0001\u0005\u0003\u0005"+
		"l\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007"+
		"x\b\u0007\u0001\b\u0001\b\u0005\b|\b\b\n\b\f\b\u007f\t\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a3\b\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\t\u00bb\b\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0005\t\u00cf\b\t\n\t\f\t\u00d2\t\t"+
		"\u0003\t\u00d4\b\t\u0001\t\u0005\t\u00d7\b\t\n\t\f\t\u00da\t\t\u0001\n"+
		"\u0001\n\u0001\n\u0000\u0001\u0012\u000b\u0000\u0002\u0004\u0006\b\n\f"+
		"\u000e\u0010\u0012\u0014\u0000\u0001\u0002\u0000\f\u0010\u0012\u0012\u00f1"+
		"\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u001f\u0001\u0000\u0000\u0000"+
		"\u00041\u0001\u0000\u0000\u0000\u0006F\u0001\u0000\u0000\u0000\bJ\u0001"+
		"\u0000\u0000\u0000\nk\u0001\u0000\u0000\u0000\fm\u0001\u0000\u0000\u0000"+
		"\u000ew\u0001\u0000\u0000\u0000\u0010\u00a2\u0001\u0000\u0000\u0000\u0012"+
		"\u00ba\u0001\u0000\u0000\u0000\u0014\u00db\u0001\u0000\u0000\u0000\u0016"+
		"\u001a\u0003\u0002\u0001\u0000\u0017\u0019\u0003\u0004\u0002\u0000\u0018"+
		"\u0017\u0001\u0000\u0000\u0000\u0019\u001c\u0001\u0000\u0000\u0000\u001a"+
		"\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b"+
		"\u001d\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000\u001d"+
		"\u001e\u0005\u0000\u0000\u0001\u001e\u0001\u0001\u0000\u0000\u0000\u001f"+
		" \u0005\u0014\u0000\u0000 !\u0005&\u0000\u0000!\"\u0005\u0003\u0000\u0000"+
		"\"#\u0005\u0016\u0000\u0000#$\u0005\u0017\u0000\u0000$%\u0005\u0018\u0000"+
		"\u0000%&\u0005\u0013\u0000\u0000&\'\u0005\u0001\u0000\u0000\'(\u0005\u001a"+
		"\u0000\u0000()\u0005\u0005\u0000\u0000)*\u0005\u0006\u0000\u0000*+\u0005"+
		"&\u0000\u0000+,\u0005\u0002\u0000\u0000,-\u0005\u0003\u0000\u0000-.\u0003"+
		"\u0010\b\u0000./\u0005\u0004\u0000\u0000/0\u0005\u0004\u0000\u00000\u0003"+
		"\u0001\u0000\u0000\u000012\u0005\u0014\u0000\u000025\u0005&\u0000\u0000"+
		"34\u0005\u0015\u0000\u000046\u0005&\u0000\u000053\u0001\u0000\u0000\u0000"+
		"56\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u00007;\u0005\u0003\u0000"+
		"\u00008:\u0003\u0006\u0003\u000098\u0001\u0000\u0000\u0000:=\u0001\u0000"+
		"\u0000\u0000;9\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000<A\u0001"+
		"\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000>@\u0003\b\u0004\u0000?>\u0001"+
		"\u0000\u0000\u0000@C\u0001\u0000\u0000\u0000A?\u0001\u0000\u0000\u0000"+
		"AB\u0001\u0000\u0000\u0000BD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000"+
		"\u0000DE\u0005\u0004\u0000\u0000E\u0005\u0001\u0000\u0000\u0000FG\u0003"+
		"\u000e\u0007\u0000GH\u0005&\u0000\u0000HI\u0005\u0007\u0000\u0000I\u0007"+
		"\u0001\u0000\u0000\u0000JK\u0005\u0016\u0000\u0000KL\u0003\u000e\u0007"+
		"\u0000LM\u0005&\u0000\u0000MN\u0005\u0001\u0000\u0000NO\u0003\n\u0005"+
		"\u0000OP\u0005\u0002\u0000\u0000PT\u0005\u0003\u0000\u0000QS\u0003\u0006"+
		"\u0003\u0000RQ\u0001\u0000\u0000\u0000SV\u0001\u0000\u0000\u0000TR\u0001"+
		"\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UZ\u0001\u0000\u0000\u0000"+
		"VT\u0001\u0000\u0000\u0000WY\u0003\u0010\b\u0000XW\u0001\u0000\u0000\u0000"+
		"Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000"+
		"\u0000[]\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]^\u0005\u0019"+
		"\u0000\u0000^_\u0003\u0012\t\u0000_`\u0005\u0007\u0000\u0000`a\u0005\u0004"+
		"\u0000\u0000a\t\u0001\u0000\u0000\u0000bc\u0003\u000e\u0007\u0000cg\u0005"+
		"&\u0000\u0000df\u0003\f\u0006\u0000ed\u0001\u0000\u0000\u0000fi\u0001"+
		"\u0000\u0000\u0000ge\u0001\u0000\u0000\u0000gh\u0001\u0000\u0000\u0000"+
		"hl\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000kb\u0001\u0000\u0000\u0000kj\u0001\u0000\u0000\u0000l\u000b\u0001"+
		"\u0000\u0000\u0000mn\u0005\b\u0000\u0000no\u0003\u000e\u0007\u0000op\u0005"+
		"&\u0000\u0000p\r\u0001\u0000\u0000\u0000qr\u0005\u001b\u0000\u0000rs\u0005"+
		"\u0005\u0000\u0000sx\u0005\u0006\u0000\u0000tx\u0005\u001b\u0000\u0000"+
		"ux\u0005&\u0000\u0000vx\u0005\u001c\u0000\u0000wq\u0001\u0000\u0000\u0000"+
		"wt\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000"+
		"\u0000x\u000f\u0001\u0000\u0000\u0000y}\u0005\u0003\u0000\u0000z|\u0003"+
		"\u0010\b\u0000{z\u0001\u0000\u0000\u0000|\u007f\u0001\u0000\u0000\u0000"+
		"}{\u0001\u0000\u0000\u0000}~\u0001\u0000\u0000\u0000~\u0080\u0001\u0000"+
		"\u0000\u0000\u007f}\u0001\u0000\u0000\u0000\u0080\u00a3\u0005\u0004\u0000"+
		"\u0000\u0081\u0082\u0005\u001d\u0000\u0000\u0082\u0083\u0005\u0001\u0000"+
		"\u0000\u0083\u0084\u0003\u0012\t\u0000\u0084\u0085\u0005\u0002\u0000\u0000"+
		"\u0085\u0086\u0003\u0010\b\u0000\u0086\u0087\u0005\u001e\u0000\u0000\u0087"+
		"\u0088\u0003\u0010\b\u0000\u0088\u00a3\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005\u001f\u0000\u0000\u008a\u008b\u0005\u0001\u0000\u0000\u008b\u008c"+
		"\u0003\u0012\t\u0000\u008c\u008d\u0005\u0002\u0000\u0000\u008d\u008e\u0003"+
		"\u0010\b\u0000\u008e\u00a3\u0001\u0000\u0000\u0000\u008f\u0090\u0005 "+
		"\u0000\u0000\u0090\u0091\u0005\u0001\u0000\u0000\u0091\u0092\u0003\u0012"+
		"\t\u0000\u0092\u0093\u0005\u0002\u0000\u0000\u0093\u0094\u0005\u0007\u0000"+
		"\u0000\u0094\u00a3\u0001\u0000\u0000\u0000\u0095\u0096\u0005&\u0000\u0000"+
		"\u0096\u0097\u0005\u000b\u0000\u0000\u0097\u0098\u0003\u0012\t\u0000\u0098"+
		"\u0099\u0005\u0007\u0000\u0000\u0099\u00a3\u0001\u0000\u0000\u0000\u009a"+
		"\u009b\u0005&\u0000\u0000\u009b\u009c\u0005\u0005\u0000\u0000\u009c\u009d"+
		"\u0003\u0012\t\u0000\u009d\u009e\u0005\u0006\u0000\u0000\u009e\u009f\u0005"+
		"\u000b\u0000\u0000\u009f\u00a0\u0003\u0012\t\u0000\u00a0\u00a1\u0005\u0007"+
		"\u0000\u0000\u00a1\u00a3\u0001\u0000\u0000\u0000\u00a2y\u0001\u0000\u0000"+
		"\u0000\u00a2\u0081\u0001\u0000\u0000\u0000\u00a2\u0089\u0001\u0000\u0000"+
		"\u0000\u00a2\u008f\u0001\u0000\u0000\u0000\u00a2\u0095\u0001\u0000\u0000"+
		"\u0000\u00a2\u009a\u0001\u0000\u0000\u0000\u00a3\u0011\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0006\t\uffff\uffff\u0000\u00a5\u00bb\u0005\'\u0000"+
		"\u0000\u00a6\u00bb\u0005\"\u0000\u0000\u00a7\u00bb\u0005#\u0000\u0000"+
		"\u00a8\u00bb\u0005&\u0000\u0000\u00a9\u00bb\u0005$\u0000\u0000\u00aa\u00ab"+
		"\u0005%\u0000\u0000\u00ab\u00ac\u0005\u001b\u0000\u0000\u00ac\u00ad\u0005"+
		"\u0005\u0000\u0000\u00ad\u00ae\u0003\u0012\t\u0000\u00ae\u00af\u0005\u0006"+
		"\u0000\u0000\u00af\u00bb\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005%\u0000"+
		"\u0000\u00b1\u00b2\u0005&\u0000\u0000\u00b2\u00b3\u0005\u0001\u0000\u0000"+
		"\u00b3\u00bb\u0005\u0002\u0000\u0000\u00b4\u00b5\u0005\n\u0000\u0000\u00b5"+
		"\u00bb\u0003\u0012\t\u0002\u00b6\u00b7\u0005\u0001\u0000\u0000\u00b7\u00b8"+
		"\u0003\u0012\t\u0000\u00b8\u00b9\u0005\u0002\u0000\u0000\u00b9\u00bb\u0001"+
		"\u0000\u0000\u0000\u00ba\u00a4\u0001\u0000\u0000\u0000\u00ba\u00a6\u0001"+
		"\u0000\u0000\u0000\u00ba\u00a7\u0001\u0000\u0000\u0000\u00ba\u00a8\u0001"+
		"\u0000\u0000\u0000\u00ba\u00a9\u0001\u0000\u0000\u0000\u00ba\u00aa\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b0\u0001\u0000\u0000\u0000\u00ba\u00b4\u0001"+
		"\u0000\u0000\u0000\u00ba\u00b6\u0001\u0000\u0000\u0000\u00bb\u00d8\u0001"+
		"\u0000\u0000\u0000\u00bc\u00bd\n\r\u0000\u0000\u00bd\u00be\u0007\u0000"+
		"\u0000\u0000\u00be\u00d7\u0003\u0012\t\u000e\u00bf\u00c0\n\f\u0000\u0000"+
		"\u00c0\u00c1\u0005\u0005\u0000\u0000\u00c1\u00c2\u0003\u0012\t\u0000\u00c2"+
		"\u00c3\u0005\u0006\u0000\u0000\u00c3\u00d7\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\n\u000b\u0000\u0000\u00c5\u00c6\u0005\t\u0000\u0000\u00c6\u00d7"+
		"\u0005!\u0000\u0000\u00c7\u00c8\n\n\u0000\u0000\u00c8\u00c9\u0005\t\u0000"+
		"\u0000\u00c9\u00ca\u0005&\u0000\u0000\u00ca\u00d3\u0005\u0001\u0000\u0000"+
		"\u00cb\u00d0\u0003\u0012\t\u0000\u00cc\u00cd\u0005\b\u0000\u0000\u00cd"+
		"\u00cf\u0003\u0012\t\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d2"+
		"\u0001\u0000\u0000\u0000\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2\u00d0"+
		"\u0001\u0000\u0000\u0000\u00d3\u00cb\u0001\u0000\u0000\u0000\u00d3\u00d4"+
		"\u0001\u0000\u0000\u0000\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d7"+
		"\u0005\u0002\u0000\u0000\u00d6\u00bc\u0001\u0000\u0000\u0000\u00d6\u00bf"+
		"\u0001\u0000\u0000\u0000\u00d6\u00c4\u0001\u0000\u0000\u0000\u00d6\u00c7"+
		"\u0001\u0000\u0000\u0000\u00d7\u00da\u0001\u0000\u0000\u0000\u00d8\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9\u0013"+
		"\u0001\u0000\u0000\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00dc"+
		"\u0005&\u0000\u0000\u00dc\u0015\u0001\u0000\u0000\u0000\u0010\u001a5;"+
		"ATZgkw}\u00a2\u00ba\u00d0\u00d3\u00d6\u00d8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}