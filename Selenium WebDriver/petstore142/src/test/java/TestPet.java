// 0 - nome do pacote

// 1 - bibliotecas
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static io.restassured.RestAssured.given;

// 2 - classe
@TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Ordena os testes
public class TestPet {

    // 2.1 - atributos
    static String ct = "application/json"; // Content-Type
    static String uriPet = "https://petstore.swagger.io/v2/pet"; // Base URL + endpoint
    static int petId = 95; // Código esperado do pet
    String petName = "Snoopy"; // Nome do pet esperado
    String categoryName = "cachorro"; // Categoria do pet esperado
    String tagName = "vacinado"; // Tag do pet esperado
    String[] status = { "available", "sold" }; // Status do pet esperado

    // 2.2 - funções e métodos
    // 2.2.1 - funções e métodos comuns / uteis
    // Função de leitura do arquivo JSON
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // 2.2.2 - métodos de teste
    @Test
    @Order(1) // Ordem de execução do teste
    public void testPostPet() throws IOException {
        // Configura --> Dados de entrada e saída no começo da Classe
        // Entradas e Saídas definidas no começo da Classe

        // carregar os dados do arquivo JSON do pet ￼￼￼
        String jsonBody = lerArquivoJson("src/test/resources/json/pet1.json");

        // Começa o teste via Rest-Assured
        given() // Dado que
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida
                .body(jsonBody) // Envie o corpo da requisição

                // Executa
                .when() // Quando
                .post(uriPet) // Chamamos o endpoint faznedo um POST

                // Valida
                .then() // Então
                .log().all() // Mostre tudo na volta
                .statusCode(200) // O código de resposta é 200
                .body("name", is(petName)) // Verifica se o nome é Snoopy
                .body("id", is(petId)) // Verifica o código do pet
                .body("category.name", is(categoryName)) // Verifica se é cachorro
                .body("tags[0].name", is(tagName)) // Verifica se está vacinado

        ; // Fim do given

    }

    @Test
    @Order(2) // Ordem de execução do teste
    public void testGetPet() {
        // Configura --> Dados de entrada e saída no começo da Classe
        // Entradas e Saídas definidas no começo da Classe

        // Começa o teste via Rest-Assured
        given()
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida
                .header("", "api_key: " + TestUser.testLogin()) // Adiciona o header com o token de autenticação

                // Quando é get ou delete não tem body

                // Executa
                .when() // Quando
                .get(uriPet + "/" + petId) // Montar o endpoint da URI/<petId>

                // Valida
                .then() // Então
                .log().all() // Mostre tudo na volta
                .statusCode(200) // O código de resposta é 200
                .body("name", is(petName)) // Verifica se o nome é Snoopy
                .body("id", is(petId)) // Verifica o código do pet
                .body("category.name", is(categoryName)) // Verifica se é cachorro
                .body("tags[0].name", is(tagName)) // Verifica se está vacinado

        ; // Fim do given

    }

    @Test
    @Order(3) // Ordem de execução do teste
    public void testPutPet() throws IOException {
        // Configura --> Dados de entrada e saída no começo da Classe
        String jsonBody = lerArquivoJson("src/test/resources/json/pet2.json");

        given()
                .contentType(ct)
                .log().all()
                .body(jsonBody)

                // Executa
                .when()
                .put(uriPet)

                // Valida
                .then()
                .log().all()
                .statusCode(200) // O código de resposta é 200
                .body("name", is(petName)) // Verifica se o nome é Snoopy
                .body("id", is(petId)) // Verifica o código do pet
                .body("category.name", is(categoryName)) // Verifica se é cachorro
                .body("tags[0].name", is(tagName)) // Verifica se está vacinado
                .body("status", is(status[1])) // Verifica se o status é sold

        ; // Fim do given

    }

    @Test
    @Order(4) // Ordem de execução do teste
    public void testDeletePet() {
        // Configura --> Dados de entrada e saída no começo da Classe

        given()
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida
                // Executa
                .when() // Quando
                .delete(uriPet + "/" + petId) // Montar o endpoint da URI/<petId>
                // Valida
                .then() // Então
                .log().all() // Mostre tudo na volta
                .statusCode(200) // O código de resposta é 200
                .body("code", is(200)) // Verifica o código de resposta
                .body("type", is("unknown")) // Verifica o tipo de resposta
                .body("message", is(String.valueOf(petId))) // Verifica a mensagem com o petId

        ; // Fim do given

    }

}
