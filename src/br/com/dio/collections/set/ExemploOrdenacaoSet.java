package br.com.dio.collections.set;

import java.util.*;

/**
 * Dados as seguintes informações sobre minhas séries favoritas
 * crie um conjunto e ordene este conjunto exibindo:
 * (nome-genero-tempo de episódio)
 *
 * Série 1 = nome: got, genero: fantasia, tempoEpisodio: 60
 * Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
 * Série 3 = nome: that '70s show, genero: comédia, tempoEpisodio: 25
 */

public class ExemploOrdenacaoSet {

    public static void main(String[] args) {

        //Ordem Aleatória
        System.out.println("Ordem Aleatória");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};

        for (Serie serie: minhasSeries) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem inserção
        System.out.println("\nOrdem inserção");

        Set<Serie> minhasSeries2 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comédia", 25));
        }};

        for (Serie serie: minhasSeries2) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem natural (TempoEpisodio)
        System.out.println("\nOrdem natural (TempoEpisodio)");
        Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries2);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());

        //Ordem Nome/Gênero/TempoEpisodio

        System.out.println("\nOrdem Nome/Gênero/TempoEpisodio");
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries4.addAll(minhasSeries3);

        for (Serie serie: minhasSeries4) System.out.println(serie.getNome() + " - "
                + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }
}

