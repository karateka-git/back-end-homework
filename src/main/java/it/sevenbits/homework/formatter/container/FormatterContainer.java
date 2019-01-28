package it.sevenbits.homework.formatter.container;

import it.sevenbits.homework.state.State;
import it.sevenbits.homework.tokens.IToken;
import it.sevenbits.homework.write.IWriter;

public class FormatterContainer {
    private IWriter writer;
    private State state;
    private IToken token;
    private int indentLevel;
    private int STANDART_SPACE = 4;

    public IWriter getWriter() {
        return writer;
    }

    public void setWriter(final IWriter writer) {
        this.writer = writer;
    }

    public IToken getToken() {
        return token;
    }

    public void setToken(final IToken token) {
        this.token = token;
    }

    public State getState() {
        return state;
    }

    public void setCurrentState(final State state) {
        this.state = state;
    }

    public int getIndentLevel() {
        return indentLevel;
    }

    public void setIndentLevel(final int indentLevel) {
        this.indentLevel = indentLevel;
    }

    public int getStandartSpace() {
        return STANDART_SPACE;
    }
}
