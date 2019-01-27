package it.sevenbits.homework.lexer;

import it.sevenbits.homework.pair.Pair;
import it.sevenbits.homework.state.State;

import java.util.HashMap;
import java.util.Map;

public class LexerStateMap {
    private final State startState = new State("startState");
    private final State finalState = new State("finalState");

    private final Map<Pair<State, Character>, State> states;

    public LexerStateMap() {
        states = new HashMap<>();

        State lineEnd = new State("lineEnd");
        State openBlockCode = new State("openBlockCode");
        State closeBlockCode = new State("closeBlockCode");
        State space = new State("space");
        State literal = new State("literal");
        State numeric = new State("numeric");

        states.put(new Pair<>(startState, ';'), lineEnd);
        states.put(new Pair<>(startState, '{'), openBlockCode);
        states.put(new Pair<>(startState, '}'), closeBlockCode);
        states.put(new Pair<>(startState, ' '), space);
        states.put(new Pair<>(startState, '\n'), space);
        states.put(new Pair<>(startState, 'a'), literal);
        states.put(new Pair<>(startState, '1'), numeric);

        states.put(new Pair<>(literal, 'a'), literal);
        states.put(new Pair<>(numeric, '1'), numeric);
    }

    public State getStartState() {
        return startState;
    }

    /**
     *
     * @param state - current state
     * @param signal - incoming signal
     * @return next state from states map<state, signal>
     */
    public State getNextState(final State state, final Character signal) {
        char copysignal;
        copysignal = Character.isDigit(signal) ? '1' : Character.isLetter(signal) ? 'a' : signal;
        return states.getOrDefault(new Pair<>(state, copysignal), finalState);
    }

}
