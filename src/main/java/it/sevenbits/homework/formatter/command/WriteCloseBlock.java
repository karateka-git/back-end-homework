package it.sevenbits.homework.formatter.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.write.IWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WriteCloseBlock implements ICommand {
    private FormatterContainer container;

    final static Logger logger = LoggerFactory.getLogger(WriteCloseBlock.class);

    public WriteCloseBlock(final FormatterContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        IWriter writer = container.getWriter();
        container.setIndentLevel(container.getIndentLevel() - 1);
        WriteTransferIndentAndWord writeTransferIndentAndWord = new WriteTransferIndentAndWord(container);

        writeTransferIndentAndWord.execute();

    }
}
