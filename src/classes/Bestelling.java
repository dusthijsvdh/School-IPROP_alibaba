package classes;

import managers.AdresManager;
import managers.ProductManager;

import java.util.ArrayList;

public class Bestelling {
    // Dit heeft elke bestelling
    private int id;
    private Klant klant;
    private Bedrijf leverancier;
    private int geschatteLevertijdInDagen;

    // Dit verschilt per bestelling
    private ArrayList<Product> producten = new ArrayList<Product>();

    private float totaleStonks = 0.0f;

    // Constructor
    public Bestelling(int id, Klant klant, Bedrijf leverancier) {
        this.id = id;
        this.klant = klant;
        this.leverancier = leverancier;
        this.geschatteLevertijdInDagen = AdresManager.BerekenLevertijd(leverancier.getAdres(), klant.getAdres());
    }

    // Voeg een product toe
    public void addProduct(Product product) {
        this.producten.add(product);
        totaleStonks += product.getPrijs();
    }

    public void removeProduct(Product product) {
        try {
            this.producten = ProductManager.verwijderProduct(this.producten, product.getNaam());
        } catch (Exception e) {
            System.out.println("Je probeerde een product te verwijderen die niet in de bestelling staat!");
        }
    }

    public ArrayList<Product> getProducten(){
        return producten;
    }

    public Klant getKlant() {
        return klant;
    }

    public int getGeschatteLevertijdInDagen() {
        return geschatteLevertijdInDagen;
    }


}
