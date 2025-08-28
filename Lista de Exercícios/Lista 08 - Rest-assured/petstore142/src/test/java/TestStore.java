import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;

public class TestStore {
    static String ct = "application/json";
    static String uriStore = "https://petstore.swagger.io/v2/store/order";

    @Test
    public void testPostStore() {
        String jsonBody = "{\"id\": 1, \"petId\": 95, \"quantity\": 1, \"shipDate\": \"2025-08-28T00:00:00.000Z\", \"status\": \"placed\", \"complete\": true}";
        given()
            .contentType(ct)
            .log().all()
            .body(jsonBody)
        .when()
            .post(uriStore)
        .then()
            .log().all()
            .statusCode(200)
            .body("id", is(1))
            .body("status", is("placed"));
    }

    @Test
    public void testGetStore() {
        given()
            .contentType(ct)
            .log().all()
        .when()
            .get(uriStore + "/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("id", is(1));
    }

    @Test
    public void testDeleteStore() {
        given()
            .contentType(ct)
            .log().all()
        .when()
            .delete(uriStore + "/1")
        .then()
            .log().all()
            .statusCode(200)
            .body("message", containsString("1"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/storeMassa.csv", numLinesToSkip = 1)
    public void testPostStoreDataDriven(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        String jsonBody = String.format("{\"id\": %d, \"petId\": %d, \"quantity\": %d, \"shipDate\": \"%s\", \"status\": \"%s\", \"complete\": %b}", id, petId, quantity, shipDate, status, complete);
        given()
            .contentType(ct)
            .log().all()
            .body(jsonBody)
        .when()
            .post(uriStore)
        .then()
            .log().all()
            .statusCode(200)
            .body("id", is(id))
            .body("status", is(status));
    }
}
