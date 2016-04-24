package ch22.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class MyDatagram {
    private InetAddress remoteAddress;
    private int port, remotePort;
    DatagramSocket socket;


    public MyDatagram(InetAddress remoteAddress, int port, int remotePort) throws SocketException {
        this.remoteAddress = remoteAddress;
        this.port = port;
        this.remotePort = remotePort;
        socket = new DatagramSocket(port);
    }

    public String getPacket() throws IOException {
        byte[] incomingBytes = new byte[10];
        DatagramPacket incomingPacket = new DatagramPacket(incomingBytes,10);
        socket.receive(incomingPacket);
        return new String(incomingPacket.getData());
    }

    public void sendPacket(String text) throws IOException {
        byte[] txt = text.getBytes();
        DatagramPacket upcomingPacket = new DatagramPacket(txt,txt.length,remoteAddress,remotePort);
        socket.send(upcomingPacket);
    }
}
