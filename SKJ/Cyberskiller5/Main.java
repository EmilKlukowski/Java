import java.util.*;
import java.net.*;
import java.io.*;

class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int port = scan.nextInt();
		String hostname = "127.0.0.1";

		try {
			byte[] buf = "\n".getBytes();
			InetAddress address = InetAddress.getByName(hostname);
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket packet = new DatagramPacket(buf, buf.length, address, port);
			socket.send(packet);
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

	}
}
