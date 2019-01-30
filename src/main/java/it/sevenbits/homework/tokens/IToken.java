package it.sevenbits.homework.tokens;

/**
 * interface for token
 */
public interface IToken {
    /**
     *
     * @return name token
     */
    String getName();

    /**
     *
     * @return content token
     */
    String getLexeme();

    /**
     *
     * @param symbol - character to add
     */
    void append(char symbol);
}
