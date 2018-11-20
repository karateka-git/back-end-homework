package it.sevenbits.lexer;

import it.sevenbits.read.IReader;
import it.sevenbits.tokens.IToken;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class LexerJavaTest {
    private IToken token;
    private LexerJava lexer;
    private IReader reader;

    @Before
    public void setUp() {
        reader = mock(IReader.class);
        this.token = mock(IToken.class);
        lexer = new LexerJava(reader);
    }

    @Test(expected = NullPointerException.class)
    public void failNullPointerTest() {
        try {
            when(reader.hasNext()).thenReturn(true);
            when(reader.read()).thenReturn('_');
            lexer.readToken();
        } catch (IOException e) {
            fail("IOException");
        }
    }

    @Test
    public void returnTokenNameMathTest() {
        try {
            String trueCurrent = "math";
            when(reader.hasNext()).thenReturn(true).thenReturn(false);
            when(reader.read()).thenReturn('+');
            token = lexer.readToken();
            Assert.assertEquals(trueCurrent, token.getName());
        } catch (IOException e) {
            fail("IOException");
        }
    }

}
