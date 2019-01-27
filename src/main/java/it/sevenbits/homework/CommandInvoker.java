package it.sevenbits.homework;

public class CommandInvoker {
    public void submit(final ICommand command) {
        if (command != null) {
            command.execute();
        }
    }
}
