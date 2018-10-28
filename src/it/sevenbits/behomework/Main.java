package it.sevenbits.behomework;

public class Main {
    private static String StrForFormat = "\na{for{for{  { \n \n  a   aa;}}    }}\na";
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter();
        formatter.format(StrForFormat, sb);
        System.out.println(sb);
    }
}
