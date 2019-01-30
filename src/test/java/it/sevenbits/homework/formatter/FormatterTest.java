package it.sevenbits.homework.formatter;
import it.sevenbits.homework.formatter.Formatter;
import it.sevenbits.homework.read.ReadFromFile;
import it.sevenbits.homework.read.ReadFromLine;
import it.sevenbits.homework.write.WriteInLine;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class FormatterTest {
    private Formatter formatter;
    private BufferedReader br;
    private FileInputStream fis;

    @Before
    public void setUp() {
        this.formatter = new Formatter();
        br = mock(BufferedReader.class);
        fis = mock(FileInputStream.class);
    }

//    @Test
//    public void testReadFromFile() throws IOException{
//        char trueCharacter = 's';
//        char currentCharacter = 't';
//        when(br.ready()).thenReturn(true).thenReturn(false);
//        when(br.read()).thenReturn((int) trueCharacter);
//        when(fis).thenReturn(true);
//        ReadFromFile freader = new ReadFromFile(new FileInputStream("filename"), Charset.forName("UTF-8"));
//        while (freader.hasNext()) {
//            currentCharacter = freader.read();
//        }
//        Assert.assertEquals(trueCharacter, currentCharacter);
//    }

    @Test
    public void testCorrectResultOne() {
        StringBuilder current = new StringBuilder();
        String strForFormat = "\na{for{for{  { \n \n  a   aa;}}    }}\na";
        String trueCurrent = "a {\n" +
            "    for {\n" +
            "        for { {\n" +
            "                a aa;\n"+
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}\n" +
            "a";
        ReadFromLine reader = new ReadFromLine(strForFormat);
        WriteInLine writer = new WriteInLine(current);
        try {
            formatter.format(reader, writer);
        } catch (IOException e) {
            fail("IOException");
        }
        Assert.assertEquals(trueCurrent, current.toString());
    }

    @Test
    public void testCorrectResultTwo() {
        StringBuilder current = new StringBuilder();
        String strForFormat = "  s    \ns{ s  {s\n{ s  { ss;ss;}  } }}ss21{  }";
        String trueCurrent = "s s {\n" +
                "    s {\n" +
                "        s {\n" +
                "            s {\n" +
                "                ss;\n" +
                "                ss;\n"+
                "            }\n"+
                "        }\n" +
                "    }\n" +
                "}\n" +
                "ss21 {\n" +
                "}";
        ReadFromLine reader = new ReadFromLine(strForFormat);
        WriteInLine writer = new WriteInLine(current);
        try {
            formatter.format(reader, writer);
        } catch (IOException e) {
            fail("IOException");
        }
        System.out.println(current);
        Assert.assertEquals(trueCurrent, current.toString());
    }

    @Test
    public void testCorrectResultThree() {
        StringBuilder current = new StringBuilder();
        String strForFormat = "for{for{ss;ss;ss;}}";
        String trueCurrent = "for {\n" +
                "    for {\n" +
                "        ss;\n" +
                "        ss;\n" +
                "        ss;\n" +
                "    }\n" +
                "}";
        ReadFromLine reader = new ReadFromLine(strForFormat);
        WriteInLine writer = new WriteInLine(current);
        try {
            formatter.format(reader, writer);
        } catch (IOException e) {
            fail("IOException");
        }
        Assert.assertEquals(trueCurrent, current.toString());
    }

}
