package it.sevenbits.homework.lexer.container;

import it.sevenbits.homework.buffer.IBuffer;
import it.sevenbits.homework.state.State;

/**
 * container for lexer
 */
public class LexerContainer {
    private State currentState;
    private char symbol;
    private IBuffer buffer;

    /**
     *
     * @return current state
     */
    public State getCurrentState() {
        return currentState;
    }

    /**
     *
     * @param currentState - for set current state
     */
    public void setCurrentState(final State currentState) {
        this.currentState = currentState;
    }

    /**
     *
     * @return character
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     *
     * @param symbol - for set character
     */
    public void setSymbol(final char symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return buffer lexer
     */
    public IBuffer getBuffer() {
        return buffer;
    }

    /**
     *
     * @param buffer - set buffer lexer
     */
    public void setBuffer(final IBuffer buffer) {
        this.buffer = buffer;
    }



}
