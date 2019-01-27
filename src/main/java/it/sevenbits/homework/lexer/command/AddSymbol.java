package it.sevenbits.homework.lexer.command;

import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.lexer.container.LexerContainer;

public class AddSymbol implements ICommand {
    private LexerContainer container;

    public AddSymbol(final LexerContainer container) {
        this.container = container;
    }

    @Override
    public void execute() {
        container.getBuffer().addChar(container.getSymbol());
    }
}
