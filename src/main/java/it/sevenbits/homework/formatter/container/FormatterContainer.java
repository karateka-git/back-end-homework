package it.sevenbits.homework.formatter.container;

import it.sevenbits.homework.state.State;
import it.sevenbits.homework.tokens.IToken;
import it.sevenbits.homework.write.IWriter;

/**
 * container for formatter
 */
public class FormatterContainer {
    private IWriter writer;
    private State state;
    private IToken token;
    private int indentLevel;
    private int STANDARD_SPACE = 4;

    /**
     *
     * @return writer
     */
    public IWriter getWriter() {
        return writer;
    }

    /**
     *
     * @param writer -
     */
    public void setWriter(final IWriter writer) {
        this.writer = writer;
    }

    /**
     *
     * @return token
     */
    public IToken getToken() {
        return token;
    }

    /**
     *
     * @param token -
     */
    public void setToken(final IToken token) {
        this.token = token;
    }

    /**
     *
     * @return state
     */
    public State getState() {
        return state;
    }

    /**
     *
     * @param state -
     */
    public void setCurrentState(final State state) {
        this.state = state;
    }

    /**
     *
     * @return current indent level
     */
    public int getIndentLevel() {
        return indentLevel;
    }

    /**
     *
     * @param indentLevel -
     */
    public void setIndentLevel(final int indentLevel) {
        this.indentLevel = indentLevel;
    }

    /**
     *
     * @return standard space for java
     */
    public int getStandardSpace() {
        return STANDARD_SPACE;
    }
}
