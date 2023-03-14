import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String[] lista = new String[10];
        for(int i=0;i<10;i++) {
            lista[i] = "ingredient" + String.valueOf(i);
        }
        Aliment aliment1 = new Aliment(1042024L, lista, 35.04, 155.4);

        Carne carne1 = new Carne(13112024L, lista, 14.5);
        Cereale cereale1 = new Cereale(22022024L, lista, 8.5);
        Lapte lapte1 = new Lapte(4052024L, lista, 6.04);

        List<Aliment> l_alimente = new ArrayList<>();
        l_alimente.add(aliment1);
        l_alimente.add(carne1);
        l_alimente.add(lapte1);
        l_alimente.add(cereale1);

        List<Aliment> l_sortat = l_alimente.stream().sorted(Comparator.comparingDouble(Aliment::getKcal)).toList();

        for(Aliment it : l_sortat)
        {
            System.out.println(it);
        }

    }
}
