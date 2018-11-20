package it.sevenbits.read;

import java.io.IOException;

/**
 *
 */
public interface IReader {
    /**
     *
     * @return boolean
     * @throws IOException Exception не понимаю нужен ли
     */
    boolean hasNext();

    /**
     *
     * @return char
     * @throws IOException Exception не понимаю нужен ли
     */
    char read();
}
