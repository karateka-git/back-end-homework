package it.sevenbits.behomework;

import java.util.Arrays;

public class Formatter {
    private int CountSpace = 0;
    private int CountSpaceBetweenSymbol = 0;
    private final int STANDART_SPACE = 4;

    public Formatter() {}
    public void format(String str, StringBuilder sb){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ';') {
                insertSpecSymbol(sb, str.charAt(i));
            }else if (str.charAt(i) == '{') {
                insertSpecSymbol(sb, str.charAt(i));
                transfer(sb, getStandartSpace());
            }else if (str.charAt(i) == '}') {
                transfer(sb, -getStandartSpace());
                insertSpecSymbol(sb, str.charAt(i));
            }else {
                insertSymbol(sb, str.charAt(i));
            }
        }
    }

    private void transfer(StringBuilder sb, int space) {
        setCountSpace(getCountSpace() + space);
        setCountSpaceBetweenSymbol(getCountSpace());
        sb.append("\n");
    }

    private void insertSpecSymbol(StringBuilder sb, char symbol) {
        sb.append(repeat(' ', getCountSpaceBetweenSymbol())).append(symbol);
    }

    private void insertSymbol(StringBuilder sb, char symbol) {
        if (symbol == ' ' || symbol == '\n') return;
        sb.append(repeat(' ', getCountSpaceBetweenSymbol())).append(symbol);
        setCountSpaceBetweenSymbol(0);
    }

    private String repeat(char what, int howmany) {
        char[] chars = new char[howmany];
        Arrays.fill(chars, what);
        return new String(chars);
    }

    private int getStandartSpace() {
        return STANDART_SPACE;
    }

    private int getCountSpace() {
        return CountSpace;
    }

    private void setCountSpace(int countSpace) {
        CountSpace = countSpace;
    }

    private int getCountSpaceBetweenSymbol() {
        return CountSpaceBetweenSymbol;
    }

    private void setCountSpaceBetweenSymbol(int countSpaceBetweenSymbol) {
        this.CountSpaceBetweenSymbol = countSpaceBetweenSymbol;
    }
}
