package it.sevenbits.homework.lexer;


import it.sevenbits.homework.tokens.IToken;

import java.io.IOException;

/**
 *
 */
public interface ILexer {
    /**
     *
     * @return IToken
     * @throws IOException exception
     */
    IToken readToken() throws IOException;

    /**
     *
     * @return boolean
     */
    boolean hasMoreTokens();
}
