package it.sevenbits.factory;

import it.sevenbits.lexer.ILexer;
import it.sevenbits.read.IReader;

/**
 *
 */
public interface ILexerFactory {
    /**
     *
     * @param reader reader
     * @return ILexer
     */
    ILexer createLexer(IReader reader);
}
