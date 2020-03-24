public class Product {
    // Dit heeft elk product
    private String naam;
    private float prijs;

    // Dit kan een product hebben
    private float gewicht;

    // Constructor
    public Product(String naam, float prijs) {
        this.naam = naam;
        this.prijs = prijs;
    }

    // Defineer het gewicht van het product
    public void setGewicht(float gewicht) {
        this.gewicht = gewicht;
    }
}
