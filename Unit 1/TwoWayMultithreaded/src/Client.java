import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(s.getInputStream()));

        PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);

        BufferedReader keyboard =
                new BufferedReader(
                        new InputStreamReader(System.in));

        // Thread to receive messages
        new Thread(() -> {
            try {
                String msg;
                while ((msg = in.readLine()) != null) {
                    System.out.println("\nServer: " + msg);
                }
            } catch (Exception e) {}
        }).start();

        // Main thread to send messages
        String msg;
        while (true) {
            msg = keyboard.readLine();
            out.println(msg);
        }
    }
}
