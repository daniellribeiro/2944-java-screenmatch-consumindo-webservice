package br.com.alura.desafios;

import java.io.IOException;
import java.util.Scanner;

public class GoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um livro para busca: ");
        var busca = leitura.nextLine();

        APIConsulta.consulta(APIConsulta.montarEndereco("GoogleBooks",busca));
    }
}
