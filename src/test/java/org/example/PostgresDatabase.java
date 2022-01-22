package org.example;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;
import java.util.Map;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

public class PostgresDatabase implements QuarkusTestResourceLifecycleManager {

  private static final DockerImageName IMAGE_NAME = DockerImageName.parse("postgres:11.7-alpine");
  private static final PostgreSQLContainer<?> DATABASE = new PostgreSQLContainer<>(IMAGE_NAME)
          .withDatabaseName("example_db")
          .withUsername("admin")
          .withPassword("admin");

  @Override
  public Map<String, String> start() {
    DATABASE.start();
    System.out.println("  --> Started Postgres DB: " + DATABASE.getJdbcUrl());
    return Map.of("quarkus.datasource.jdbc.url", DATABASE.getJdbcUrl());
  }

  @Override
  public void stop() {
    DATABASE.stop();
  }
}
