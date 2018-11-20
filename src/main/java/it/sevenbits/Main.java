package it.sevenbits;

import it.sevenbits.read.ReadFromLine;
import it.sevenbits.write.WriteInLine;

import java.io.IOException;

/**
 *
 */
public class Main {
    private static String strForFormat = "\na{for{for{  { \n \n  a   aa;}}    }}\na";

    /**
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter();
        ReadFromLine reader = new ReadFromLine(strForFormat);
        WriteInLine writer = new WriteInLine(sb);
        try {
            formatter.format(reader, writer);
        } catch (IOException e) {
            e.getMessage();
        }
        System.out.println(sb);

    }
}
