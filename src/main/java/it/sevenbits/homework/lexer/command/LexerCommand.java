package it.sevenbits.homework.lexer.command;

import it.sevenbits.homework.CommandInvoker;
import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.lexer.container.LexerContainer;
import it.sevenbits.homework.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class LexerCommand {
    private final Map<Pair<String, Character>, ICommand> states;
    private final LexerContainer container;

    public LexerCommand(final LexerContainer container) {
        this.container = container;
        states = new HashMap<>();
        states.put(new Pair<>("startState", ';'), new AddSymbol(container));
        states.put(new Pair<>("startState", '{'), new AddSymbol(container));
        states.put(new Pair<>("startState", '}'), new AddSymbol(container));
        states.put(new Pair<>("startState", ' '), new AddSymbol(container));
        states.put(new Pair<>("startState", '\n'), new AddSymbol(container));
        states.put(new Pair<>("startState", 'a'), new AddSymbol(container));
        states.put(new Pair<>("startState", '1'), new AddSymbol(container));

        states.put(new Pair<>("literal", 'a'), new AddSymbol(container));
        states.put(new Pair<>("numeric", '1'), new AddSymbol(container));
    }

    public void runningCommand() {
        CommandInvoker commandInvoker = new CommandInvoker();
        char copysignal;
        copysignal = Character.isDigit(container.getSymbol()) ? '1' :
                Character.isLetter(container.getSymbol()) ? 'a' : container.getSymbol();
        commandInvoker.submit(states.get(new Pair<>(container.getCurrentState().toString(),
                copysignal)));
    }
}
