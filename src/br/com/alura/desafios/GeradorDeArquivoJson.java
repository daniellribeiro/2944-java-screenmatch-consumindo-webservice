package br.com.alura.desafios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivoJson {
    public void gerarArquivoJson(Endereco endereco){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String texto = gson.toJson(endereco);
        try {
            FileWriter arquivo = new FileWriter(endereco.cep() + ".json");
            arquivo.write(texto);
            arquivo.close();
        } catch (IOException e) {
            System.out.println("Erro ao gerar arquivo!!!");
        }
    }
}
