package hu.petrik.festmeny.festmenyek;

import javax.swing.plaf.basic.BasicMenuBarUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {

    private static List<Festmeny> festmenyek = new ArrayList<>();
    public static void main(String[] args) {

        Festmeny festmeny = new Festmeny("Galambok a Hősök terén", "Gipsz Jakab", "Expresszionizmus");
        Festmeny festmeny2 = new Festmeny("Budapest éjszaka", "Teszt Elek", "Expresszionizmus");
        festmenyek.add(festmeny);
        festmenyek.add(festmeny2);
        try{
            festmenyekFelveteleKonzolrol();
        } catch (InputMismatchException e){
            System.out.println("Nem megfelelő számot adott meg, nem lesz felvéve festmény");
        }
        String fajNev = "festmenyek.csv";
        try{
            festmenyekBeolvasasaFajlbol("festmenyek.csv");
        } catch(FileNotFoundException e){
            System.out.printf("Hiba történt a beolvasáskor a(z) %s fájl nem található", fajNev);
        } catch(IOException e){
            System.out.println("Ismeretlen hiba történt a fájl olvasása során");
            e.printStackTrace();
        }
        veletlenszeruLicit();
        konzolosLicitalas();
        for (Festmeny f:festmenyek){
            System.out.println(f);
        }




        /*for (int i = 0; i < 50; i++) {
            festmeny.licit();
        }
        System.out.println(festmeny.getLegmagasabbLicit());*/


    }

    private static void konzolosLicitalas() {
        Scanner sc = new Scanner(System.in);
        int festmenyIndex = -1;
        while(festmenyIndex == 0){
            System.out.print("Kérem adja meg a festmény sorszámát amire licitálna (kilépéshez 0-t adjon meg):");
            festmenyIndex = sc.nextInt();
            if (festmenyIndex < 0){
                System.out.println("A sorszám nem lehet negatív");
            }else if (festmenyIndex>festmenyek.size()){
                System.out.printf("Érvénytelen sorszám a listában csak %d festmény található\n", festmenyek.size());
            }else if (festmenyIndex>0){
                if (festmenyek.get(festmenyIndex-1).getElkelt()){
                    System.out.println("A festmány már elkelt");
                }else{

                }
            }else{
                System.out.println("A licitálás lezárult");
            }
        }
    }

    private static void veletlenszeruLicit() {
        for (int i = 0; i < 20; i++) {
            int festmenyIndex = (int)(Math.random()*festmenyek.size());
            festmenyek.get(festmenyIndex).licit();
        }
    }

    private static void festmenyekBeolvasasaFajlbol(String fajlNev) throws IOException {
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

    private static void festmenyekFelveteleKonzolrol(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Adja meg, hogy hány festményt szeretne felvenni: ");
        int db = sc.nextInt();
        for (int i = 0; i < db; i++) {
            System.out.printf("Kérem adja meg a(z) %d festmény címét: ",(i+1));
            String cim = sc.nextLine();
            System.out.printf("Kérem adja meg a(z) %d festő nevét: ",(i+1));
            String festo = sc.nextLine();
            System.out.printf("Kérem adja meg a(z) %d festmény stílusát:", (i+1));
            String stilus = sc.nextLine();
            Festmeny festmeny = new Festmeny(cim, festo, stilus);
            festmenyek.add(festmeny);
        }
    }
}
