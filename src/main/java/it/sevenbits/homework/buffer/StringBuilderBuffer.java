package it.sevenbits.homework.buffer;

public class StringBuilderBuffer implements IBuffer {
    private StringBuilder buffer;

    public StringBuilderBuffer() {
        this.buffer = new StringBuilder();
    }

    @Override
    public void addChar(final char c) {
        buffer.append(c);
    }

    @Override
    public void clear() {
        buffer.setLength(0);
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
