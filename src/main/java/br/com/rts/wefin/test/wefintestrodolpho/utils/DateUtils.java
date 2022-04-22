package br.com.rts.wefin.test.wefintestrodolpho.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

    public static Date createDate(int day, int month, int year) {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}
