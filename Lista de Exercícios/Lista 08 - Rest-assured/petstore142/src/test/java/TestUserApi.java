import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static io.restassured.RestAssured.given;

public class TestUserApi {
    static String ct = "application/json";
    static String uriUser = "https://petstore.swagger.io/v2/user";

    @Test
    public void testPostUser() {
        String jsonBody = "{\"id\": 10, \"username\": \"danillo\", \"firstName\": \"Danillo\", \"lastName\": \"Silva\", \"email\": \"danillo@email.com\", \"password\": \"honeypot\", \"phone\": \"123456789\", \"userStatus\": 1}";
        given()
            .contentType(ct)
            .log().all()
            .body(jsonBody)
        .when()
            .post(uriUser)
        .then()
            .log().all()
            .statusCode(200)
            .body("message", containsString("10"));
    }

    @Test
    public void testGetUser() {
        given()
            .contentType(ct)
            .log().all()
        .when()
            .get(uriUser + "/danillo")
        .then()
            .log().all()
            .statusCode(200)
            .body("username", is("danillo"));
    }

    @Test
    public void testPutUser() {
        String jsonBody = "{\"id\": 10, \"username\": \"danillo\", \"firstName\": \"Danillo\", \"lastName\": \"Silva\", \"email\": \"danillo@email.com\", \"password\": \"honeypot\", \"phone\": \"987654321\", \"userStatus\": 1}";
        given()
            .contentType(ct)
            .log().all()
            .body(jsonBody)
        .when()
            .put(uriUser + "/danillo")
        .then()
            .log().all()
            .statusCode(200)
            .body("message", containsString("10"));
    }

    @Test
    public void testDeleteUser() {
        given()
            .contentType(ct)
            .log().all()
        .when()
            .delete(uriUser + "/danillo")
        .then()
            .log().all()
            .statusCode(200)
            .body("message", containsString("danillo"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/userMassa.csv", numLinesToSkip = 1)
    public void testPostUserDataDriven(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        String jsonBody = String.format("{\"id\": %d, \"username\": \"%s\", \"firstName\": \"%s\", \"lastName\": \"%s\", \"email\": \"%s\", \"password\": \"%s\", \"phone\": \"%s\", \"userStatus\": %d}", id, username, firstName, lastName, email, password, phone, userStatus);
        given()
            .contentType(ct)
            .log().all()
            .body(jsonBody)
        .when()
            .post(uriUser)
        .then()
            .log().all()
            .statusCode(200)
            .body("message", containsString(String.valueOf(id)));
    }
}
