package com.ciklum.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiTest {

    /*
    Doc - https://api.unitconvert.io/swagger/index.html
    API - Measurements
    measurement - 10kg
    Api key - e667987a-15d7-422e-90b3-add19d0a5cb6

    Check that category is Mass
     */
    @Test
    public void testApi() {
        given()
                .header("api-key", "e667987a-15d7-422e-90b3-add19d0a5cb6")
                .get("https://api.unitconvert.io/api/v1/Measurements/Info?measurement=10kg").then().assertThat()
                .statusCode(200).and().body("category", equalTo("Mass"));
    }
}
