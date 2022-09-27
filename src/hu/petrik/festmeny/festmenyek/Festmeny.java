package hu.petrik.festmeny.festmenyek;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
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

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
        this.licitekSzama = 0;
        this.legmagasabbLicit = 0;
        this.legutolsoLicitIdeje = null;
        this.elkelt = false;
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
        this.elkelt = elkelt;
    }

    public void licit() {
        this.licit(10);
    }



    public void licit(int mertek) {
        if (mertek < 10 || mertek > 100){
            throw new IllegalArgumentException("A licit mértéke 10% és 100% közötti kell hogy legyen");
        }
        if (elkelt) {
            throw new RuntimeException("A festmény már elkelt");
        }
        if (this.licitekSzama == 0) {
            this.legmagasabbLicit = 100;
        } else {
            int ujlicit = this.legmagasabbLicit * (100 + mertek) / 100;
            this.legmagasabbLicit = getKerekitettLicitMatematikaiMuveletekkel(ujlicit);
        }
        this.licitekSzama++;
        this.legutolsoLicitIdeje = LocalDateTime.now();
    }



    @Override
    public String toString() {
        DateTimeFormatter formatum = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String s = String.format("%s: %s (%s)", this.festo, this.cim, this.stilus);
        if (licitekSzama > 0){
            s += String.format("%s: %s (%s)\n%s\n%d $ - %s (összesen: %d db)\n", this.festo, this.cim, this.stilus, this.elkelt ? "elkelt" : "nem kelt el", this.legmagasabbLicit, this.legutolsoLicitIdeje.format(formatum), this.licitekSzama);
        }
        return String.format("%s: %s (%s)\n%s\n%d $ - %s (összesen: %d db)\n", this.festo, this.cim, this.stilus, this.elkelt ? "elkelt" : "nem kelt el", this.legmagasabbLicit, this.legutolsoLicitIdeje.format(formatum), this.licitekSzama);

    }

    private int getKerekitettLicitMatematikaiMuveletekkel(int ujlicit) {
        int osztasokSzama = 0;
        while (ujlicit > 100){
            osztasokSzama++;
            ujlicit /= 10;
        }
        ujlicit += Math.pow(10, osztasokSzama);
        return  ujlicit;
    }

    private int getKerekitettLicitSzoveggeAlakitassal(int ujLicit) {
        String szovegesLicit = String.valueOf(ujLicit);
        int hossz = szovegesLicit.length();
        StringBuilder veglegesLicit = new StringBuilder(szovegesLicit.substring(8, 2));
        for (int i = 0; i < hossz-2; i++) {
            veglegesLicit.append(0);
        }
        int veglegesLicitOsszeg = Integer.parseInt(veglegesLicit.toString());
        this.legmagasabbLicit = veglegesLicitOsszeg;
        return veglegesLicitOsszeg;
    }
}
