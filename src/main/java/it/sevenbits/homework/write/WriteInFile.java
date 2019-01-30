package it.sevenbits.homework.write;

import java.io.*;
import java.nio.charset.Charset;

/**
 *
 */
public class WriteInFile implements IWriter, AutoCloseable {
    /**
     *
     */
    private BufferedWriter bw;
    public WriteInFile(final Writer writer) {
        bw = new BufferedWriter(writer);
    }

    public WriteInFile(final OutputStream outputStream, final Charset charset) {
        bw = new BufferedWriter(new OutputStreamWriter(outputStream, charset));
    }
    /**
     * @param symbol character to write
     * @throws IOException Exception
     */
    @Override
    public void write(final char symbol) throws IOException {
        bw.write((int) symbol);
    }

    @Override
    public void close() throws Exception {
        bw.close();
    }
}
