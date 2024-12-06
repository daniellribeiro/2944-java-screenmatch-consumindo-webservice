package br.com.alura.desafios;

import java.io.IOException;
import java.util.Scanner;

public class UsuarioGithub {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um usuario do GITHUB: ");
        var busca = leitura.nextLine();

        try {
            String resposta = APIConsulta.consulta(APIConsulta.montarEndereco("UsuarioGithub", busca));
            System.out.println(resposta);
        }catch(ErroConsultaGitHubException e){
            System.out.println(e.getMessage());
        }catch (IOException | InterruptedException e) {
            System.out.println("Opss… Houve um erro durante a consulta à API do GitHub.");
            e.printStackTrace();
        }
    }
}
