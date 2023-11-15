import java.util.*;
import java.net.*;
import java.io.*;

class Main
{
    public static void main(String[] args)
    {
        String hostName = "127.0.0.1";
		Scanner scan = new Scanner(System.in);
		int port = scan.nextInt();

		try {
			InetAddress adress = InetAddress.getByName(hostName);

			byte[] buf = new byte[20];

			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, adress, port);

			socket.send(packet);

			byte[] buf2 = new byte[20];

			packet = new DatagramPacket(buf2, buf2.length);
			socket.receive(packet);


			socket.close();

			String ret = new String(packet.getData(), 0, 20);
			System.out.println(ret);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


    }
}
