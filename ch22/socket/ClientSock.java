package ch22.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSock {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),6666);
        System.out.println(socket.isConnected());
    }
}
