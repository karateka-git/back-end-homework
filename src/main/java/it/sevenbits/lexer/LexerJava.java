package it.sevenbits.lexer;

import it.sevenbits.read.IReader;
import it.sevenbits.tokens.IToken;
import it.sevenbits.tokens.Token;

import java.io.IOException;

public class LexerJava implements ILexer {
    private IReader reader;
    private char symbol = ' ';
    public LexerJava(final IReader reader) {
        this.reader = reader;
    }

    private char[] scanning(final char symbol) {
        char[] mathSymbol = {'+', '-', '/', '*', '=', '%', '>', '<'};
        char[] separatingSymbol = {')', '(', '{', '}'};
        char[] literalSymbol = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numeric = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        if (contains(mathSymbol, symbol)) {
            return mathSymbol;
        } else if (contains(separatingSymbol, symbol)) {
            return separatingSymbol;
        } else if (contains(literalSymbol, symbol)) {
            return literalSymbol;
        } else if (contains(numeric, symbol)) {
            return numeric;
        }
        return null;
    }

    private boolean contains(final char[] array, final char v) {
        if (array == null) {
            throw new NullPointerException("array is null");
        }
        for (final char e : array) {
            if (e == v) {
                return true;
            }
        }
        return false;
    }


    @Override
    public IToken readToken() {
        Token token = new Token();
        char[] sequence;
        if (symbol == ' ') {
            symbol = reader.read();
            sequence = scanning(symbol);
            token.append(symbol);
        } else {
            sequence = scanning(symbol);
            token.append(symbol);
        }
        while (reader.hasNext()) {
            symbol = reader.read();
            if (contains(sequence, symbol)) {
                token.append(symbol);
            } else {
                return token;
            }
        }
        return token;
    }

    @Override
    public boolean hasMoreTokens() {
        return reader.hasNext();
    }
}
