package it.sevenbits.homework.read;

/**
 *
 */
public class ReadFromLine implements IReader {
    private int currentIndex;
    private String string;

    /**
     *
     * @param string string
     */
    public ReadFromLine(final String string) {
        this.currentIndex = 0;
        this.string = string;
    }

    @Override
    public boolean hasNext() {
        return this.string.length() > this.currentIndex;
    }

    @Override
    public char read() {
        if (this.currentIndex >= this.string.length()) {
            throw new IndexOutOfBoundsException("Out of line");
        }
        char symbol = this.string.charAt(this.currentIndex);
        this.currentIndex += 1;
        return symbol;
    }
}
