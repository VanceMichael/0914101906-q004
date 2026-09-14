package example;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
public final class Application {
  public static void main(String[] args) throws Exception {
    HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/health", exchange -> { byte[] body = "{\"status\":\"ok\"}".getBytes(); exchange.sendResponseHeaders(200, body.length); exchange.getResponseBody().write(body); exchange.close(); });
    server.start();
  }
}
