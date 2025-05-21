// 0 - nome do pacote

// 1 - bibliotecas
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;
import io.restassured.response.Response;

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
        // carregar os dados do arquivo JSON do pet ￼￼￼
        String jsonBody = lerArquivoJson("src/test/resources/json/pet1.json");

        String petId = "95"; // Código esperado do pet
        
        // Começa o teste via Rest-Assured
        given()
            .contentType(ct)
            .body(jsonBody)

    }
}
