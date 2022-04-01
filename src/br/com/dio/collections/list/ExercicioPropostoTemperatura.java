package br.com.dio.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioPropostoTemperatura {

    static Scanner input = new Scanner(System.in);

    public static List<String> Meses() {
        List<String> meses = new ArrayList<String>();
        meses.add("Janeiro");
        meses.add("Fevereiro");
        meses.add("Março");
        meses.add("Abril");
        meses.add("Maio");
        meses.add("Junho");
        meses.add("Julho");
        meses.add("Agosto");
        meses.add("Setembro");
        meses.add("Outubro");
        meses.add("Novembro");
        meses.add("Dezembro");
         return meses;
    }

    public static List<Temperatura> TemperaturaList(int qtdMeses) {

        List<String> meses = Meses();

        List<Temperatura> temperaturaList = new ArrayList<Temperatura>();

        System.out.println("Digite a temperatura de cada mês");

        for (int i=0; i<qtdMeses; i++) {
            System.out.print(meses.get(i).toString() + ": ");
            Double temperatura = input.nextDouble();
            temperaturaList.add(new Temperatura(temperatura, meses.get(i)));
        }

        return temperaturaList;
    }

    public static double MediaTemperatura(List<Temperatura> listaTemperaturas) {

        Iterator<Temperatura> iterator = listaTemperaturas.iterator();
        Double soma = 0.0;
        while (iterator.hasNext()) {
            Temperatura next = iterator.next();
            soma += next.getTemperatura();
        }

        double media = soma/listaTemperaturas.size();

        System.out.println("Temperatura Média: " + media);

        return media;
    }

    public static List<Temperatura> TemperaturasAcimaDaMedia(List<Temperatura> listaTemperaturas) {

        double media = MediaTemperatura(listaTemperaturas);

        Iterator<Temperatura> iterator = listaTemperaturas.iterator();
        while (iterator.hasNext()) {
            Temperatura next = iterator.next();
            if (next.getTemperatura() <= media) listaTemperaturas.remove(next);
        }

        return listaTemperaturas;
    }

    public static void main(String[] args) {

        System.out.print("Digite a quantidade de meses que deseja calcular a média: ");
        int qtdMeses = input.nextInt();


        List<Temperatura> temperaturaAcimaDaMedia = TemperaturasAcimaDaMedia(TemperaturaList(qtdMeses));

        System.out.println("Temperaturas acima da média: " + temperaturaAcimaDaMedia);

        for (int i=0; i<temperaturaAcimaDaMedia.size(); i++) {
            System.out.println(temperaturaAcimaDaMedia.get(i).getMes());
        }


    }
}

class Temperatura {

    private String mes;
    private double temperatura;

    public Temperatura(double temperatura, String mes) {
        this.temperatura = temperatura;
        this.mes = mes;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public String getMes() {
        return mes;
    }

    @Override
    public String toString() {
        return "{" +
                "temperatura=" + temperatura +
                ", mes='" + mes + '\'' +
                '}';
    }
}
