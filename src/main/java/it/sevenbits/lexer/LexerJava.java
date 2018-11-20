package it.sevenbits.lexer;

import it.sevenbits.read.IReader;
import it.sevenbits.tokens.IToken;
import it.sevenbits.tokens.Token;

import java.io.IOException;

public class LexerJava implements ILexer {
    private IReader reader;
    private char symbol = ' ';
    private boolean hasMore = false;
    public LexerJava(final IReader reader) {
        this.reader = reader;
    }

    private boolean contains(final char[] array, final char v) {
        if (array == null) {
            throw new NullPointerException("in the sending string " +
                    "there is a symbol not contained in more than one sequence");
        }
        for (final char e : array) {
            if (e == v) {
                return true;
            }
        }
        return false;
    }

    private char[] scanning(final char symbol, final IToken token) {
        char[] mathSymbol = {'+', '-', '/', '*', '=', '%', '>', '<'};
        char[] separatingSymbol = {')', '(', '{', '}'};
        char[] literalSymbol = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] numeric = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        char[] endLine = {';'};
        char[] space = {' ', '\n'};
        if (contains(mathSymbol, symbol)) {
            token.setName("math");
            return mathSymbol;
        } else if (contains(separatingSymbol, symbol)) {
            token.setName("separating");
            return separatingSymbol;
        } else if (contains(literalSymbol, symbol)) {
            token.setName("literal");
            return literalSymbol;
        } else if (contains(numeric, symbol)) {
            token.setName("numeric");
            return numeric;
        } else if (contains(endLine, symbol)) {
            token.setName("endLine");
            return endLine;
        } else if (contains(space, symbol)) {
            token.setName("space");
            return space;
        }
        return null;
    }

    @Override
    public IToken readToken() throws IOException {
        Token token = new Token();
        char[] sequence;
        if (symbol == ' ') {
            symbol = reader.read();
            sequence = scanning(symbol, token);
            token.append(symbol);
        } else {
            sequence = scanning(symbol, token);
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
        hasMore = true;
        return token;
    }

    @Override
    public boolean hasMoreTokens() throws IOException {
        return !hasMore;
    }
}
