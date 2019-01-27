package it.sevenbits.homework.lexer.container;

import it.sevenbits.homework.buffer.IBuffer;
import it.sevenbits.homework.state.State;

public class LexerContainer {
    private State currentState;
    private char symbol;
    private IBuffer buffer;

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(final State currentState) {
        this.currentState = currentState;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(final char symbol) {
        this.symbol = symbol;
    }

    public IBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(final IBuffer buffer) {
        this.buffer = buffer;
    }



}
