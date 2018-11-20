package it.sevenbits.lexer;


import it.sevenbits.tokens.IToken;

import java.io.IOException;

public interface ILexer {
    IToken readToken() throws IOException;
    boolean hasMoreTokens() throws IOException;
}
