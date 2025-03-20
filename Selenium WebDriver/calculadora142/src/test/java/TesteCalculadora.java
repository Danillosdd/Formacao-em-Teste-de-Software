
// bibliotecas
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

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

}
