package it.sevenbits.homework.factory;

import it.sevenbits.homework.read.IReader;
import it.sevenbits.homework.lexer.ILexer;
import it.sevenbits.homework.lexer.LexerJava;


public class LexerFactoryJava implements ILexerFactory {
    @Override
    public ILexer createLexer(final IReader reader) {
        return new LexerJava(reader);
    }
}
