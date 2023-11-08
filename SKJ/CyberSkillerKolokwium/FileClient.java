import java.util.*;
import java.net.*;
import java.io.*;


public class FileClient {
    public static void main(String[] args) {

        int port = Integer.parseInt(args[0]);
        String hostName = "127.0.0.1";

        try{
            Socket socket = new Socket(hostName, port);


            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader readFileData = new BufferedReader(isr);

            System.out.println("Connected to server. Waiting for file.");
            System.out.println("File received:");

            String output = "";

            while ((output = readFileData.readLine()) != null) {
                System.out.println(output);
            }
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
