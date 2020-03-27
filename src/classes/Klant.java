package classes;

public class Klant {
    // Moet elke klant hebben
    private String naam;
    private String email;
    private Adres adres;
    private float vermogen;

    // Mag een klant hebben
    private String telefoonnummer;

    // Constructor
    public Klant(String naam, String email, Adres adres, float vermogen) {
        this.naam = naam;
        this.email = email;
        this.adres = adres;
        this.vermogen = vermogen;
    }

    // Geef de klant een telefoonnummer
    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public Adres getAdres(){
        return this.adres;
    }

    public String getNaam() {
        return this.naam;
    }

    public float getVermogen() {
        return this.vermogen;
    }

    public void betalen(float bedrag) {
        this.vermogen -= bedrag;
    }

    public String getEmail() {
        return this.email;
    }

    public String getTelefoonnummer() {
        return this.telefoonnummer;
    }
}
