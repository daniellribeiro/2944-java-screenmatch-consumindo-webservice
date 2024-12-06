package br.com.alura.desafios;

import com.google.gson.Gson;

public class ExemploGson {
    public static void main(String[] args) {
        String json = """
          {
            "idade" : 30,
            "email" : "joao@email.com",
            "cidade": "Araraquara",
            "estado": "SP"
          }
        """;

        Gson gson = new Gson();
        Pessoa pessoa = gson.fromJson(json, Pessoa.class);
        System.out.println(pessoa);
    }
}