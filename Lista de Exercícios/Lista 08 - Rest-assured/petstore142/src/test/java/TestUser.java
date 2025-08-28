// 0 - nome do pacote

// 1 - bibliotecas
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.MethodOrderer; // Anotação para marcar métodos de teste (JUnit 5)
import org.junit.jupiter.api.Order; // Define a ordem de execução dos testes
import org.junit.jupiter.api.Test; // Controla a ordem dos métodos de teste na classe
import org.junit.jupiter.api.TestMethodOrder; // Estratégias para ordenar métodos de teste
import org.junit.jupiter.params.ParameterizedTest; // Permite testes parametrizados (com diferentes entradas)
import org.junit.jupiter.params.provider.CsvFileSource; // Biblioteca para converter objetos Java em JSON e vice-versa

import static io.restassured.RestAssured.given;

// 2 - classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Ativa a ordenação dos testes
public class TestUser {

    // 2.1 - atributos
    static String ct = "application/json"; // Content-Type
    static String uriUser = "https://petstore.swagger.io/v2/user"; // Base URL + endpoint

    // 2.2 - métodos de teste
    @Test
    @Order(1)
    public void testPostUser() {
        // Configura
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
    @Order(2)
    public void testGetUser() {
        // Configura
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
    @Order(3)
    public void testPutUser() {
        // Configura
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
    @Order(4)
    public void testDeleteUser() {
        // Configura
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

    // Data Driven Testing(DDT) - Teste Direcionado por Dados / Teste com Massa
    @ParameterizedTest
    @Order(5)
    @CsvFileSource(resources = "/csv/userMassa.csv", numLinesToSkip = 1)
    public void testPostUserDataDriven(int id, String username, String firstName, String lastName, String email, String password, String phone, int userStatus) {
        // Configura
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
