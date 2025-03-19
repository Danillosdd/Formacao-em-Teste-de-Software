// 1 - Bibliotecas / Imports
// 1.1 - Pacotes
package com.iterasys;

// 2 - Classes
public class Main {
    // 2.1 - Atributos

    // 2.2 - Métodos e Funções
    public static void main(String[] args) {
        System.out.println("Olá Mundo!");
    }

    public static float somar(float num1, float num2) {
        float resultado = num1 + num2;
        System.out.println("Soma de " + num1 + " + " + num2 + " = " + resultado);
        return resultado;
    }

    public static float subtrair(float num1, float num2) {
        float resultado = num1 - num2;
        System.out.println("Subtração de " + num1 + " - " + num2 + " = " + resultado);
        return resultado;
    }

    public static float multiplicar(float num1, float num2) {
        float resultado = num1 * num2;
        System.out.println("Multiplicação de " + num1 + " * " + num2 + " = " + resultado);
        return resultado;
    }

    public static float dividir(float num1, float num2) {
        float resultado = num1 / num2;
        System.out.println("Divisão de " + num1 + " / " + num2 + " = " + resultado);
        return resultado;
    }

}
