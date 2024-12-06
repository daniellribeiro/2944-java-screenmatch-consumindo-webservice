package br.com.alura.desafios;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class APIConsulta {
    public static String consulta(String endereco) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
        HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 404){
            throw new ErroConsultaGitHubException("Usuario nao encontrado");
        }
        System.out.println(response.body());
        return response.body().toString();
    }

    public static String montarEndereco(String nomeAPI, String parametro) {
        parametro = parametro.replace(" ", "+");

        if ("GoogleBooks".equals(nomeAPI))
            return "https://www.googleapis.com/books/v1/volumes?q=" + parametro;
        else if ("CoinGecko".equals(nomeAPI))
            return "https://api.coingecko.com/api/v3/simple/price?ids=" + parametro + "&vs_currencies=brl";
        else if ("TheMealDB".equals(nomeAPI))
            return "https://www.themealdb.com/api/json/v1/1/search.php?s=" + parametro;
        else if("UsuarioGithub".equals(nomeAPI)){
            return "https://api.github.com/users/" + parametro;
        }

        return "";
    }
}
