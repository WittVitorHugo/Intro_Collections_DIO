package br.com.dio.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Dadas as seguintes informações sobre gatos,
 * crie uma lista e ordene esta lista exibino:
 * (nome - idade - cor)
 */

public class OrdenacaoList {

    public static void main(String[] args) {

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("Shikamaru", 2, "Malhado"));
            add(new Gato("Shikamaru", 24, "Malhado"));
            add(new Gato("Harumi", 12, "Amarelo"));
            add(new Gato("Harumi", 36, "Malhado"));
            add(new Gato("Nezuko", 18, "Vaquinha"));
        }};

        System.out.println(meusGatos);

        //Ordem de inserção
        System.out.println("\n--\tOrdem de inserção\t--");
        System.out.println(meusGatos);

        //Ordem aleatória
        System.out.println("\n--\tOrdem aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        //Ordem natural
        System.out.println("\n--\tOrdem natural (Nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        //Ordem idade
        System.out.println("\n--\tOrdem idade\t--");
        //Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        //Ordem cor
        System.out.println("\n--\tOrdem cor\t--");
        //Collections.sort(meusGatos, new ComparatorCor());
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        //Ordem cor
        System.out.println("\n--\tOrdem Nome Cor Idade\t--");
        //Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        meusGatos.sort(new ComparatorNomeCorIdade());
        System.out.println(meusGatos);

    }
}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}
class ComparatorNomeCorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome;

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor;

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}