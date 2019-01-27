package it.sevenbits.homework.lexer.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.lexer.container.LexerContainer;

public class ClearBuffer implements ICommand {
    private LexerContainer container;

    public ClearBuffer(final LexerContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        container.getBuffer().clear();
    }
}
