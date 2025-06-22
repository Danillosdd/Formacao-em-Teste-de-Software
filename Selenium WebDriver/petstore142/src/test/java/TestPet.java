// 0 - nome do pacote

// 1 - bibliotecas
import java.io.IOException; // Para tratar exceções de entrada/saída (IO)
import java.nio.file.Files; // Para ler arquivos do sistema de arquivos
import java.nio.file.Paths; // Para manipular caminhos de arquivos

import static org.hamcrest.Matchers.is; // Anotação para marcar métodos de teste (JUnit 5)
import org.junit.jupiter.api.Order; // Define a ordem de execução dos testes
import org.junit.jupiter.api.Test; // Controla a ordem dos métodos de teste na classe
import org.junit.jupiter.params.ParameterizedTest; // Estratégias para ordenar métodos de teste
import org.junit.jupiter.params.provider.CsvFileSource; // Permite testes parametrizados (com diferentes entradas)

import com.google.gson.Gson; // Biblioteca para converter objetos Java em JSON e vice-versa

import static io.restassured.RestAssured.given; // Facilita a criação de requisições HTTP com Rest-Assured

// 2 - classe
public class TestPet {

    // 2.1 - atributos
    static String ct = "application/json"; // Content-Type
    static String uriPet = "https://petstore.swagger.io/v2/pet"; // Base URL + endpoint
    static int petId = 95; // Código esperado do pet

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

        // Entrada - petId que está definido no nível da classe

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

    @Test
    public void testGetPet() {
        // Configura

        // Entrada - petId que está definido no nível da classe

        // Saídas / Resultados esperados

        String petName = "Snoopy"; // Nome do pet esperado
        String categoryName = "cachorro"; // Categoria do pet esperado
        String tagName = "vacinado"; // Tag do pet esperado

        given()
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida
                // Quando é get ou delete não tem body
                // Executa
                .when() // Quando
                .get(uriPet + "/" + petId) // Montar o endpoint da URI/<petId>
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

    // Data Driven Testing(DDT) - Teste Direcionado por Dados / Teste com Massa
    // Teste com Json parametrizado

    @ParameterizedTest
    @Order(5)
    @CsvFileSource(resources = "/csv/petMassa.csv", numLinesToSkip = 1, delimiter = ',') // Lê o arquivo CSV, ignorando
                                                                                         // a primeira linha, e o
                                                                                         // separador é vírgula
    public void testPostPetDDT(
            String petId, // Parâmetro do ID do pet
            String petName, // Parâmetro do nome do pet
            String carId, // Parâmetro do ID da categoria
            String catName, // Parâmetro do nome da categoria
            String status1, // Parâmetro do status do pet
            String status2 // Parâmetro do status do pet
    ) // Fim dos Parâmetros
    { // Início do códigos do método testPostPetDDT

        // Criar a classe pet para receber os dados do csv
        Pet pet = new Pet(); // Cria uma nova instância da classe Pet

        pet.petId = petId; // Atribui o ID do pet do csv ao atributo petId do objeto pet
        pet.petName = petName; // Atribui o nome do pet do csv ao atributo petName do objeto pet
        pet.carId = carId; // Atribui o ID da categoria do csv ao atributo carId do objeto pet
        pet.catName = catName; // Atribui o nome da categoria do csv ao atributo catName do objeto pet
        pet.status = status1; // Atribui o status do pet do csv ao atributo status1 do objeto pet. Status inicial usado no Post = "available"

        // Criar um Json para o Body a ser enviado a partir da classe Pet e do CSV
        Gson gson = new Gson(); // Cria uma instância do Gson para converter objetos Java em JSON
        String jsonBody = gson.toJson(pet); // Converte o objeto pet em uma string JSON(Convertendo o CSV em JSON)
        
        given()
                .contentType(ct) // O tipo do conteudo é
                .log().all() // Mostre tudo na ida
                .body(jsonBody) // Envie o corpo da requisição com o JSON gerado
                // Executa
                .when() // Quando
                .post(uriPet) // Chamamos o endpoint faznedo um POST
                // Valida
                .then() // Então
                .log().all() // Mostre tudo na volta
                .statusCode(200) // O código de resposta é 200
                .body("id", is(petId)) // Verifica o código do pet convertido para inteiro
                .body("name", is(petName)) // Verifica se o nome é igual ao do CSV
                .body("category.name", is(catName)) // Verifica se a categoria é igual ao do CSV
                .body("status", is(status1)) // Verifica se o status é igual ao do CSV
    }
}