package example;

import java.sql.DriverManager;

public final class Migrate {
  public static void main(String[] args) throws Exception {
    try (var connection = DriverManager.getConnection("jdbc:sqlite:" + Application.databasePath());
         var statement = connection.createStatement()) {
      statement.execute("create table if not exists schema_version(version integer not null)");
    }
    System.out.println("数据库已初始化");
  }
}
