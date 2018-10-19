package it.sevenbits.behomework;

public class Main {
    private static String StrForFormat = "aaa { bbbb; ccc;}";
    public static void main(String[] args) {
        Formatter formatter = new Formatter();
        formatter.format(StrForFormat);
    }
}
