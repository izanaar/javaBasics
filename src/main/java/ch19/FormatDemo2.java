package ch19;

import java.util.Formatter;

/**
 * Created by ierus on 7/17/15.
 */
public class FormatDemo2 {
    public static void main(String[] args) {
        Formatter fmt = new Formatter();

        for(double i = 3.14; i<3.14e+6;i*=1e2){
            fmt.format("%e %f ", i,i);
            System.out.println(fmt);
        }
        fmt.close();
    }
}
