import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class client {
    public static void main(String[] args) throws IOException{
        Socket socket = null;
        DataOutputStream output = null;
        BufferedReader reader = null;

        try {
            socket = new Socket("localhost", 5000);
            System.out.println("Client’s communication port " + socket.getLocalPort());
            System.out.println("Client is Connected");
         
            output = new DataOutputStream(socket.getOutputStream());
            reader = new BufferedReader(new InputStreamReader(System.in));

            String str;
            while (!(str = reader.readLine()).equals("stop")) {
                output.writeUTF(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (output != null) output.close();
                if (reader != null) reader.close();
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
