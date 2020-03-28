package classes;

import Core.Main;
import managers.AdresManager;
import managers.ProductManager;

import java.util.ArrayList;

public class Bestelling {
    // Dit heeft elke bestelling
    private int klantId;
    private int leverancierId;
    private int geschatteLevertijdInDagen;

    // Dit verschilt per bestelling
    private ArrayList<Product> producten = new ArrayList<Product>();
    private float totaleStonks = 0.0f;

    // Constructor
    public Bestelling(int klantId, int leverancierId) {
        this.klantId = klantId;
        this.leverancierId = leverancierId;
    }

    // Voeg een product toe
    public void addProduct(Product product) {
        this.producten.add(product);
        totaleStonks += product.getPrijs();
    }

    // Verwijder een product
    public void removeProduct(Product product) {
        try {
            this.producten = ProductManager.verwijderProduct(this.producten, product.getNaam());
            totaleStonks -= product.getPrijs();
        } catch (Exception e) {
            System.out.println("Je probeerde een product te verwijderen die niet in de bestelling staat!");
        }
    }

    // Specificeer de geschatte levertijd in dagen
    public void setGeschatteLevertijdInDagen(int geschatteLevertijdInDagen) {
        this.geschatteLevertijdInDagen = geschatteLevertijdInDagen;
    }

    public ArrayList<Product> getProducten(){
        return this.producten;
    }
//
//    public Klant getKlantId() {
//        return this.klantId;
//    }
//
    public int getGeschatteLevertijdInDagen() {
        return this.geschatteLevertijdInDagen;
    }

    public float getTotaleStonks() {
        return this.totaleStonks;
    }
//
//    public Bedrijf getLeverancier() {
//        return this.leverancier;
//    }
}
