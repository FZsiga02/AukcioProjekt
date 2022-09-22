package hu.petrik.festmeny.festmenyek;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    Scanner sc = new Scanner(System.in);

    public Festmeny(String cim, String festo, String stilus, int licitekSzama, int legmagasabbLicit, boolean elkelt) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = licitekSzama;
        this.legmagasabbLicit = legmagasabbLicit;
        this.elkelt = elkelt;
    }

    public String getFesto() {
        return festo;
    }

    public String getStilus() {
        return stilus;
    }

    public int getLicitekSzama() {
        return licitekSzama;
    }

    public int getLegmagasabbLicit() {
        return legmagasabbLicit;
    }

    public LocalDateTime getLegutolsoLicitIdeje() {
        return legutolsoLicitIdeje;
    }

    public boolean getElkelt() {
        return elkelt;
    }

    public void setElkelt(boolean elkelt) {
        return;
    }

    public void licit() {
        if (elkelt) {
            System.out.println("Hiba! A festmény már elkelt!");
        } else if (licitekSzama == 0) {
            legmagasabbLicit = 100;
            licitekSzama++;
            legutolsoLicitIdeje = LocalDateTime.now();
        } else {
            legmagasabbLicit += legmagasabbLicit * 0.1;
            licitekSzama++;
            legutolsoLicitIdeje = LocalDateTime.now();
        }
    }

    public void licit(int mertek){
        if (elkelt) {
            System.out.println("Hiba! A festmény már elkelt!");
        } else if (licitekSzama == 0) {
            legmagasabbLicit = 100;
            licitekSzama++;
            legutolsoLicitIdeje = LocalDateTime.now();
        } else {
            System.out.print("Kérem adja meg a % mértékét");
            int szazalek = sc.nextInt();
            if (szazalek <10 || szazalek > 100){
                System.out.println("Hiba! A megadott % nem 10 és 100 között van!");
            } else {
                legmagasabbLicit += legmagasabbLicit * (szazalek/100);
                licitekSzama++;
                legutolsoLicitIdeje = LocalDateTime.now();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s (%s)\r\n%s\r\n%d $ - %s (összesen: %d db)\r\n", this.festo, this.cim, this.stilus, this.elkelt, this.legmagasabbLicit, this.legutolsoLicitIdeje, this.licitekSzama);
    }
}
