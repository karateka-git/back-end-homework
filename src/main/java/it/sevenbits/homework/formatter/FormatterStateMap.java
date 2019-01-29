package it.sevenbits.homework.formatter;

import it.sevenbits.homework.state.State;

import java.util.HashMap;
import java.util.Map;

public class FormatterStateMap {
    private final State startState = new State("startState");
    private final State finalState = new State("finalState");

    private final Map<String, State> states;

    /**
     * StateMap for Formatter
     */
    FormatterStateMap() {
        states = new HashMap<>();

        State word = new State("word");
        State space = new State("space");
        State openBlockCode = new State("openBlockCode");
        State closeBlockCode = new State("closeBlockCode");
        State lineEnd = new State("lineEnd");
        State singleComment = new State("singleComment");

        states.put("literal", word);
        states.put("numeric", word);
        states.put("space", space);
        states.put("openBlockCode", openBlockCode);
        states.put("closeBlockCode", closeBlockCode);
        states.put("lineEnd", lineEnd);
        states.put("singleComment", singleComment);
    }

    State getStartState() {
        return startState;
    }

    /**
     *
     * @param tokenName - parameter to determine the next state
     * @return - current state
     */
    State getNextState(final String tokenName) {
        return states.getOrDefault(tokenName, finalState);
    }
}
