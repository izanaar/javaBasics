package ch22;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddr {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);

        address = InetAddress.getByName("www.youtube.com");
        System.out.println(address);

        address = InetAddress.getByAddress(new byte[]{127,0,0,1});
        System.out.println(address.getHostAddress());
    }
}
