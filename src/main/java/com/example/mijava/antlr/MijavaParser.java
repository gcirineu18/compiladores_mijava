// Generated from com/example/mijava/antlr/Mijava.g4 by ANTLR 4.13.2
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
		RULE_methodDecl = 4, RULE_formalList = 5, RULE_type = 6, RULE_statement = 7, 
		RULE_expression = 8, RULE_identifier = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "mainClass", "classDecl", "varDecl", "methodDecl", "formalList", 
			"type", "statement", "expression", "identifier"
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
			setState(27);
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
			setState(29);
			match(CLASS);
			setState(30);
			match(ID);
			setState(31);
			match(LBRACE);
			setState(32);
			match(PUBLIC);
			setState(33);
			match(STATIC);
			setState(34);
			match(VOID);
			setState(35);
			match(MAIN);
			setState(36);
			match(LPAREN);
			setState(37);
			match(STRING);
			setState(38);
			match(LBRACK);
			setState(39);
			match(RBRACK);
			setState(40);
			match(ID);
			setState(41);
			match(RPAREN);
			setState(42);
			match(LBRACE);
			setState(43);
			statement();
			setState(44);
			match(RBRACE);
			setState(45);
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
			setState(47);
			match(CLASS);
			setState(48);
			match(ID);
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(49);
				match(EXTENDS);
				setState(50);
				match(ID);
				}
			}

			setState(53);
			match(LBRACE);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 275280560128L) != 0)) {
				{
				{
				setState(54);
				varDecl();
				}
				}
				setState(59);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PUBLIC) {
				{
				{
				setState(60);
				methodDecl();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
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
			setState(68);
			type();
			setState(69);
			match(ID);
			setState(70);
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
		public TerminalNode RPAREN() { return getToken(MijavaParser.RPAREN, 0); }
		public TerminalNode LBRACE() { return getToken(MijavaParser.LBRACE, 0); }
		public TerminalNode RETURN() { return getToken(MijavaParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(MijavaParser.SEMI, 0); }
		public TerminalNode RBRACE() { return getToken(MijavaParser.RBRACE, 0); }
		public List<FormalListContext> formalList() {
			return getRuleContexts(FormalListContext.class);
		}
		public FormalListContext formalList(int i) {
			return getRuleContext(FormalListContext.class,i);
		}
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
		public List<TerminalNode> COMMA() { return getTokens(MijavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MijavaParser.COMMA, i);
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
			setState(72);
			match(PUBLIC);
			setState(73);
			type();
			setState(74);
			match(ID);
			setState(75);
			match(LPAREN);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 275280560128L) != 0)) {
				{
				setState(76);
				formalList();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(77);
					match(COMMA);
					setState(78);
					formalList();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(86);
			match(RPAREN);
			setState(87);
			match(LBRACE);
			setState(91);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88);
					varDecl();
					}
					} 
				}
				setState(93);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281857228808L) != 0)) {
				{
				{
				setState(94);
				statement();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100);
			match(RETURN);
			setState(101);
			expression(0);
			setState(102);
			match(SEMI);
			setState(103);
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
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			type();
			setState(106);
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
		enterRule(_localctx, 12, RULE_type);
		try {
			setState(114);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new IntArrayTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				match(INT);
				setState(109);
				match(LBRACK);
				setState(110);
				match(RBRACK);
				}
				break;
			case 2:
				_localctx = new IntegerTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(INT);
				}
				break;
			case 3:
				_localctx = new IdentifierTypeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(112);
				match(ID);
				}
				break;
			case 4:
				_localctx = new BooleanTypeContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(113);
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
		enterRule(_localctx, 14, RULE_statement);
		int _la;
		try {
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new BlockStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(LBRACE);
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 281857228808L) != 0)) {
					{
					{
					setState(117);
					statement();
					}
					}
					setState(122);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(123);
				match(RBRACE);
				}
				break;
			case 2:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(IF);
				setState(125);
				match(LPAREN);
				setState(126);
				expression(0);
				setState(127);
				match(RPAREN);
				setState(128);
				statement();
				setState(129);
				match(ELSE);
				setState(130);
				statement();
				}
				break;
			case 3:
				_localctx = new WhileStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(132);
				match(WHILE);
				setState(133);
				match(LPAREN);
				setState(134);
				expression(0);
				setState(135);
				match(RPAREN);
				setState(136);
				statement();
				}
				break;
			case 4:
				_localctx = new PrintStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(SOUT);
				setState(139);
				match(LPAREN);
				setState(140);
				expression(0);
				setState(141);
				match(RPAREN);
				setState(142);
				match(SEMI);
				}
				break;
			case 5:
				_localctx = new AssignStatementContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(144);
				match(ID);
				setState(145);
				match(ASSIGN);
				setState(146);
				expression(0);
				setState(147);
				match(SEMI);
				}
				break;
			case 6:
				_localctx = new ArrayAssignStatementContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(149);
				match(ID);
				setState(150);
				match(LBRACK);
				setState(151);
				expression(0);
				setState(152);
				match(RBRACK);
				setState(153);
				match(ASSIGN);
				setState(154);
				expression(0);
				setState(155);
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
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new IntergerLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(160);
				match(INTEGER_LITERAL);
				}
				break;
			case 2:
				{
				_localctx = new TrueExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(161);
				match(TRUE);
				}
				break;
			case 3:
				{
				_localctx = new FalseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(162);
				match(FALSE);
				}
				break;
			case 4:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(163);
				match(ID);
				}
				break;
			case 5:
				{
				_localctx = new ThisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164);
				match(THIS);
				}
				break;
			case 6:
				{
				_localctx = new NewArrayExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(165);
				match(NEW);
				setState(166);
				match(INT);
				setState(167);
				match(LBRACK);
				setState(168);
				expression(0);
				setState(169);
				match(RBRACK);
				}
				break;
			case 7:
				{
				_localctx = new NewObjectExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(171);
				match(NEW);
				setState(172);
				match(ID);
				setState(173);
				match(LPAREN);
				setState(174);
				match(RPAREN);
				}
				break;
			case 8:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(175);
				match(NOT);
				setState(176);
				expression(2);
				}
				break;
			case 9:
				{
				_localctx = new InnerExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(177);
				match(LPAREN);
				setState(178);
				expression(0);
				setState(179);
				match(RPAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(209);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(183);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(184);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 389120L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(185);
						expression(14);
						}
						break;
					case 2:
						{
						_localctx = new ArrayAccessExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(186);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(187);
						match(LBRACK);
						setState(188);
						expression(0);
						setState(189);
						match(RBRACK);
						}
						break;
					case 3:
						{
						_localctx = new ArrayLengthExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(191);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(192);
						match(DOT);
						setState(193);
						match(LENGTH);
						}
						break;
					case 4:
						{
						_localctx = new MethodCallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(194);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(195);
						match(DOT);
						setState(196);
						match(ID);
						setState(197);
						match(LPAREN);
						setState(206);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1082331759618L) != 0)) {
							{
							setState(198);
							expression(0);
							setState(203);
							_errHandler.sync(this);
							_la = _input.LA(1);
							while (_la==COMMA) {
								{
								{
								setState(199);
								match(COMMA);
								setState(200);
								expression(0);
								}
								}
								setState(205);
								_errHandler.sync(this);
								_la = _input.LA(1);
							}
							}
						}

						setState(208);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(213);
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
		enterRule(_localctx, 18, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
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
		case 8:
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
		"\u0004\u0001*\u00d9\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0005\u0000\u0017\b"+
		"\u0000\n\u0000\f\u0000\u001a\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u00024\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0005\u00028\b\u0002\n\u0002\f\u0002;\t\u0002\u0001\u0002"+
		"\u0005\u0002>\b\u0002\n\u0002\f\u0002A\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004"+
		"P\b\u0004\n\u0004\f\u0004S\t\u0004\u0003\u0004U\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004Z\b\u0004\n\u0004\f\u0004]\t\u0004\u0001"+
		"\u0004\u0005\u0004`\b\u0004\n\u0004\f\u0004c\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006s\b\u0006\u0001\u0007\u0001\u0007\u0005\u0007w\b\u0007"+
		"\n\u0007\f\u0007z\t\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0003\u0007\u009e\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u00b6"+
		"\b\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u00ca\b\b\n\b\f\b\u00cd\t\b\u0003\b\u00cf\b\b\u0001\b\u0005"+
		"\b\u00d2\b\b\n\b\f\b\u00d5\t\b\u0001\t\u0001\t\u0001\t\u0000\u0001\u0010"+
		"\n\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0000\u0001\u0002\u0000"+
		"\f\u0010\u0012\u0012\u00ed\u0000\u0014\u0001\u0000\u0000\u0000\u0002\u001d"+
		"\u0001\u0000\u0000\u0000\u0004/\u0001\u0000\u0000\u0000\u0006D\u0001\u0000"+
		"\u0000\u0000\bH\u0001\u0000\u0000\u0000\ni\u0001\u0000\u0000\u0000\fr"+
		"\u0001\u0000\u0000\u0000\u000e\u009d\u0001\u0000\u0000\u0000\u0010\u00b5"+
		"\u0001\u0000\u0000\u0000\u0012\u00d6\u0001\u0000\u0000\u0000\u0014\u0018"+
		"\u0003\u0002\u0001\u0000\u0015\u0017\u0003\u0004\u0002\u0000\u0016\u0015"+
		"\u0001\u0000\u0000\u0000\u0017\u001a\u0001\u0000\u0000\u0000\u0018\u0016"+
		"\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000\u0000\u0000\u0019\u001b"+
		"\u0001\u0000\u0000\u0000\u001a\u0018\u0001\u0000\u0000\u0000\u001b\u001c"+
		"\u0005\u0000\u0000\u0001\u001c\u0001\u0001\u0000\u0000\u0000\u001d\u001e"+
		"\u0005\u0014\u0000\u0000\u001e\u001f\u0005&\u0000\u0000\u001f \u0005\u0003"+
		"\u0000\u0000 !\u0005\u0016\u0000\u0000!\"\u0005\u0017\u0000\u0000\"#\u0005"+
		"\u0018\u0000\u0000#$\u0005\u0013\u0000\u0000$%\u0005\u0001\u0000\u0000"+
		"%&\u0005\u001a\u0000\u0000&\'\u0005\u0005\u0000\u0000\'(\u0005\u0006\u0000"+
		"\u0000()\u0005&\u0000\u0000)*\u0005\u0002\u0000\u0000*+\u0005\u0003\u0000"+
		"\u0000+,\u0003\u000e\u0007\u0000,-\u0005\u0004\u0000\u0000-.\u0005\u0004"+
		"\u0000\u0000.\u0003\u0001\u0000\u0000\u0000/0\u0005\u0014\u0000\u0000"+
		"03\u0005&\u0000\u000012\u0005\u0015\u0000\u000024\u0005&\u0000\u00003"+
		"1\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000045\u0001\u0000\u0000"+
		"\u000059\u0005\u0003\u0000\u000068\u0003\u0006\u0003\u000076\u0001\u0000"+
		"\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:?\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<>\u0003\b\u0004\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000"+
		"?=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@B\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000BC\u0005\u0004\u0000\u0000C\u0005\u0001"+
		"\u0000\u0000\u0000DE\u0003\f\u0006\u0000EF\u0005&\u0000\u0000FG\u0005"+
		"\u0007\u0000\u0000G\u0007\u0001\u0000\u0000\u0000HI\u0005\u0016\u0000"+
		"\u0000IJ\u0003\f\u0006\u0000JK\u0005&\u0000\u0000KT\u0005\u0001\u0000"+
		"\u0000LQ\u0003\n\u0005\u0000MN\u0005\b\u0000\u0000NP\u0003\n\u0005\u0000"+
		"OM\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TL\u0001\u0000\u0000\u0000TU\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000VW\u0005\u0002\u0000\u0000W[\u0005\u0003\u0000\u0000"+
		"XZ\u0003\u0006\u0003\u0000YX\u0001\u0000\u0000\u0000Z]\u0001\u0000\u0000"+
		"\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\a\u0001\u0000"+
		"\u0000\u0000][\u0001\u0000\u0000\u0000^`\u0003\u000e\u0007\u0000_^\u0001"+
		"\u0000\u0000\u0000`c\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000"+
		"ab\u0001\u0000\u0000\u0000bd\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000"+
		"\u0000de\u0005\u0019\u0000\u0000ef\u0003\u0010\b\u0000fg\u0005\u0007\u0000"+
		"\u0000gh\u0005\u0004\u0000\u0000h\t\u0001\u0000\u0000\u0000ij\u0003\f"+
		"\u0006\u0000jk\u0005&\u0000\u0000k\u000b\u0001\u0000\u0000\u0000lm\u0005"+
		"\u001b\u0000\u0000mn\u0005\u0005\u0000\u0000ns\u0005\u0006\u0000\u0000"+
		"os\u0005\u001b\u0000\u0000ps\u0005&\u0000\u0000qs\u0005\u001c\u0000\u0000"+
		"rl\u0001\u0000\u0000\u0000ro\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000"+
		"\u0000rq\u0001\u0000\u0000\u0000s\r\u0001\u0000\u0000\u0000tx\u0005\u0003"+
		"\u0000\u0000uw\u0003\u000e\u0007\u0000vu\u0001\u0000\u0000\u0000wz\u0001"+
		"\u0000\u0000\u0000xv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{\u009e\u0005\u0004"+
		"\u0000\u0000|}\u0005\u001d\u0000\u0000}~\u0005\u0001\u0000\u0000~\u007f"+
		"\u0003\u0010\b\u0000\u007f\u0080\u0005\u0002\u0000\u0000\u0080\u0081\u0003"+
		"\u000e\u0007\u0000\u0081\u0082\u0005\u001e\u0000\u0000\u0082\u0083\u0003"+
		"\u000e\u0007\u0000\u0083\u009e\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		"\u001f\u0000\u0000\u0085\u0086\u0005\u0001\u0000\u0000\u0086\u0087\u0003"+
		"\u0010\b\u0000\u0087\u0088\u0005\u0002\u0000\u0000\u0088\u0089\u0003\u000e"+
		"\u0007\u0000\u0089\u009e\u0001\u0000\u0000\u0000\u008a\u008b\u0005 \u0000"+
		"\u0000\u008b\u008c\u0005\u0001\u0000\u0000\u008c\u008d\u0003\u0010\b\u0000"+
		"\u008d\u008e\u0005\u0002\u0000\u0000\u008e\u008f\u0005\u0007\u0000\u0000"+
		"\u008f\u009e\u0001\u0000\u0000\u0000\u0090\u0091\u0005&\u0000\u0000\u0091"+
		"\u0092\u0005\u000b\u0000\u0000\u0092\u0093\u0003\u0010\b\u0000\u0093\u0094"+
		"\u0005\u0007\u0000\u0000\u0094\u009e\u0001\u0000\u0000\u0000\u0095\u0096"+
		"\u0005&\u0000\u0000\u0096\u0097\u0005\u0005\u0000\u0000\u0097\u0098\u0003"+
		"\u0010\b\u0000\u0098\u0099\u0005\u0006\u0000\u0000\u0099\u009a\u0005\u000b"+
		"\u0000\u0000\u009a\u009b\u0003\u0010\b\u0000\u009b\u009c\u0005\u0007\u0000"+
		"\u0000\u009c\u009e\u0001\u0000\u0000\u0000\u009dt\u0001\u0000\u0000\u0000"+
		"\u009d|\u0001\u0000\u0000\u0000\u009d\u0084\u0001\u0000\u0000\u0000\u009d"+
		"\u008a\u0001\u0000\u0000\u0000\u009d\u0090\u0001\u0000\u0000\u0000\u009d"+
		"\u0095\u0001\u0000\u0000\u0000\u009e\u000f\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0006\b\uffff\uffff\u0000\u00a0\u00b6\u0005\'\u0000\u0000\u00a1"+
		"\u00b6\u0005\"\u0000\u0000\u00a2\u00b6\u0005#\u0000\u0000\u00a3\u00b6"+
		"\u0005&\u0000\u0000\u00a4\u00b6\u0005$\u0000\u0000\u00a5\u00a6\u0005%"+
		"\u0000\u0000\u00a6\u00a7\u0005\u001b\u0000\u0000\u00a7\u00a8\u0005\u0005"+
		"\u0000\u0000\u00a8\u00a9\u0003\u0010\b\u0000\u00a9\u00aa\u0005\u0006\u0000"+
		"\u0000\u00aa\u00b6\u0001\u0000\u0000\u0000\u00ab\u00ac\u0005%\u0000\u0000"+
		"\u00ac\u00ad\u0005&\u0000\u0000\u00ad\u00ae\u0005\u0001\u0000\u0000\u00ae"+
		"\u00b6\u0005\u0002\u0000\u0000\u00af\u00b0\u0005\n\u0000\u0000\u00b0\u00b6"+
		"\u0003\u0010\b\u0002\u00b1\u00b2\u0005\u0001\u0000\u0000\u00b2\u00b3\u0003"+
		"\u0010\b\u0000\u00b3\u00b4\u0005\u0002\u0000\u0000\u00b4\u00b6\u0001\u0000"+
		"\u0000\u0000\u00b5\u009f\u0001\u0000\u0000\u0000\u00b5\u00a1\u0001\u0000"+
		"\u0000\u0000\u00b5\u00a2\u0001\u0000\u0000\u0000\u00b5\u00a3\u0001\u0000"+
		"\u0000\u0000\u00b5\u00a4\u0001\u0000\u0000\u0000\u00b5\u00a5\u0001\u0000"+
		"\u0000\u0000\u00b5\u00ab\u0001\u0000\u0000\u0000\u00b5\u00af\u0001\u0000"+
		"\u0000\u0000\u00b5\u00b1\u0001\u0000\u0000\u0000\u00b6\u00d3\u0001\u0000"+
		"\u0000\u0000\u00b7\u00b8\n\r\u0000\u0000\u00b8\u00b9\u0007\u0000\u0000"+
		"\u0000\u00b9\u00d2\u0003\u0010\b\u000e\u00ba\u00bb\n\f\u0000\u0000\u00bb"+
		"\u00bc\u0005\u0005\u0000\u0000\u00bc\u00bd\u0003\u0010\b\u0000\u00bd\u00be"+
		"\u0005\u0006\u0000\u0000\u00be\u00d2\u0001\u0000\u0000\u0000\u00bf\u00c0"+
		"\n\u000b\u0000\u0000\u00c0\u00c1\u0005\t\u0000\u0000\u00c1\u00d2\u0005"+
		"!\u0000\u0000\u00c2\u00c3\n\n\u0000\u0000\u00c3\u00c4\u0005\t\u0000\u0000"+
		"\u00c4\u00c5\u0005&\u0000\u0000\u00c5\u00ce\u0005\u0001\u0000\u0000\u00c6"+
		"\u00cb\u0003\u0010\b\u0000\u00c7\u00c8\u0005\b\u0000\u0000\u00c8\u00ca"+
		"\u0003\u0010\b\u0000\u00c9\u00c7\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cc\u00cf\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001"+
		"\u0000\u0000\u0000\u00ce\u00c6\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d2\u0005"+
		"\u0002\u0000\u0000\u00d1\u00b7\u0001\u0000\u0000\u0000\u00d1\u00ba\u0001"+
		"\u0000\u0000\u0000\u00d1\u00bf\u0001\u0000\u0000\u0000\u00d1\u00c2\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u0011\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d7\u0005"+
		"&\u0000\u0000\u00d7\u0013\u0001\u0000\u0000\u0000\u0010\u001839?QT[ar"+
		"x\u009d\u00b5\u00cb\u00ce\u00d1\u00d3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}