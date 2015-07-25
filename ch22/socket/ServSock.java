package ch22.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServSock {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket ss = new ServerSocket(6862);
        System.out.println("Waiting for clients on port " + ss.getLocalPort());
        Socket socket = ss.accept();
        System.out.println("We've got a client!");
        Thread.sleep(2000);

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
