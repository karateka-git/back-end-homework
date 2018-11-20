package it.sevenbits;

import it.sevenbits.factory.ILexerFactory;
import it.sevenbits.factory.LexerFactoryJava;
import it.sevenbits.lexer.ILexer;
import it.sevenbits.read.IReader;
import it.sevenbits.tokens.IToken;
import it.sevenbits.write.IWriter;

import java.io.IOException;

/**
 * Text formatting class
 */
public class Formatter {
    private int countSpace = 0;
    private int countSpaceBetweenSymbol = 0;
    private final int STANDART_SPACE = 4;
    private final ILexerFactory lexerFactory;

    /**
     * Class constructor Formatter
     */
    public Formatter() {
        lexerFactory = new LexerFactoryJava();
    }

    /**
     *
     * @param reader implementation of the interface for character reading
     * @param writer implementation of the interface for character writing
     * @throws IOException read and write exception
     */
    public void format(final IReader reader, final IWriter writer) throws IOException {
        ILexer lexer = lexerFactory.createLexer(reader);
        while (lexer.hasMoreTokens()) {
            IToken token = lexer.readToken();
            write(writer, token);
        }
    }

    private void write(final IWriter writer, final IToken token) throws IOException {
        String string = token.getLexeme();
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (symbol == ';') {
                insertSpecSymbol(writer, symbol);
                setCountSpaceBetweenSymbol(1);  // 1 - mark ';', see "insertSymbol"
            } else if (symbol == '{') {
                insertSpecSymbol(writer, symbol);
                transfer(writer, getStandartSpace());
            } else if (symbol == '}') {
                transfer(writer, -getStandartSpace());
                insertSpecSymbol(writer, symbol);
            } else {
                insertSymbol(writer, symbol);
            }
        }
    }

    private void transfer(final IWriter writer, final int space) throws IOException {
        setCountSpace(getCountSpace() + space);
        setCountSpaceBetweenSymbol(getCountSpace());
        writer.write('\n');
    }

    private void insertSpecSymbol(final IWriter writer, final char symbol) throws IOException {
        for (int i = 0; i < getCountSpaceBetweenSymbol(); ++i) {
            writer.write(' ');
        }
        writer.write(symbol);
    }

    private void insertSymbol(final IWriter writer, final char symbol) throws IOException {
        if (symbol == ' ' || symbol == '\n') {
            return;
        } else if (getCountSpaceBetweenSymbol() == 1) {  // if after ';' symbol stands, then transfer
            transfer(writer, 0);
        }
        for (int i = 0; i < getCountSpaceBetweenSymbol(); ++i) {
            writer.write(' ');
        }
        writer.write(symbol);
        setCountSpaceBetweenSymbol(0);
    }

    private int getStandartSpace() {
        return STANDART_SPACE;
    }

    private int getCountSpace() {
        return countSpace;
    }

    private void setCountSpace(final int countSpace) {
        this.countSpace = countSpace;
    }

    private int getCountSpaceBetweenSymbol() {
        return countSpaceBetweenSymbol;
    }

    private void setCountSpaceBetweenSymbol(final int countSpaceBetweenSymbol) {
        this.countSpaceBetweenSymbol = countSpaceBetweenSymbol;
    }
}
