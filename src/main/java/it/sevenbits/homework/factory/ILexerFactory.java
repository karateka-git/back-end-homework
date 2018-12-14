package it.sevenbits.homework.factory;

import it.sevenbits.homework.lexer.ILexer;
import it.sevenbits.homework.read.IReader;

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
