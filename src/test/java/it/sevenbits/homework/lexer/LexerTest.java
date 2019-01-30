package it.sevenbits.homework.lexer;

import it.sevenbits.homework.read.IReader;
import it.sevenbits.homework.tokens.IToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import java.io.IOException;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class LexerTest {
    private IToken token;
    private Lexer lexer;
    private IReader reader;


    @Before
    public void setUp() {
        reader = mock(IReader.class);
        this.token = mock(IToken.class);
        lexer = new Lexer(reader);
    }

    @Test
    public void NotDefinedTest() throws IOException {
        TestLogger logger = TestLoggerFactory.getTestLogger(Lexer.class);
        char preSymbol = '_';
        when(reader.hasNext()).thenReturn(true);
        when(reader.read()).thenReturn(preSymbol);
        lexer.readToken();
        assertEquals(String.format("State for \"%s\" not defined", preSymbol), logger.getLoggingEvents().get(0).getMessage());
    }

    @Test
    public void returnTokenNameMathTest() {
        try {
            String trueCurrent = "openBlockCode";
            when(reader.hasNext()).thenReturn(true).thenReturn(false);
            when(reader.read()).thenReturn('{');
            token = lexer.readToken();
            Assert.assertEquals(trueCurrent, token.getName());
        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Test
    public void stateTest() {
        try {
            String trueCurrent = "literal";
            when(reader.hasNext()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
            when(reader.read()).thenReturn('a').thenReturn('b').thenReturn('c').thenReturn('2');
            token = lexer.readToken();
            Assert.assertEquals(trueCurrent, token.getName());
            Assert.assertEquals("abc2", token.getLexeme());

        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Test
    public void commentTest() {
        try {
            String trueCurrent = "//s3\n";
            String trueCurrentName = "singleComment";
            when(reader.hasNext()).thenReturn(true);
            when(reader.read()).thenReturn('/').thenReturn('/').thenReturn('s').thenReturn('3').thenReturn('\n');
            token = lexer.readToken();
            Assert.assertEquals(trueCurrentName, token.getName());
            Assert.assertEquals(trueCurrent, token.getLexeme());

        } catch (IOException e) {
            fail("IOException");
        }
    }

}
