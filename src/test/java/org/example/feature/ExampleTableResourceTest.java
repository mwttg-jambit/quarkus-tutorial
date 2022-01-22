package org.example.feature;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.example.PostgresDatabase;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@QuarkusTest
@QuarkusTestResource(PostgresDatabase.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ExampleTableResourceTest {

  @Test
  @Order(1)
  @TestTransaction
  public void testEndpoints() {
    System.out.println("Test1 - Endpoints");

    // findAll
    given()
        .when().get("/feature/example-table")
        .then().statusCode(200).body(is("[]"));

    // create (stuff get written into the testcontainers postgres DB
    final String body = "{\"name\": \"TestName\", \"used\": true}";
    given()
        .contentType(ContentType.JSON)
        .body(body)
        .when().post("/feature/example-table")
        .then().statusCode(204);

    // findAll
    given()
        .when().get("/feature/example-table")
        .then().statusCode(200).body(is("[{\"id\":1,\"name\":\"TestName\",\"used\":true}]"));
  }


  // Why rollback doesn't work
  // https://stackoverflow.com/questions/65912368/is-there-a-way-to-rollback-a-transaction-in-quarkus-unit-tests
  // https://stackoverflow.com/questions/65646508/how-do-you-achieve-integration-tests-in-quarkus-without-dirtiescontext
//  @Test
//  @Order(2)
//  public void testisRolledBack() {
//    System.out.println("Test2 - is it rolled back");
//    // findAll after first test is executed noting should be inside the DB
//    given()
//        .when().get("/feature/example-table")
//        .then().statusCode(200).body(is("[]"));
//  }
}