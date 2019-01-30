package it.sevenbits.homework.formatter.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.write.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * command for formatter
 */
public class WriteSpaceAndWord implements ICommand {
    private FormatterContainer container;

    /**
     * logger
     */
    final static Logger logger = LoggerFactory.getLogger(WriteSpaceAndWord.class);

    /**
     *
     * @param container contains information for command
     */
    public WriteSpaceAndWord(final FormatterContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        IWriter writer = container.getWriter();
        WriteWord writeWord = new WriteWord(container);
        try {
            writer.write(' ');
            writeWord.execute();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
