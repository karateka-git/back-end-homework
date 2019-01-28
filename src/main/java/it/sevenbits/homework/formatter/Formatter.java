package it.sevenbits.homework.formatter;

import it.sevenbits.homework.factory.ILexerFactory;
import it.sevenbits.homework.factory.LexerFactoryJava;
import it.sevenbits.homework.formatter.command.FormatterCommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.read.IReader;
import it.sevenbits.homework.state.State;
import it.sevenbits.homework.tokens.IToken;
import it.sevenbits.homework.write.IWriter;
import it.sevenbits.homework.lexer.ILexer;

import java.io.IOException;

/**
 * Text formatting class
 */
public class Formatter {
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
        FormatterStateMap formatterStateMap = new FormatterStateMap();
        FormatterContainer container = new FormatterContainer();
        container.setIndentLevel(0);
        State state = formatterStateMap.getStartState();
        container.setWriter(writer);
        FormatterCommand formatterCommand = new FormatterCommand(container);
        ILexer lexer = lexerFactory.createLexer(reader);
        while (lexer.hasMoreTokens() && !state.toString().equals("finalState")) {
            IToken token = lexer.readToken();
            container.setToken(token);
            container.setCurrentState(state);
            formatterCommand.runningCommand();
            state = formatterStateMap.getNextState(state, token.getName());
        }
    }
}
