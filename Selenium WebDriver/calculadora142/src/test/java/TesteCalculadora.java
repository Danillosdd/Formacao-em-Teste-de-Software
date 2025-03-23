
// bibliotecas
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.iterasys.Main;

//classe
public class TesteCalculadora {
    //atributos

    //funções e metodos
    @Test
    public void testeSomar() {
        // AAA - Arrange, Act, Assert
        // CEV - Configura, Executa, Valida

        //Configura
        // Dados de Entrada
        float num1 = 10;
        float num2 = 8;

        // Dados de Saída / Resultado Esperado
        float resultadoEsperado = 18;

        // Executa
        float resultadoAtual = Main.somar(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @Test
    public void testesubtrair() {
        // AAA - Arrange, Act, Assert
        // CEV - Configura, Executa, Valida

        //Configura
        // Dados de Entrada
        float num1 = 25;
        float num2 = 14;

        // Dados de Saída / Resultado Esperado
        float resultadoEsperado = 11;

        // Executa
        float resultadoAtual = Main.subtrair(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @Test
    public void testeMultiplicar() {
        // AAA - Arrange, Act, Assert
        // CEV - Configura, Executa, Valida

        //Configura
        // Dados de Entrada
        float num1 = 8;
        float num2 = 7;

        // Dados de Saída / Resultado Esperado
        float resultadoEsperado = 56;

        // Executa
        float resultadoAtual = Main.multiplicar(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @Test
    public void testeDividir() {
        // AAA - Arrange, Act, Assert
        // CEV - Configura, Executa, Valida

        //Configura
        // Dados de Entrada
        int num1 = 27;
        int num2 = 3;

        // Dados de Saída / Resultado Esperado
        String resultadoEsperado = "9";

        // Executa
        String resultadoAtual = Main.dividirTry(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @Test
    public void testeDividirPorZero() {
        // AAA - Arrange, Act, Assert
        // CEV - Configura, Executa, Valida

        //Configura
        // Dados de Entrada
        int num1 = 7;
        int num2 = 0;

        // Dados de Saída / Resultado Esperado
        String resultadoEsperado = "Não é possível dividir por zero";

        // Executa
        String resultadoAtual = Main.dividirTry(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    // DDT: Data Driver Testing --> Teste Direcionado à Dados
    // Popular: Teste com massa
    @ParameterizedTest
    @CsvSource(value = {
        "15, 25, 40.0",
        "0, 12, 12.0",
        "-5, 9, 4.0",
        "-7, -8, -15.0",
        "0.5, 3.7, 4.2"
    }, delimiter = ',')
    public void testeSomarDDT(float num1, float num2, float resultadoEsperado) {
        // AAA - Arrange, Act, Assert
        // CEV - Configura, Executa, Valida

        //Configura
        // Os Dados de entrada e o resultado esperado são lidos da massa de teste acima  
        // Executa
        float resultadoAtual = Main.somar(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

    @ParameterizedTest
    @CsvFileSource(resources = "csv/somar.csv", numLinesToSkip = 1, delimiter = ',')
    public void testeSomarCSV(float num1, float num2, float resultadoEsperado) {
        // AAA - Arrange, Act, Assert
        // CEV - Configura, Executa, Valida

        //Configura
        // Os Dados de entrada e o resultado esperado são lidos da massa de teste acima  
        // Executa
        float resultadoAtual = Main.somar(num1, num2);

        // Valida
        assertEquals(resultadoEsperado, resultadoAtual);

    }

}
