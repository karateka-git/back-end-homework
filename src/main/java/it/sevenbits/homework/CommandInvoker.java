package it.sevenbits.homework;

/**
 * runs commands
 */
public class CommandInvoker {
    /**
     *
     * @param command - what command to run
     */

    public void submit(final ICommand command) {
        if (command != null) {
            command.execute();
        }
    }
}
