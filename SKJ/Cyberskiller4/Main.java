import java.util.*;
import java.net.*;
import java.io.*;
import util.SocketFactory;

class Main
{
    public static void main(String[] args) throws IOException
    {
        DatagramSocket socket = SocketFactory.buildSocket();

        byte[] buff = new byte[20];
        DatagramPacket packet = new DatagramPacket(buff, buff.length);

        try {
			socket.receive(packet);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

        String strout = new String(buff, 0, 20);
        System.out.println(strout);
        
        socket.close();

    }
}
