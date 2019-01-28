package it.sevenbits.homework.formatter.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.write.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WriteTransferIndentAndWord implements ICommand {
    private FormatterContainer container;
    final static Logger logger = LoggerFactory.getLogger(WriteTransferIndentAndWord.class);

    public WriteTransferIndentAndWord(final FormatterContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        WriteWord writeWord = new WriteWord(container);
        WriteIndent writeIndent = new WriteIndent(container);

        IWriter writer = container.getWriter();
        try {
            writer.write('\n');
            writeIndent.execute();
            writeWord.execute();
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
