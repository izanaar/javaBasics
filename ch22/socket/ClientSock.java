package ch22.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientSock {
    public static void main(String[] args) throws IOException {
        byte[] rem = new byte[]{(byte)192,(byte)168,(byte)1,(byte)217};
        InetAddress remoteAddr = InetAddress.getByAddress(rem);
        int remotePort = 6862;
        System.out.println("Attempting to connect.");
        Socket socket = new Socket(remoteAddr,remotePort);
        System.out.println("Connection " +
                (socket.isConnected() ? "established." : "not established."));

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner sc = new Scanner(System.in);


        String message, respond;
        do{
            System.out.print("Type your message: ");
            message = sc.nextLine();
            pw.print(message);
            respond = br.readLine();

        }while (!respond.equals("over"));
    }
}
