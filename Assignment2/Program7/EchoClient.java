import java.io.*;
import java.net.*;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        // Example: client sends a greeting automatically
        out.println("Hello Server!");
        System.out.println("Server replied: " + in.readLine());

        // Example: client sends another message automatically
        out.println("How are you?");
        System.out.println("Server replied: " + in.readLine());

        // Example: client closes connection politely
        out.println("exit");
        socket.close();
    }
}
