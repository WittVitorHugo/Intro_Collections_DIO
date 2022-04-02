package br.com.dio.collections.list;

import java.util.*;

public class ExercicioPropostoCrime {

    static Scanner input = new Scanner(System.in);

    public static List<String> Respostas() {
        List<String> respostas = new ArrayList<>();

        System.out.println("Digite S para 'Sim'e N para 'Não'!");

        System.out.println("1-Telefonou para vítima?");
        respostas.add(input.nextLine());
        System.out.println("2-Esteve no local do crime?");
        respostas.add(input.nextLine());
        System.out.println("3-Mora perto da vítima?");
        respostas.add(input.nextLine());
        System.out.println("4-Devia para a vítima?");
        respostas.add(input.nextLine());
        System.out.println("5-Já trabalhou com a vítima?");
        respostas.add(input.nextLine());

        System.out.println(respostas);

        return respostas;
    }

    public static int Classifica(List<String> listaRespostas) {

        List<String> listaDeRetorno = new ArrayList<>();

        Iterator<String> respostas = listaRespostas.iterator();
        while(respostas.hasNext()) {
            String next = respostas.next();
            if(Objects.equals(next, "s")) listaDeRetorno.add(next);
        }

        return listaDeRetorno.size();
    }

    public static void main(String[] args) {

        int classificacao = Classifica(Respostas());

        switch (classificacao) {
            case 0:
            case 1:
                System.out.println("Inocente");
                break;
            case 2:
                System.out.println("Suspeito(a)");
                break;
            case 3:
            case 4:
                System.out.println("Cúmplice");
                break;
            case 5:
                System.out.println("Assassino(a)");
                break;
            default:
                System.out.println("Sem classificação!");
        }
    }
}
