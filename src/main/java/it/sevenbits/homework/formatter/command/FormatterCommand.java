package it.sevenbits.homework.formatter.command;

import it.sevenbits.homework.CommandInvoker;
import it.sevenbits.homework.ICommand;
import it.sevenbits.homework.formatter.container.FormatterContainer;
import it.sevenbits.homework.pair.Pair;

import java.util.HashMap;
import java.util.Map;

public class FormatterCommand {

    private final Map<Pair<String, String>, ICommand> states;
    private FormatterContainer container;

    public FormatterCommand(final FormatterContainer container) {
        states = new HashMap<>();
        this.container = container;
        states.put(new Pair<>("startState", "literal"), new WriteWord(container));
        states.put(new Pair<>("startState", "numeric"), new WriteWord(container));
        states.put(new Pair<>("openBlockCode", "numeric"), new WriteTransferIndentAndWord(container));
        states.put(new Pair<>("space", "numeric"), new WriteWord(container));
        states.put(new Pair<>("openBlockCode", "literal"), new WriteTransferIndentAndWord(container));
        states.put(new Pair<>("space", "literal"), new WriteWord(container));
        states.put(new Pair<>("lineEnd", "literal"), new WriteTransferIndentAndWord(container));
        states.put(new Pair<>("lineEnd", "numeric"), new WriteTransferIndentAndWord(container));
        states.put(new Pair<>("closeBlockCode", "numeric"), new WriteTransferIndentAndWord(container));
        states.put(new Pair<>("closeBlockCode", "literal"), new WriteTransferIndentAndWord(container));
        states.put(new Pair<>("word", "literal"), new WriteSpaceAndWord(container));
        states.put(new Pair<>("word", "numeric"), new WriteSpaceAndWord(container));

        states.put(new Pair<>("word", "openBlockCode"), new WriteOpenBlock(container));
        states.put(new Pair<>("space", "openBlockCode"), new WriteOpenBlock(container));
        states.put(new Pair<>("openBlockCode", "openBlockCode"), new WriteOpenBlock(container));
        states.put(new Pair<>("closeBlockCode", "openBlockCode"), new WriteTransferIndentAndWord(container));

        states.put(new Pair<>("word", "lineEnd"), new WriteWord(container));
        states.put(new Pair<>("space", "lineEnd"), new WriteWord(container));

        states.put(new Pair<>("lineEnd", "closeBlockCode"), new WriteCloseBlock(container));
        states.put(new Pair<>("closeBlockCode", "closeBlockCode"), new WriteCloseBlock(container));
        states.put(new Pair<>("word", "closeBlockCode"), new WriteCloseBlock(container));
        states.put(new Pair<>("space", "closeBlockCode"), new WriteCloseBlock(container));
        states.put(new Pair<>("openBlockCode", "closeBlockCode"), new WriteCloseBlock(container));

        states.put(new Pair<>("startState", "singleComment"), new WriteWord(container));
        states.put(new Pair<>("closeBlockCode", "singleComment"), new WriteWord(container));
        states.put(new Pair<>("openBlockCode", "singleComment"), new WriteWord(container));
        states.put(new Pair<>("word", "singleComment"), new WriteWord(container));
        states.put(new Pair<>("space", "singleComment"), new WriteWord(container));
        states.put(new Pair<>("lineEnd", "singleComment"), new WriteWord(container));
        states.put(new Pair<>("singleComment", "literal"), new WriteWord(container));
        states.put(new Pair<>("singleComment", "numeric"), new WriteWord(container));
    }

    public void runningCommand() {
        CommandInvoker commandInvoker = new CommandInvoker();
        if (!container.getToken().getName().equals("space")) {
            commandInvoker.submit(states.get(new Pair<>(container.getState().toString(),
                    container.getToken().getName())));
        }

    }
}
