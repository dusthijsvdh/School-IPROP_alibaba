import java.util.ArrayList;

public class Voorraad {
    private ArrayList<Product> producten = new ArrayList<Product>();

    // Voeg een product toe
    public void addProduct(Product product) {
        this.producten.add(product);
    }

    // Haal de lijst met producten toe
    public ArrayList<Product> getProducten() {
        return this.producten;
    }
}
