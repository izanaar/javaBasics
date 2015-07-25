package ch19;

import java.util.Date;

public class date {
    public static void main(String[] args) {
        Date date = new Date(),date1 = new Date();
        System.out.println(date);
        System.out.println("Milliseconds passed since Jan 1, 1970: " + date.getTime());
        date1.setTime(date.getTime() - 60000 * 60 * 24);
        System.out.println(date1);
        System.out.println("Date 2 earlier date 1 = " + date1.before(date));
    }
}
