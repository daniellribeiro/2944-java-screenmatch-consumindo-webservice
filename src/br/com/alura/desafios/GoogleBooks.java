package br.com.alura.desafios;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.*;

public class GoogleBooks {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um livro para busca: ");
        var busca = leitura.nextLine();

        String json = APIConsulta.consulta(APIConsulta.montarEndereco("GoogleBooks",busca));
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonArray jsonObjectItems = jsonObject.getAsJsonArray("items");

        ArrayList livros = new ArrayList();

        for (int i = 0 ; i < jsonObjectItems.size(); i++){
            JsonObject jsonVolumeInfo = jsonObjectItems.get(i).getAsJsonObject().getAsJsonObject("volumeInfo");
            Livro livro = gson.fromJson(jsonVolumeInfo,Livro.class);
            livros.add(livro);
        }
        System.out.println(livros);
    }
}
