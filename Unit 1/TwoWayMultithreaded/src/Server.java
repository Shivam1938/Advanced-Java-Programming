import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server waiting...");

        Socket s = ss.accept();
        System.out.println("Client connected");

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(s.getInputStream()));

        PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);

        BufferedReader keyboard =
                new BufferedReader(
                        new InputStreamReader(System.in));

        // Thread to receive
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("\nClient: " + msg);
                }
            } catch (Exception e) {}
        }).start();

        // Main thread to send
        String msg;
        while (true) {
            msg = keyboard.readLine();
            out.println(msg);
        }
    }
}
