package it.sevenbits.homework.formatter.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.tokens.IToken;
import it.sevenbits.homework.write.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * command for formatter write word
 */
public class WriteWord implements ICommand {
    private FormatterContainer container;
    /**
     * logger
     */
    final static Logger logger = LoggerFactory.getLogger(WriteWord.class);

    /**
     *
     * @param container contains information for command
     */
    public WriteWord(final FormatterContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        IToken token = container.getToken();
        IWriter writer = container.getWriter();
        try {
            for (int i = 0; i < token.getLexeme().length(); i++) {
                writer.write(token.getLexeme().charAt(i));
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
