package ch22;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleSocket {
    public static void main(String[] args) {
        try(Socket s = new Socket("whois.internic.net",43)){
            InputStream is = s.getInputStream();
            OutputStream ous = s.getOutputStream();

            String addr = "vk.com\n";
            ous.write(addr.getBytes());

            int q;

            System.out.print(is.read());
            byte[] z = new byte[is.available()];
            is.read(z);

            System.out.println(new String(z));

            /*
            while ((q = is.read()) != -1)
                System.out.print((char) q);*/
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
