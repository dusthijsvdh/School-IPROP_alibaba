package Core;

import classes.*;
import managers.BestellingManager;
import managers.MainManager;
import managers.ProductManager;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hier voegen we alle klanten, bedrijven en bestellingen aan toe.
        ArrayList<Klant> klanten = new ArrayList<Klant>();
        ArrayList<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
        ArrayList<Bestelling> bestellingen = new ArrayList<Bestelling>();

        // Klanten sjit

        Klant klant1 = new Klant("Thijs", "Yeet@yeet.com", new Adres("Nederland", "Zuid-Holland", "Alphen aan den Rijn", "Zeewinde", 90), 10000);
        Klant klant2 = new Klant("Henk", "Yeet@yeet.com", new Adres("Nederland", "Zuid-Holland", "Alphen aan den Rijn", "Zeewinde", 90), 10000);
        Klant klant3 = new Klant("Yayeet", "Yeet@yeet.com", new Adres("Nederland", "Zuid-Holland", "Alphen aan den Rijn", "Zeewinde", 90), 10000);

        klanten.add(klant1);
        klanten.add(klant2);
        klanten.add(klant3);

        Product product1 = new Product("Thijs <- komt van de black market", 0.1f);
        Product product2 = new Product("Kjoffie", 1.0f);
        Product product3 = new Product("Cocja cjola", 2.5f);
        Product product4 = new Product("Wjaterfjes", 12.0f);
        Product product5 = new Product("Pjiza Oven", 100f);

        Voorraad voorraad1 = new Voorraad();
        voorraad1.addProduct(product1);
        voorraad1.addProduct(product2);
        voorraad1.addProduct(product3);
        voorraad1.addProduct(product4);
        voorraad1.addProduct(product5);

        Bedrijf bedrijf1 = new Bedrijf("Epic Gamer Moments", voorraad1, new Adres("Nederland", "Zuid-Holland", "Alphen aan den Rijn", "Zeewinde", 90));

        product1 = new Product("Thijs <- komt van de black market", 0.01f);
        product2 = new Product("Kjoffie", 2.0f);
        product3 = new Product("Cocja cjola", 1.5f);
        product4 = new Product("Wjaterfjes", 15.0f);
        product5 = new Product("Pjiza Oven", 101f);

        voorraad1 = new Voorraad();
        voorraad1.addProduct(product1);
        voorraad1.addProduct(product2);
        voorraad1.addProduct(product3);
        voorraad1.addProduct(product4);
        voorraad1.addProduct(product5);

        Bedrijf bedrijf2 = new Bedrijf("Henk de Potvis Productions", voorraad1, new Adres("United States of Joe", "Zuid-Holland", "Alphen aan den Rijn", "Honk Honk", 90));

        product1 = new Product("Thijs <- komt van de black market", 0.02f);
        product2 = new Product("Kjoffie", 3.0f);
        product3 = new Product("Cocja cjola", 1.0f);
        product4 = new Product("Wjaterfjes", 18.0f);
        product5 = new Product("Pjiza Oven", 99f);

        voorraad1 = new Voorraad();
        voorraad1.addProduct(product1);
        voorraad1.addProduct(product2);
        voorraad1.addProduct(product3);
        voorraad1.addProduct(product4);
        voorraad1.addProduct(product5);

        Bedrijf bedrijf3 = new Bedrijf("De gelaarsde potvis", voorraad1, new Adres("United States of Joe", "Zuid-Holland", "Alphen aan den Rijn", "Honk Honk", 90));

        bedrijven.add(bedrijf1);
        bedrijven.add(bedrijf2);
        bedrijven.add(bedrijf3);


        // The real deal
        Klant klant = klanten.get(MainManager.welkeKlant(klanten));
        MainManager.clearScreen(false);


        ArrayList<Product> totaleVoorraad = MainManager.getTotaleVoorraad(bedrijven);
        ArrayList<Bedrijf> bedrijfsVoorraad = bedrijven;
//        ArrayList<Product> winkelwagen = MainManager.productenKiezen(klant, bedrijven);
        ArrayList<Product> winkelwagen = new ArrayList<Product>();
        ArrayList<Bedrijf> gekozenBedrijven = new ArrayList<Bedrijf>();
        String antwoord;
        Scanner s = new Scanner(System.in);
        do {
            Product gekozenProduct = MainManager.kiesProduct(klant, bedrijfsVoorraad);
            Bedrijf gekozenBedrijf = MainManager.kiesBedrijf(klant, bedrijfsVoorraad, gekozenProduct.getNaam());
            gekozenBedrijven.add(gekozenBedrijf);
            Product product = new Product("", 0.0f);
            for (int i = 0; i < bedrijfsVoorraad.size(); i++) {
                if (bedrijfsVoorraad.get(i).getNaam() == gekozenBedrijf.getNaam()) {
                    Voorraad voorraad = bedrijfsVoorraad.get(i).getVoorraad();
                    ArrayList<Product> bedrijfsProducten = voorraad.getProducten();
                    for (Product bedrijfProduct : bedrijfsProducten) {
                        if (bedrijfProduct.getNaam() == gekozenProduct.getNaam()) {
                            winkelwagen.add(bedrijfProduct);
                            ArrayList<Product> nieuweProducten = ProductManager.verwijderProduct(bedrijfsProducten, gekozenProduct.getNaam());
//                            voorraad.setProducten(nieuweProducten);
//                            bedrijfsVoorraad.get(i).setVoorraad(voorraad);
                        }
                    }
                }
            }
//            for (int i = 0; i < bedrijfsVoorraad.size(); i++) {
//                if (bedrijfsVoorraad.get(i).getNaam() == gekozenBedrijf.getNaam()) {
//                    Voorraad voorraad = bedrijfsVoorraad.get(i).getVoorraad();
//                    ArrayList<Product> producten = ProductManager.verwijderProduct(voorraad.getProducten(), gekozenProduct.getNaam());
//                    voorraad.setProducten(producten);
//                    bedrijfsVoorraad.get(i).setVoorraad(voorraad);
//                }
//            }
            System.out.print("Wilt u nog iets bestellen? (Y/N) : ");
            antwoord = s.nextLine().toLowerCase();
        } while (!antwoord.equals("n"));
        int klantId = 0;
        for (int i = 0; i < klanten.size(); i++) {
            if (klant.getEmail() == klanten.get(i).getEmail() && klant.getNaam() == klanten.get(i).getNaam()) {
                klantId = i;
            }
        }
        System.out.println(klantId);
        Bestelling bestelling = new Bestelling(klantId, gekozenBedrijven);
        for (Product product : winkelwagen) {
            bestelling.addProduct(product);
        }

        BestellingManager.bekijkBestelling(bestelling);


//        Product product = MainManager.kiesProduct(klant, bedrijven);
//        Bedrijf bedrijf = MainManager.kiesBedrijf(klant, bedrijven, product.getNaam());

//        Product product = MainManager.kiesProduct(klant, bedrijven);
//        System.out.println(product.getNaam());
//        Bedrijf bedrijf = MainManager.kiesBedrijf(klant, bedrijven, product.getNaam());
//        System.out.println(bedrijf.getNaam());
//        MainManager.printTotaleVoorraad(totaleVoorraad);
    }


}