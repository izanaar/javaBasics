package ch22.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSock {
    public static void main(String[] args) throws IOException {
        /*byte[] rem = new byte[]{(byte)192,(byte)168,(byte)1,(byte)217};
        InetAddress remoteAddr = InetAddress.getByAddress(rem);
        */
        InetAddress remoteAddr = InetAddress.getLocalHost();
        int remotePort = 6862;
        System.out.println("Attempting to connect.");
        Socket socket = new Socket(remoteAddr,remotePort);
        System.out.println("Connection " +
                (socket.isConnected() ? "established." : "not established."));

        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        String message = "Hello, server, It's your client speaking!";

        pw.println("228");

        System.out.println("Server speaks: " + br.readLine());
        System.out.println("We'll try to answer...");
        pw.println(message);
        System.out.println("Answer sent.");
    }
}
