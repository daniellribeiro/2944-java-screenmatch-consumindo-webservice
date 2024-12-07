package br.com.alura.desafios;

import java.io.FileWriter;
import java.io.IOException;

public class GravarArquivo {
    public static void main(String[] args) {
        try {
            FileWriter arquivo = new FileWriter("arquivo.txt");
            arquivo.write("Conteúdo a ser gravado no arquivo");
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Erro ao tentar salvar o arquivo: ");
            throw new RuntimeException(e);
        }
    }
}
