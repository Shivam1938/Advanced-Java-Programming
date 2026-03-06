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
        BufferedReader kb =
                new BufferedReader(
                        new InputStreamReader(System.in));
        while (true) {
            String msg = kb.readLine();
            out.println(msg);
            msg = in.readLine();
            System.out.println("Server: " + msg);
        }
    }
}