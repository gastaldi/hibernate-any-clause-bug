package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
class MyServiceTest {

    @Test
    void fromDatasource() {
        given()
                .get("/datasource")
                .then()
                .statusCode(200);
    }

    @Test
    void fromHibernate() {
        given()
                .get("/hibernate")
                .then()
                .statusCode(200);
    }
}