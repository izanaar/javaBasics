package ch19;

import java.util.TimeZone;

public class _TimeZone {
    public static void main(String[] args) {
        TimeZone defTimeZone = TimeZone.getDefault();
        System.out.println(defTimeZone.getID());
    }
}
