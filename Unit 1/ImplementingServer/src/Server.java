import java.net.*;
public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();
        System.out.println("Client connected");
        s.close();
        ss.close();
    }
}