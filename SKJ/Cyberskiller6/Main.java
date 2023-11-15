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
			byte[] buf2 = new byte[20];
			packet = new DatagramPacket(buf2, 1);
			String ret = "";
			for (int i = 0; i < 20; i++) {
				socket.receive(packet);
				if(packet.getLength() <= 0){
					i--;
					continue;
				}
				ret = String.join("", ret, new String(packet.getData(), 0, 1));
			}
			

            socket.close();
            System.out.println(ret);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

        String strout = new String(buff, 0, 20);
        System.out.println(strout);
        
        socket.close();

        
    }
}
