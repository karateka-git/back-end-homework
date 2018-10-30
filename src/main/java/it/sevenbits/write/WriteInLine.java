package it.sevenbits.write;

/**
 *
 */
public class WriteInLine implements IWriter {
    private StringBuilder sb;

    /**
     *
     * @param sb StringBuilder
     */
    public WriteInLine(final StringBuilder sb) {
        this.sb = sb;
    }

    @Override
    public void write(final char symbol) {
        this.sb.append(symbol);
    }

}
