package it.sevenbits.homework.factory;

import it.sevenbits.homework.lexer.ILexer;
import it.sevenbits.homework.read.IReader;

/**
 * interface for create lexer factory
 */
public interface ILexerFactory {
    /**
     *
     * @param reader reader
     * @return ILexer
     */
    ILexer createLexer(IReader reader);
}
