package it.sevenbits.homework.formatter;

import it.sevenbits.homework.state.State;

import java.util.HashMap;
import java.util.Map;

public class FormatterStateMap {
    private final State startState = new State("startState");
    private final State finalState = new State("finalState");

    private final Map<String, State> states;

    public FormatterStateMap() {
        states = new HashMap<>();

        State word = new State("word");
        State space = new State("space");
        State openBlockCode = new State("openBlockCode");
        State closeBlockCode = new State("closeBlockCode");
        State lineEnd = new State("lineEnd");

        states.put("literal", word);
        states.put("numeric", word);
        states.put("space", space);
        states.put("openBlockCode", openBlockCode);
        states.put("closeBlockCode", closeBlockCode);
        states.put("lineEnd", lineEnd);
    }

    public State getStartState() {
        return startState;
    }

    public State getNextState(final State state, final String tokenName) {
        return states.getOrDefault(tokenName, finalState);
    }
}
