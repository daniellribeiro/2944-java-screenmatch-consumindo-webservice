package br.com.alura.desafios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class VeiculoJson {
    public static void main(String[] args) {
        Veiculo veiculo = new Veiculo("Ecosport",2011,"Preto");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(gson.toJson(veiculo));
    }
}
