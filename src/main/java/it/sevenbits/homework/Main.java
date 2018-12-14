package it.sevenbits.homework;

import it.sevenbits.homework.read.ReadFromFile;
import it.sevenbits.homework.read.ReadFromLine;
import it.sevenbits.homework.write.WriteInFile;
import it.sevenbits.homework.write.WriteInLine;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

/**
 *
 */
public class Main {
    private static String strForFormat = "\na{for{for{  { \n \n  a   aa;}}    }}\na";

    /**
     *
     * @param args input
     * @throws Exception exception
     */
    public static void main(final String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter();
        ReadFromLine reader = new ReadFromLine(strForFormat);
        WriteInLine writer = new WriteInLine(sb);
        formatter.format(reader, writer);
        System.out.println(sb);
        try (
            ReadFromFile freader = new ReadFromFile(new FileInputStream(args[0]), Charset.forName("UTF-8"));
            WriteInFile fwriter = new WriteInFile(new FileOutputStream(args[1]), Charset.forName("UTF-8"));
        ) {
            formatter.format(freader, fwriter);
        }
    }
}
