package it.sevenbits;

import it.sevenbits.lexer.LexerJava;
import it.sevenbits.read.ReadFromLine;
import it.sevenbits.tokens.IToken;
import it.sevenbits.write.WriteInLine;

import java.io.IOException;

/**
 *
 */
public class Main {
    private static String strForFormat = "{asdaw{a213s{2123}+2+}}";

    /**
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter();
        //formatter.format(strForFormat, sb);
        ReadFromLine reader = new ReadFromLine(strForFormat);
        WriteInLine writer = new WriteInLine(sb);
//        try {
//            formatter.format(reader, writer);
//        } catch (IOException e) {
//            e.getMessage();
//        }
//        System.out.println(sb);
        LexerJava lexerJava = new LexerJava(reader);
        while (lexerJava.hasMoreTokens()) {
            IToken token = lexerJava.readToken();
            System.out.println(token.getLexeme());
        }

    }
}
