package example;

import java.sql.DriverManager;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
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
    SpringApplication.run(Application.class, args);
  }

  @GetMapping("/health")
  Map<String, String> health() throws Exception {
    checkDatabase();
    return Map.of("status", "ok");
  }
}
