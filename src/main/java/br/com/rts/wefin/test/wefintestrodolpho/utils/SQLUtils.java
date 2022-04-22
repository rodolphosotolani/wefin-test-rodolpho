package br.com.rts.wefin.test.wefintestrodolpho.utils;

public class SQLUtils {

    public static String formatterString(String texto) {
        StringBuilder builder = new StringBuilder("%");
        builder.append(texto.toUpperCase());
        builder.append("%");
        return builder.toString();
    }
}
