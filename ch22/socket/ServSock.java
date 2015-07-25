package ch22.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServSock {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Waiting for clients on port " + ss.getLocalPort());
        Socket socket = ss.accept();
        System.out.println("We've got a client!");
        Thread.sleep(2000);
    }
}
