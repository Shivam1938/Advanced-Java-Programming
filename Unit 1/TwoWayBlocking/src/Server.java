import java.net.*;
import java.io.*;
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        BufferedReader in =
                new BufferedReader(
                        new InputStreamReader(s.getInputStream()));
        PrintWriter out =
                new PrintWriter(s.getOutputStream(), true);
        BufferedReader kb =
                new BufferedReader(
                        new InputStreamReader(System.in));
        while (true) {
            String msg = in.readLine();
            System.out.println("Client: " + msg);
            msg = kb.readLine();
            out.println(msg);
        }
    }
}