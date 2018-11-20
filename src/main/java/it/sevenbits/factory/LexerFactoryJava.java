package it.sevenbits.factory;

import it.sevenbits.lexer.ILexer;
import it.sevenbits.lexer.LexerJava;
import it.sevenbits.read.IReader;


public class LexerFactoryJava implements ILexerFactory {
    @Override
    public ILexer createLexer(final IReader reader) {
        return new LexerJava(reader);
    }
}
