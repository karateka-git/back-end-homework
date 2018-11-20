package it.sevenbits.lexer;


import it.sevenbits.tokens.IToken;

public interface ILexer {
    IToken readToken();
    boolean hasMoreTokens();
}
