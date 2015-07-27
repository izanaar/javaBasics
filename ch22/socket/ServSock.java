package ch22.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServSock {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(6862);
        System.out.println("Waiting for clients on port " + ss.getLocalPort());
        Socket socket = ss.accept();
        System.out.println("We've got a client!");
        String message = "Hello, client.", respond;

        PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));


        pw.println("Ready to transmit. Type \'over.\' to break connection.");

        do{
            message = br.readLine();
            System.out.println("[" + new Date() + "] client says: " + message);
            if(message.endsWith("over."))
                break;
            System.out.print("Your answer: ");
            pw.println(keyIn.readLine());
            System.out.println("Message sent.");
        }while (true);
        System.out.print("Finishing transmit...");
        pw.println("Acknowledge, over.");
        System.out.println("Client informded.");
    }
}
