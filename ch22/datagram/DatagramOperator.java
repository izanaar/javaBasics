package ch22.datagram;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

public class DatagramOperator {
    public static void main(String[] args) throws IOException, InterruptedException {
        InetAddress address = InetAddress.getLocalHost();
        int port1 = 22345, port2 = 22346;
        MyDatagram dat1 = new MyDatagram(address,port1, port2),
                dat2 = new MyDatagram(address, port2, port1);
/*
        new Thread(() -> {
            System.out.println(new Date() + " packet will be sent in 1,5 sec");
            try {
                Thread.sleep(1500);
                dat1.sendPacket("Hello");
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println(e);
            }
        }).start();

        System.out.println(new Date() + " waiting for incoming packet...");*/
        dat1.sendPacket("Hello.p839");
        System.out.println(new Date() + " received packet contains: " + dat2.getPacket());
    }
}
