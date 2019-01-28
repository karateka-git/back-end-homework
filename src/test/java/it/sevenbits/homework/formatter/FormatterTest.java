package it.sevenbits.homework.formatter;
import it.sevenbits.homework.formatter.Formatter;
import it.sevenbits.homework.read.ReadFromLine;
import it.sevenbits.homework.write.WriteInLine;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.junit.Assert.fail;

import java.io.IOException;

public class FormatterTest {
    private Formatter formatter;

    @Before
    public void setUp() {
        this.formatter = new Formatter();
    }

    @Test
    public void testCorrectResultOne() {
        StringBuilder current = new StringBuilder();
        String strForFormat = "\na{for{for{  { \n \n  a   aa;}}    }}\na";
        String trueCurrent = "a{\n" +
                "    for{\n" +
                "        for{\n" +
                "            {\n" +
                "                aaa;\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}a";
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
                "{\n" +
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
        String strForFormat = "{{ss;ss;ss;}}";
        String trueCurrent = "{\n" +
                "    {\n" +
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
