package it.sevenbits.homework.lexer;

import it.sevenbits.homework.buffer.IBuffer;
import it.sevenbits.homework.buffer.StringBuilderBuffer;
import it.sevenbits.homework.lexer.container.LexerContainer;
import it.sevenbits.homework.lexer.command.LexerCommand;
import it.sevenbits.homework.read.IReader;
import it.sevenbits.homework.state.State;
import it.sevenbits.homework.tokens.IToken;
import it.sevenbits.homework.tokens.Token;

import java.io.IOException;

public class LexerJava implements ILexer {
    private IReader reader;
    private boolean hasMore = false;
    private char preSymbol = ' ';
    public LexerJava(final IReader reader) {
        this.reader = reader;
    }

    @Override
    public IToken readToken() throws IOException {
        char symbol;
        LexerStateMap lexerStateMap = new LexerStateMap();
        State state = lexerStateMap.getStartState();
        LexerContainer container = new LexerContainer();
        IBuffer buffer = new StringBuilderBuffer();
        container.setBuffer(buffer);
        LexerCommand lexerCommand = new LexerCommand(container);
        if (preSymbol != ' ') {
            container.setCurrentState(state);
            container.setSymbol(preSymbol);
            lexerCommand.runningCommand();
            state = lexerStateMap.getNextState(state, preSymbol);
        }

        while (reader.hasNext() && !state.toString().equals("finalState")) {
            symbol = reader.read();
            container.setCurrentState(state);
            container.setSymbol(symbol);
            lexerCommand.runningCommand();
            state = lexerStateMap.getNextState(state, symbol);
            preSymbol = symbol;
            System.out.println(state.toString());
        }

        System.out.println(buffer.toString());
        Token token = new Token(lexerStateMap.getNextState(lexerStateMap.getStartState(),
                buffer.toString().charAt(0)).toString());
        for (int i = 0; i < buffer.toString().length(); i++) {
            token.append(buffer.toString().charAt(i));
        }
        return token;
    }

    @Override
    public boolean hasMoreTokens() {
        return !hasMore;
    }
}
