package it.sevenbits.homework.lexer;
import it.sevenbits.homework.state.State;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LexerStateMapTest {
    private LexerStateMap lexer;
    @Before
    public void setUp() {
        lexer = new LexerStateMap();
    }

    @Test
    public void testReturnNumeric(){
        String trueCurrent = "numeric";
        State current = lexer.getNextState(lexer.getStartState(),'3');
        Assert.assertEquals(trueCurrent, current.toString());
    }

    @Test
    public void testReturnLiteral(){
        String trueCurrent = "literal";
        State current = lexer.getNextState(lexer.getStartState(),'s');
        Assert.assertEquals(trueCurrent, current.toString());
    }
}
