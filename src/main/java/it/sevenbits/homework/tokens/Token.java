package it.sevenbits.homework.tokens;

public class Token implements IToken {
    private String name;
    private StringBuilder sb;

    public Token(final String name) {
        this.name = name;
        this.sb = new StringBuilder();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getLexeme() {
        return String.valueOf(sb);
    }


    @Override
    public void append(final char symbol) {
        this.sb.append(symbol);
    }
}
