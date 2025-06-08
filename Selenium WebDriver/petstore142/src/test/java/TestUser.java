// 0 - nome do pacote

// 1 - bibliotecas
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;

// 2 - classe
public class TestUser {

    // 2.1 - atributos
    static String ct = "application/json"; // Content-Type
    static String uriUser = "https://petstore.swagger.io/v2/user"; // Base URL + endpoint

    // 2.2 - funções e métodos
    // 2.2.1 - métodos de teste
    @Test
    public void testLogin() {
        // Configura --> Dados de entrada e saída no começo da Classe

        String username = "danillo"; // Nome de usuário esperado
        String password = "honeypot"; // Senha esperada

        String resultadoEsperado = "logged in user session:"; // Sem espaço após os dois pontos

        Response resposta = (Response) given()
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida

                // Executa
                .when() // Quando
                .get(uriUser + "/login?username=" + username + "&password=" + password) // Montar o endpoint de login

                // Valida
                .then() // Então
                .log().all() // Mostre tudo na volta
                .statusCode(200) // O código de resposta é 200
                .body("code", is(200)) // Verifica o código de resposta
                .body("type", is("unknown")) // Verifica o tipo de resposta
                .body("message", containsString(resultadoEsperado)) // Verifica se contém o resultado esperado
                .body("message", hasLength(36)) // Verifica se a mensagem tem o tamanho esperado
                .extract()

        ; // Fim do given

        // extração
        String token = resposta.jsonPath().getString("message").substring(23); // Extrai o token da resposta
        System.out.println("Conteúdo do Token: " + token); // Imprime o token no console
    }
}
