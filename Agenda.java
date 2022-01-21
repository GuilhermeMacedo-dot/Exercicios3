package com.aula.exercicios.exercici4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Agenda {

    public static void main(String[] args) {

        List<Contato> contatos = new ArrayList<Contato>();
        Scanner scan = new Scanner(System.in);


        Boolean sair = false;

        while (sair == false) {

            System.out.println("Escolha a opção: ");
            System.out.println("1- Inserir ");
            System.out.println("2- Listar ");
            System.out.println("3- Excluir ");
            String opcao = scan.nextLine();

            if ("1".equals(opcao)){
                Contato contato = criarContato();
                contatos.add(contato);
            }
            if ("2".equals(opcao)){
                cuspirTela(contatos);
            }



            System.out.println("Deseja continuar?");
            String resposta = scan.nextLine();

            if ("n".equals(resposta)) {
                sair = true;
            }

        }
        Path caminho = Paths.get("C:\\Users\\Gui\\OneDrive\\Desktop\\teste.txt");
        String texto = "";

        for (Contato c : contatos) {
            texto += "Nome: " + c.getNome() + " - Telefone: " + c.getTel() + "\n";
        }

        byte[] textoEmByte = texto.getBytes();
        try {
            Files.write(caminho, textoEmByte);
        } catch (Exception erro) {

        }
                cuspirTela(contatos);

    }

    public static Contato criarContato(){


        Scanner scan = new Scanner(System.in);

        Contato contato1 = new Contato();

        System.out.println("Nome: ");
        String nomeLido = scan.nextLine();
        contato1.setNome(nomeLido);


        System.out.println("Telefone: ");
        String tel1 = scan.nextLine();
        contato1.setTel(tel1);


        return contato1;

    }


    public static void cuspirTela(List<Contato> contatos1){

        for (Contato a : contatos1) {
            System.out.println(a.getNome() + " " + a.getTel());
        }
    }




}