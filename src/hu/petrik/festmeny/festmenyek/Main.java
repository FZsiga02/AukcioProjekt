package hu.petrik.festmeny.festmenyek;

import javax.swing.plaf.basic.BasicMenuBarUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;

public class Main {

    static List<Festmeny> festmenyek;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        festmenyek = new ArrayList<>();
        festmenyek.add(new Festmeny("Mona Lisa", "Leonardo da Vinci", "Reneszánsz"));
        festmenyek.add(new Festmeny("A sikoly", "Edvard Munch", "Expresszionizmus"));

        System.out.print("Kérem adja meg, hogy hány festményt adjon hozzá a listához: ");
        int darab = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < darab; i++) {
            System.out.print("Festmény címe: ");
            String cim = sc.nextLine();
            System.out.print("Festő neve: ");
            String nev = sc.nextLine();
            System.out.print("Festmény stílusa: ");
            String stilus = sc.nextLine();
            festmenyek.add(new Festmeny(cim, nev, stilus));
        }

        String fajlNev = "festmenyek.csv";

        try {
            beolvas("festmenyek.csv");
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        System.out.println(festmenyek);
    }

    public static void beolvas(String fajlNev) throws IOException {
        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String sor = br.readLine();
        while(sor != null && !sor.equals("")){
            String[] tomb = sor.split(";");
            Festmeny festmeny = new Festmeny(tomb[1], tomb[0], tomb[2]);
            festmenyek.add(festmeny);
            sor = br.readLine();
        }
        br.close();
        fr.close();
    }
}
