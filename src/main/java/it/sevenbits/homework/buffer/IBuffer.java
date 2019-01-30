package it.sevenbits.homework.buffer;

/**
 * interface buffers
 */
public interface IBuffer {
    /**
     * add character
     * @param c - character for add
     */
    void addChar(char c);

    /**
     * clear buffer
     */
    void clear();

    /**
     *
     * @return buffer content
     */
    String toString();
}
