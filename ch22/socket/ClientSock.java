package ch22.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSock {
    public static void main(String[] args) throws IOException {
        byte[] rem = new byte[]{(byte)192,(byte)168,(byte)1,(byte)217};
        InetAddress remoteAddr = InetAddress.getByAddress(rem);
        int remotePort = 6862;
        System.out.println("Attempting to connect.");
        Socket socket = new Socket(remoteAddr,remotePort);
        System.out.println(socket.isConnected());
    }
}
