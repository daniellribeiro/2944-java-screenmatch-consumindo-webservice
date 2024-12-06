package br.com.alura.desafios;

import java.util.Scanner;

public class ValidarSenha {
    public static void main(String[] args) {
        System.out.println("Digite sua senha:");
        Scanner leitura = new Scanner(System.in);
        String senha = leitura.nextLine();

        try{
            validarSenha(senha);
        }catch(SenhaInvalidaException e){
            System.out.println(e.getMessage());
        }
    }
    public static void validarSenha(String senha){
        String mensagem;
        if(senha.length() < 8){
            mensagem = "Precisa ter pelo menos 8 caracteres";
        }else if(!senha.matches(".*[A-Z].*")){
            mensagem = "Precisa ter pelo menos 1 letra maiscula";
        }else if(!senha.matches(".*[a-z].*")){
            mensagem = "Precisa ter pelo menos 1 letra minuscula";
        }
        else if(!senha.matches(".*[0-9].*")){
            mensagem = "Precisa ter pelo menos 1 numero";
        }else if(!senha.matches(".*[\\W_].*")){
            mensagem = "Precisa ter pelo menos 1 caracter especial";
        }else{
            System.out.println("Senha OK");
            return;
        }
        throw new SenhaInvalidaException(mensagem);
    }
}
