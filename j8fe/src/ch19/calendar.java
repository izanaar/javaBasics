package ch19;

import java.util.Calendar;

public class calendar {
    public static void main(String[] args) {
        Calendar calendar1 = Calendar.getInstance();


        showCalendar(calendar1);

        calendar1.set(Calendar.HOUR,24);
        showCalendar(calendar1);
    }

    private static void showCalendar(Calendar calendar){
        String time = "";

        time+="Date:" + calendar.get(Calendar.DATE) + "." + calendar.get(Calendar.MONTH) + "." + calendar.get(Calendar.YEAR);
        time+="; Time " + calendar.get(Calendar.HOUR)+":"+calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)+";";
        System.out.println(time);
    }
}
