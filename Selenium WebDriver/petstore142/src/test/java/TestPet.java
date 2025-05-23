// 0 - nome do pacote

// 1 - bibliotecas
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import io.restassured.response.Response; // Classe Resposta do REST-Assured

import static io.restassured.RestAssured.given; // função given
import static org.hamcrest.Matchers.*; // Classe de verificadores do Hamcrest

// 2 - classe
public class TestPet {

    // 2.1 - atributos
    static String ct = "application/json"; // Content-Type
    static String uriPet = "https://petstore.swagger.io/v2/pet"; // Base URL + endpoint

    // 2.2 - funções e métodos
    // 2.2.1 - funções e métodos comuns / uteis
    // Função de leitura do arquivo JSON
    public static String lerArquivoJson(String arquivoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(arquivoJson)));
    }

    // 2.2.2 - métodos de teste
    @Test
    public void testPostPet() throws IOException {
        // Configura

        // carregar os dados do arquivo JSON do pet ￼￼￼
        String jsonBody = lerArquivoJson("src/test/resources/json/pet1.json");

        int petId = 95; // Código esperado do pet

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
                .body("name", is("Snoopy")) // Verifica se o nome é Snoopy
                .body("id", is(petId)) // Verifica o código do pet
                .body("category.name", is("cachorro")) // Verifica se é cachorro
                .body("tags[0].name", is("vacinado")) // Verifica se está vacinado
        ; // Fim do given

    }
}
