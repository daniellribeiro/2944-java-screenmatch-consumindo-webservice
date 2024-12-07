package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        String busca = "";
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (!busca.equalsIgnoreCase("SAIR")) {
            Scanner leitura = new Scanner(System.in);
            System.out.println("Digite um filme para busca: ");
            busca = leitura.nextLine();
            if(busca.equalsIgnoreCase("SAIR")){
                break;
            }
            busca = busca.replace(" ", "+");
            String endereco =
                    "https://www.omdbapi.com/?t=" +
                            busca +
                            "&apikey=687abcb1";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = (String) response.body();
            System.out.println(json);

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            try {
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(gson.toJson(titulos));
        escrita.close();
        System.out.println(titulos);
    }
}
