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
public class WriteIndent implements ICommand {
    private FormatterContainer container;
    /**
     * logger
     */
    final static Logger logger = LoggerFactory.getLogger(WriteCloseBlock.class);

    /**
     *
     * @param container contains information for command
     */
    public WriteIndent(final FormatterContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        IWriter writer = container.getWriter();
        int indent = container.getStandardSpace() * container.getIndentLevel();
        try {
            for (int i = 0; i < indent; i++) {
                writer.write(' ');
            }
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
