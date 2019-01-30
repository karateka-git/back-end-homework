package it.sevenbits.homework.state;

import org.junit.Assert;
import org.junit.Test;

public class StateTest {
    @Test
    public void stateTest() {
        String trueState = "testState";
        State state = new State(trueState);
        State stateTwo = new State(trueState);
        Assert.assertTrue(state.equals(stateTwo));

    }
}
