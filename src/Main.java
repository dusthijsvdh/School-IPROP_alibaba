import classes.*;

import managers.BestellingManager;
import managers.Shopping;
import managers.VoorraadManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Product product1 = new Product("Le intern developer", 2000);
//        Product product2 = new Product("Le aardbeien", 15);
//        Product product3 = new Product("Le aardappels", 10);
//
//        Voorraad bedrijfVoorraad = new Voorraad();
//        bedrijfVoorraad.addProduct(product1);
//        bedrijfVoorraad.addProduct(product2);
//        bedrijfVoorraad.addProduct(product2);
//        bedrijfVoorraad.addProduct(product2);
//        bedrijfVoorraad.addProduct(product3);
//
//        VoorraadManager.bekijkVoorraad(bedrijfVoorraad);
//
//        Klant klant = new Klant("Thijs", "Yeet@yeet.com", new Adres("Nederland", "Zuid-Holland", "Alphen aan den Rijn", "Zeewinde", 90), 10000);
//        Bedrijf bedrijf = new Bedrijf("Yeetco", bedrijfVoorraad, new Adres("Nederland", "Zuid-Holland", "Alphen aan den Rijn", "yeetlaan", 69));
//
//        Bestelling bestelling = new Bestelling(1, klant, bedrijf);
//        bestelling.addProduct(product1);
//        bestelling.addProduct(product2);
//        bestelling.addProduct(product3);
//
//        BestellingManager.bekijkBestelling(bestelling);
//
//        System.out.println("Dit kunnen we kopen: ");
//        ArrayList<Product> kopen = BestellingManager.kanKopen(bestelling, bedrijfVoorraad);
//        for(Product product : kopen) {
//            System.out.println(product.getNaam());
//        }
//
//        clearScreen();
//        BestellingManager.koopProducten(bestelling, bedrijfVoorraad);
        Shopping.startShopping();
    }

    public static void clearScreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Druk op enter om door te gaan : ");
        scanner.nextLine();
        for (int i = 0; i < 200; i++) {
            System.out.println("");
        }
    }
}