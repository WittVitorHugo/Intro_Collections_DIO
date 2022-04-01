package br.com.dio.collections.list;

import java.util.*;

public class ExercicioPropostoTemperatura {

    static Scanner input = new Scanner(System.in);

    public static List<String> Meses() {
        List<String> meses = new ArrayList<>();
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

        List<Temperatura> temperaturaList = new ArrayList<>();

        System.out.println("Digite a temperatura de cada mês");

        for (int i=0; i<qtdMeses; i++) {
            System.out.print(meses.get(i) + ": ");
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

        System.out.format("Temperatura Média: %.2f", media);

        return media;
    }

    public static List<Temperatura> TemperaturasAcimaDaMedia(List<Temperatura> listaTemperaturas) {

        double media = MediaTemperatura(listaTemperaturas);

        List<Temperatura> temperaturasAcimaDaMedia = new ArrayList<>();

        Iterator<Temperatura> iterator = listaTemperaturas.iterator();
        while (iterator.hasNext()) {
            Temperatura next = iterator.next();
            if (next.getTemperatura() > media) temperaturasAcimaDaMedia.add(next);
        }

        temperaturasAcimaDaMedia.sort(new ComparadorTemperatura());

        return temperaturasAcimaDaMedia;
    }

    public static void main(String[] args) {

        System.out.print("Digite a quantidade de meses que deseja calcular a média: ");
        int qtdMeses = input.nextInt();


        List<Temperatura> temperaturaAcimaDaMedia = TemperaturasAcimaDaMedia(TemperaturaList(qtdMeses));

        System.out.println("\nTemperaturas acima da média: " + temperaturaAcimaDaMedia);

        for (int i=0; i<temperaturaAcimaDaMedia.size(); i++) {
            System.out.println(temperaturaAcimaDaMedia.get(i).getMes() + ": " + temperaturaAcimaDaMedia.get(i).getTemperatura());
        }


    }
}

class Temperatura {

    private final String mes;
    private final double temperatura;

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

class ComparadorTemperatura implements Comparator<Temperatura> {


    @Override
    public int compare(Temperatura t1, Temperatura t2) {
        return Double.compare(t2.getTemperatura(), t1.getTemperatura());
    }
}