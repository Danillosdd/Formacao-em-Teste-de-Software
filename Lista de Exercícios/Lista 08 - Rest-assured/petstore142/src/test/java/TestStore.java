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
public class TestStore {

    // 2.1 - atributos
    static String ct = "application/json"; // Content-Type
    static String uriStore = "https://petstore.swagger.io/v2/store/order"; // Base URL + endpoint

    // 2.2 - métodos de teste
    @Test
    @Order(1)
    public void testPostStore() {
        // Configura
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
    @Order(2)
    public void testGetStore() {
        // Configura
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
    @Order(3)
    public void testDeleteStore() {
        // Configura
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

    // Data Driven Testing(DDT) - Teste Direcionado por Dados / Teste com Massa
    @ParameterizedTest
    @Order(4)
    @CsvFileSource(resources = "/csv/storeMassa.csv", numLinesToSkip = 1)
    public void testPostStoreDataDriven(int id, int petId, int quantity, String shipDate, String status, boolean complete) {
        // Configura
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
