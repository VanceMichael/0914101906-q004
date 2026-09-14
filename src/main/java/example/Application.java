package example;

import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;

public final class Application {
  static String databasePath() {
    return System.getenv().getOrDefault("OBSTACLE_CHECKIN_DB_PATH", "obstacle-checkin.db");
  }

  static void checkDatabase() throws Exception {
    try (var connection = DriverManager.getConnection("jdbc:sqlite:" + databasePath());
         var statement = connection.createStatement()) {
      statement.execute("select 1");
    }
  }

  public static void main(String[] args) throws Exception {
    checkDatabase();
    var server = HttpServer.create(new InetSocketAddress(8080), 0);
    server.createContext("/health", exchange -> {
      var body = "{\"status\":\"ok\"}".getBytes(StandardCharsets.UTF_8);
      exchange.getResponseHeaders().set("Content-Type", "application/json; charset=utf-8");
      exchange.sendResponseHeaders(200, body.length);
      exchange.getResponseBody().write(body);
      exchange.close();
    });
    server.start();
  }
}
