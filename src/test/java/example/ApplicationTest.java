package example;

import org.junit.jupiter.api.Test;

class ApplicationTest {
  @Test void sqliteCanBeOpened() throws Exception { Application.checkDatabase(); }
}
