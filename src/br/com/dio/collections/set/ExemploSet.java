package br.com.dio.collections.set;

import java.sql.SQLOutput;
import java.util.*;

public class ExemploSet {

    public static void main(String[] args) {

        //Dada uma lista com 7 notas de um aluno [7d, 8.5, 9.3, 5d, 7d, 0d, 3.6]

        System.out.println("Crie um conjunto e adicione as notas");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        System.out.println(notas);

        // Confira se a nota 5.0 está no conjunto
        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        // Exiba a menor nota
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        // Exiba a maior nota
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        // Exiba a soma dos valores
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()) {
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        // Média das notas
        System.out.println("Média das notas: " + soma/ notas.size());

        // Remover a nota 0
        System.out.println("Remover a nota 0.0");
        notas.remove(0d);
        System.out.println(notas);

        // Remova notas menores que 7
        System.out.println("Remova notas menores que 7");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()) {
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        // Exiba as notas na ordem em foram informadas
        System.out.println("Exiba as notas na ordem em foram informadas");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        System.out.println(notas2);

        // Exiba as notas na ordem crescente
        System.out.println("Exiba as notas na ordem crescente");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);

        // Apague todo o conjunto
        System.out.println("Apague todo o conjunto");
        notas3.clear();
        System.out.println(notas3);

        // Confira se o conjunto está vazio
        System.out.println("Confira se o conjunto está vazio: " + notas3.isEmpty());


    }
}
