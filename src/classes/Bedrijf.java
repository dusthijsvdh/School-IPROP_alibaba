package classes;

public class Bedrijf {
    // Dit heeft elk bedrijf
    private String naam;
    private Voorraad voorraad;
    private Adres adres;

    // Constructor
    public Bedrijf(String naam, Voorraad voorraad, Adres adres) {
        this.naam = naam;
        this.voorraad = voorraad;
        this.adres = adres;
    }

    // Krijg de voorraad
    public Voorraad getVoorraad() {
        return this.voorraad;
    }
}
