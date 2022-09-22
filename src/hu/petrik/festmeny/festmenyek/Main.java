package hu.petrik.festmeny.festmenyek;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Festmeny f1 = new Festmeny("Mona Lisa", "Leonardo da Vinci", "Reneszánsz", 0, 0, false);
        Festmeny f2 = new Festmeny("A sikoly", "Edvard Munch", "Expresszionizmus", 0, 0, false);
        Festmeny[] festmenyek = {f1,f2};

        System.out.println(Arrays.toString(festmenyek));
    }
}