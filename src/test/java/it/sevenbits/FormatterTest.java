package it.sevenbits;
import it.sevenbits.read.ReadFromLine;
import it.sevenbits.write.WriteInLine;

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
        String strForFormat = "{{{{ss;}}}}";
        String trueCurrent = "{\n" +
                "    {\n" +
                "        {\n" +
                "            {\n" +
                "                ss;\n" +
                "            }\n" +
                "        }\n" +
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
