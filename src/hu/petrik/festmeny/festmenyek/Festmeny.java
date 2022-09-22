package hu.petrik.festmeny.festmenyek;

import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    private int licitekSzama;
    private int legmagasabbLicit;
    private LocalDateTime legutolsoLicitIdeje;
    private boolean elkelt;

    public Festmeny(String cim, String festo, String stilus) {
        this.cim = cim;
        this.festo = festo;
        this.stilus = stilus;
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
}
