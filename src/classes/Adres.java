package classes;

public class Adres {
    // De eigenschappen van een adres
    public String land;
    public String staat;
    public String stad;
    public String straat;
    public int huisnummer;

    // Constructor
    public Adres(String land, String staat, String stad,String straat, int huisnummer) {
        this.land = land;
        this.staat = staat;
        this.stad = stad;
        this.straat = straat;
        this.huisnummer = huisnummer;
    }
}
