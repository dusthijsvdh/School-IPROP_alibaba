public class Bedrijf {
    // Dit heeft elk bedrijf
    private String naam;
    private Voorraad voorraad;
    private String locatie;

    // Constructor
    public Bedrijf(String naam, Voorraad voorraad, String locatie) {
        this.naam = naam;
        this.voorraad = voorraad;
        this.locatie = locatie;
    }

    // Krijg de voorraad
    public Voorraad getVoorraad() {
        return this.voorraad;
    }
}
