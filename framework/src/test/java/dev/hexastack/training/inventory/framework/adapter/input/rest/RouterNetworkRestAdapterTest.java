package dev.hexastack.training.inventory.framework.adapter.input.rest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class RouterNetworkRestAdapterTest {

    @Test
    void testAddNetwork() {
        String json = """
                {
                    "routerId": "ca23800e-9b5a-11eb-a8b3-0242ac130003",
                    "address": "20.0.0.0",
                    "name": "Marketing",
                    "cidr": 9
                }
                """;
        given()
                .contentType(ContentType.JSON)
                .body(json)
                .when().post("/networks")
                .then()
                .statusCode(200);

        given()
                .contentType(ContentType.JSON)
                .body("{}")
                .when().post("/networks")
                .then()
                .statusCode(400);
    }
}
