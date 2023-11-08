import java.util.*;
import java.net.*;
import java.io.*;


public class Server {

    public static void main(String[] args) {

        for (String portStr : args){
			try {
				int port = Integer.parseInt(portStr);
				new Thread(new ServerTask(port)).start();
			} catch (NumberFormatException e) {
				throw new RuntimeException(e);
			}
		}
    }


    public static class ServerTask implements Runnable{

		int port;

		public ServerTask(int port) {
			this.port = port;
		}

		@Override
		public void run() {
			try{
				ServerSocket serverSocket = new ServerSocket(port);
				while(true){
					Socket clientSocket = serverSocket.accept();
					new Thread(new ClientHandler(clientSocket)).start();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}


	public static class ClientHandler implements Runnable {

		private Socket clientSocket;

		public ClientHandler(Socket clientSocket) {
			this.clientSocket = clientSocket;
		}

		@Override
		public void run() {
			try {
				InputStream input = clientSocket.getInputStream();
				byte[] buffer = new byte[20];
				int bytesRead = input.read(buffer);

				String receivedData = new String(buffer, 0, bytesRead);
				System.out.println(receivedData);
			} catch (IOException e) {
				throw new RuntimeException(e);
			} finally {
				try {
					clientSocket.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}



