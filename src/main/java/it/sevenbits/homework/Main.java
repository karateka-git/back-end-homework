package it.sevenbits.homework;

import it.sevenbits.homework.formatter.Formatter;
import it.sevenbits.homework.read.ReadFromFile;
import it.sevenbits.homework.write.WriteInFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/**
 * program main class
 */
public class Main {
    /**
     *
     * @param args input
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {
        Formatter formatter = new Formatter();
        try (
            ReadFromFile freader = new ReadFromFile(new FileInputStream(args[0]), Charset.forName("UTF-8"));
            WriteInFile fwriter = new WriteInFile(new FileOutputStream(args[1]), Charset.forName("UTF-8"));
        ) {
            formatter.format(freader, fwriter);
        }
    }
}
