package it.sevenbits.factory;

import it.sevenbits.lexer.ILexer;
import it.sevenbits.read.IReader;


public interface ILexerFactory {
    ILexer createLexer(IReader reader);
}
