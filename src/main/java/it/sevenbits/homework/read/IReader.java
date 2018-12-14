package it.sevenbits.homework.read;

import java.io.IOException;

/**
 *
 */
public interface IReader {
    /**
     *
     * @return boolean
     * @throws IOException Exception
     */
    boolean hasNext() throws IOException;

    /**
     *
     * @return char
     * @throws IOException Exception
     */
    char read() throws IOException;
}
