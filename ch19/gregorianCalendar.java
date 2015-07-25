package ch19;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class gregorianCalendar {
    public static void main(String[] args) {
        //GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("Europe/Moscow"));
        GregorianCalendar calendar = new GregorianCalendar(new Locale("ru"));
        showCalendar(calendar);

    }

    private static void showCalendar(GregorianCalendar calendar){
        String time = "";

        time+="Date:" + calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR);
        time+="; Time " + calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)+";\n";
        time+="Locale:" + calendar;
        System.out.println(time);
    }
}
