package it.sevenbits.homework.formatter.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.write.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WriteAndTransfer implements ICommand {
    private FormatterContainer container;

    final static Logger logger = LoggerFactory.getLogger(WriteAndTransfer.class);

    public WriteAndTransfer(final FormatterContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        IWriter writer = container.getWriter();
        WriteWord writeWord = new WriteWord(container);
        try {
            writeWord.execute();
            writer.write('\n');

        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
