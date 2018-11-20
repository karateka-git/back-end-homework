package it.sevenbits.tokens;

public class Token implements IToken {
    private String name;
    private StringBuilder sb;

    public Token() {
        this.sb = new StringBuilder();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getLexeme() {
        return String.valueOf(sb);
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public void append(final char symbol) {
        this.sb.append(symbol);
    }
}
