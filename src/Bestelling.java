import java.util.ArrayList;

public class Bestelling {
    // Dit heeft elke bestelling
    private int id;
    private Klant klant;
    private Bedrijf leverancier;
    private int geschatteLevertijdInDagen;

    // Dit verschilt per bestelling
    private ArrayList<Product> producten = new ArrayList<Product>();

    // Constructor
    public Bestelling(int id, Klant klant, Bedrijf leverancier, int geschatteLevertijdInDagen) {
        this.id = id;
        this.klant = klant;
        this.leverancier = leverancier;
        // Berekening voor de levertijd
    }

    // Voeg een product toe
    public void addProduct(Product product) {
        this.producten.add(product);
    }
}
