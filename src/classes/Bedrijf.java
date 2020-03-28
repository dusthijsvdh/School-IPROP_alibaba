package classes;

import java.util.ArrayList;

public class Bedrijf {
    // Dit heeft elk bedrijf
    private String naam;
    private Voorraad voorraad;
    private Adres adres;
    private float omzet;

    // Constructor
    public Bedrijf(String naam, Voorraad voorraad, Adres adres) {
        this.naam = naam;
        this.voorraad = voorraad;
        this.adres = adres;
        this.omzet = 0.0f;
    }

    // Krijg de voorraad
    public Voorraad getVoorraad() {
        return this.voorraad;
    }

    public void setVoorraad(Voorraad voorraad) {
        this.voorraad = voorraad;
    }

    public void setProducten(ArrayList<Product> producten) {
        this.voorraad.setProducten(producten);
    }

    public Adres getAdres() {
        return this.adres;
    }

    public void addStonks(float bedrag) {
        this.omzet += bedrag;
    }

    public String getNaam() {
        return this.naam;
    }
}
