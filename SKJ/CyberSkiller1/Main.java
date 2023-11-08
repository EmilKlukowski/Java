import java.io.*;
import java.net.*;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int port = scan.nextInt();

		Sock sock = new Sock();

		System.out.println(sock.getConnection("127.0.0.1", port));
	}
}



class Sock{
	public String getConnection(String hostName, int port){
		byte[] data = new byte[20];

		try{
			Socket socket = new Socket(hostName, port);
			socket.getInputStream().read(data, 0, 20);
			socket.close();

			return new String(data, 0, 20);
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}
}
