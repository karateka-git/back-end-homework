package it.sevenbits.homework.read;

import it.sevenbits.homework.lexer.Lexer;
import it.sevenbits.homework.tokens.IToken;
import org.junit.Before;

import java.io.BufferedReader;

import static org.mockito.Mockito.mock;

public class ReadFromFileTest {
    private BufferedReader br;
    @Before
    public void setUp() {
        br = mock(BufferedReader.class);
    }

}
