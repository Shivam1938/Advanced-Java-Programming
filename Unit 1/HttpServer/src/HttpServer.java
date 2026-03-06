import java.io.OutputStream;
import java.net.InetSocketAddress;

public class HttpServer {
    public static void main(String[] args) throws Exception {

        com.sun.net.httpserver.HttpServer server = com.sun.net.httpserver.HttpServer.create(
                new InetSocketAddress(1000), 0);

        server.createContext("/", exchange -> {
            String response = "Hello Server!";
            exchange.sendResponseHeaders(200, response.length());

            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        });

        server.start();
        System.out.println("Server running at http://localhost:1000");
    }
}
