package it.sevenbits.behomework;

import java.util.Arrays;

public class Formatter {
    private int CountSpace = 0;
    private int CountSpaceBetweenSymbol = 0;
    private final int STANDART_SPACE = 4;

    public Formatter() {}
    public void format(String str){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ';') {
                transfer(sb, str.charAt(i), 0);
            }else if (str.charAt(i) == '{') {
                transfer(sb, str.charAt(i), getStandartSpace());
            }else if (str.charAt(i) == '}') {
                transfer(sb, str.charAt(i), -getStandartSpace());
            }else {
                myAppendSymbol(sb, str.charAt(i));
            }
        }
        System.out.println(sb);
    }

    private void transfer(StringBuilder sb, char symbol, int space) {
        sb.append(symbol);
        setCountSpace(getCountSpace() + space);
        setCountSpaceBetweenSymbol(getCountSpace());
        sb.append("\n");
    }

    private void myAppendSymbol(StringBuilder sb, char symbol) {
        if (symbol == ' ') return;
        sb.append(repeat(' ', getCountSpaceBetweenSymbol())).append(symbol);
        setCountSpaceBetweenSymbol(0);
    }

    private String repeat(char what, int howmany) {
        char[] chars = new char[howmany];
        Arrays.fill(chars, what);
        return new String(chars);
    }

    public int getStandartSpace() {
        return STANDART_SPACE;
    }

    public int getCountSpace() {
        return CountSpace;
    }

    public void setCountSpace(int countSpace) {
        CountSpace = countSpace;
    }
    public int getCountSpaceBetweenSymbol() {
        return CountSpaceBetweenSymbol;
    }

    public void setCountSpaceBetweenSymbol(int countSpaceBetweenSymbol) {
        CountSpaceBetweenSymbol = countSpaceBetweenSymbol;
    }
}
