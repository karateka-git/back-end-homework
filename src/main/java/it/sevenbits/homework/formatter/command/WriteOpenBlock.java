package it.sevenbits.homework.formatter.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.write.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WriteOpenBlock implements ICommand {
    private FormatterContainer container;
    final static Logger logger = LoggerFactory.getLogger(WriteSpaceAndWord.class);

    public WriteOpenBlock(final FormatterContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        container.setIndentLevel(1 + container.getIndentLevel());
        WriteSpaceAndWord writeSpaceAndWord = new WriteSpaceAndWord(container);

        writeSpaceAndWord.execute();
    }
}
