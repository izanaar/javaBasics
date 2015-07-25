package ch19;

import java.util.Formatter;

public class FormatDemo4 {
    public static void main(String[] args) {
        String path = "/qqq/www/228", prop = "file";
        int v = 10;
        Formatter fmt = new Formatter(System.out);
        fmt.format("%s %"+ v +"s %n", path,prop);
        fmt.flush();
        fmt.format("%s %s", path,prop);
    }
}
