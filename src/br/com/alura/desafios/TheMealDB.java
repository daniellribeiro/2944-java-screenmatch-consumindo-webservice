package br.com.alura.desafios;

import java.io.IOException;
import java.util.Scanner;

public class TheMealDB {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite uma receita para busca: ");
        var busca = leitura.nextLine();

        APIConsulta.consulta(APIConsulta.montarEndereco("TheMealDB",busca));
    }
}
