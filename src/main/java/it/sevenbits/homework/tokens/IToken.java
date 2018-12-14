package it.sevenbits.homework.tokens;

public interface IToken {
    String getName();
    String getLexeme();
    void setName(String name);
    void append(char symbol);
}
