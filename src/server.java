import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = null;
        Socket clientSocket = null;
        DataInputStream input = null;

        try {
    
            serverSocket = new ServerSocket(5000);
            System.out.println("Server is connected at port no: " + serverSocket.getLocalPort());
            System.out.println("Waiting for the client...");

            clientSocket = serverSocket.accept();
            System.out.println("Client request is accepted at port no: " + clientSocket.getPort());
            System.out.println("Server’s Communication Port: " + clientSocket.getLocalPort());

           
            input = new DataInputStream(clientSocket.getInputStream());
            String str = "";

            while (!str.equals("stop")) {
                str = input.readUTF();
                System.out.println("Client Says: " + str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (input != null) input.close();
                if (clientSocket != null) clientSocket.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
