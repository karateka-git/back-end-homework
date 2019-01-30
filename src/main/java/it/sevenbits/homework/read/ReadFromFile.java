package it.sevenbits.homework.read;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * read from file
 */
public class ReadFromFile implements IReader, AutoCloseable {
    private BufferedReader br;
    private int symbol = 0;

    /**
     *
     * @param reader -
     */
    public ReadFromFile(final Reader reader) {
        br = new BufferedReader(reader);
    }

    /**
     *
     * @param inputStream -
     * @param charset -
     */
    public ReadFromFile(final InputStream inputStream, final Charset charset) {
        br = new BufferedReader(new InputStreamReader(inputStream, charset));
    }
    /**
     * @return boolean
     * @throws IOException Exception
     */
    @Override
    public boolean hasNext() throws IOException {
        return br.ready();
    }

    /**
     * @return char
     * @throws IOException Exception
     */
    @Override
    public char read() throws IOException {
        symbol =  br.read();
        return (char) symbol;
    }

    @Override
    public void close() throws Exception {
        br.close();
    }
}
