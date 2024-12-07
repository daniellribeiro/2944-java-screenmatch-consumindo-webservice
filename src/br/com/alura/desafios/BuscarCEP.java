package br.com.alura.desafios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.util.Scanner;

public class BuscarCEP {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Digite um cep: ");
        Scanner leitura = new Scanner(System.in);
        String parametro = leitura.nextLine();

        try {
            String json = APIConsulta.consulta(APIConsulta.montarEndereco("ViaCep", parametro));
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Endereco endereco = gson.fromJson(json, Endereco.class);
            System.out.println(endereco);
            GeradorDeArquivoJson geradorDeArquivoJson = new GeradorDeArquivoJson();
            geradorDeArquivoJson.gerarArquivoJson(endereco);
        }catch(JsonSyntaxException e){
            System.out.println("Não foi possivel consultar CEP");
        }
    }
}