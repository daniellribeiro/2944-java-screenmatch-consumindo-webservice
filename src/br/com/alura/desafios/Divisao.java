package br.com.alura.desafios;

import java.util.Scanner;

public class Divisao {
    public static void main(String[] args) {
        float numero1 = lerNumero();
        float numero2 = lerNumero();

        try {
            if (numero2 == 0) {
                throw new ArithmeticException("Divisao por zero");
            }

            float soma = numero1 / numero2;
            System.out.println(numero1 + " / " + numero2 + " = " + soma);
        }catch(ArithmeticException e){
            System.out.println(e);
        }
    }

    public static Float lerNumero(){
        System.out.println("Digite um numero: ");
        Scanner leitura = new Scanner(System.in);
        return leitura.nextFloat();
    }
}
