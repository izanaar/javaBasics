package ch22;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MyURL {
    public static void main(String[] args) {
        URL x;
        try {
            x = new URL("http://vk.com/");
            System.out.println(x.getProtocol());
            System.out.println(x.getUserInfo());
            System.out.println(x.getHost() + "\n");
        } catch (MalformedURLException e) {
            System.out.println(e);
            return;
        }


        try {
            URLConnection conn = x.openConnection();

            conn.getHeaderFields().forEach((title,vals) ->{
                System.out.println("Title: " + title);
                System.out.print("Vals: ");
                vals.forEach(val -> System.out.print(val + ", "));
                System.out.println();
            });
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
