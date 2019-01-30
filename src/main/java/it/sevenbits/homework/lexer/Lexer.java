package it.sevenbits.homework.lexer;

import it.sevenbits.homework.buffer.IBuffer;
import it.sevenbits.homework.buffer.StringBuilderBuffer;
import it.sevenbits.homework.lexer.container.LexerContainer;
import it.sevenbits.homework.lexer.command.LexerCommand;
import it.sevenbits.homework.read.IReader;
import it.sevenbits.homework.state.State;
import it.sevenbits.homework.tokens.IToken;
import it.sevenbits.homework.tokens.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 */
public class Lexer implements ILexer {
    private IReader reader;
    private boolean hasMore = false;
    private char preSymbol = ' ';
    /**
     * logger variable
     */
    private final static Logger logger = LoggerFactory.getLogger(Lexer.class);

    /**
     *
     * @param reader - character read stream
     */
    public Lexer(final IReader reader) {
        this.reader = reader;
    }

    @Override
    public IToken readToken() throws IOException {
        char symbol;
        LexerStateMap lexerStateMap = new LexerStateMap();
        State state = lexerStateMap.getStartState();
        State preState = state;
        LexerContainer container = new LexerContainer();
        IBuffer buffer = new StringBuilderBuffer();
        container.setBuffer(buffer);
        LexerCommand lexerCommand = new LexerCommand(container);
        if (preSymbol != ' ') {
            container.setCurrentState(state);
            container.setSymbol(preSymbol);
            lexerCommand.runningCommand();
            state = lexerStateMap.getNextState(state, preSymbol);
            preState = state;
        }

        while (reader.hasNext() && !state.toString().equals("finalState")) {
            symbol = reader.read();
            container.setCurrentState(state);
            container.setSymbol(symbol);
            lexerCommand.runningCommand();
            preState = state;
            state = lexerStateMap.getNextState(state, symbol);
            preSymbol = symbol;
        }

        Token token;
        if (!state.toString().equals("finalState")) {
            hasMore = true;
            token = new Token(state.toString());
        } else {
            token = new Token(preState.toString());
        }

        if (preState.toString().equals(lexerStateMap.getStartState().toString())
                && state.toString().equals(lexerStateMap.getFinalState().toString())) {
            logger.warn(String.format("State for \"%s\" not defined", preSymbol));
        }

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
