package it.sevenbits.write;

import java.io.IOException;

/**
 *
 */
public interface IWriter {
    /**
     *
     * @param symbol character
     * @throws IOException Exception
     */
    void write(char symbol)throws IOException;
}
