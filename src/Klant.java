public class Klant {
    // Moet elke klant hebben
    private String naam;
    private String email;
    private String adres;

    // Mag een klant hebben
    private String telefoonnummer;

    // Constructor
    public Klant(String naam, String email, String adres) {
        this.naam = naam;
        this.email = email;
        this.adres = adres;
    }

    // Geef de klant een telefoonnummer
    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
}
