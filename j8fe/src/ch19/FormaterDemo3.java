package ch19;

import java.util.Formatter;


public class FormaterDemo3 {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();

        for(int i = 2; i < 11; i++){
            fmt.format("%4d %4d %4d", i,i*i,i*i*i);
            System.out.println(fmt);
            fmt = new Formatter();
        }
    }
}
