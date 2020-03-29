package Core;

import classes.*;
import managers.AdresManager;
import managers.BestellingManager;
import managers.MainManager;
import managers.ProductManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Hier voegen we alle klanten, bedrijven en bestellingen aan toe.
        ArrayList<Klant> klanten = new ArrayList<Klant>();
        ArrayList<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
        ArrayList<Bestelling> bestellingen = new ArrayList<Bestelling>();

        // Klanten sjit

        Klant klant1 = new Klant("Thijs", "Yeet@yeet.com", new Adres("Nederland", "Zuid-Holland", "Alphen aan den Rijn", "Zeewinde", 90), 10);
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

        product1 = new Product("Mondkapjes", 1.0f);
        product2 = new Product("toetsenbord", 100.0f);
        product3 = new Product("100 pennen - Blauw", 10.0f);
        product4 = new Product("Wjaterfjes", 16.0f);
        product5 = new Product("Kjoffie", 1.0f);

        voorraad1 = new Voorraad();
        voorraad1.addProduct(product1);
        voorraad1.addProduct(product2);
        voorraad1.addProduct(product3);
        voorraad1.addProduct(product4);
        voorraad1.addProduct(product5);

        Bedrijf alibaba = new Bedrijf("Alibaba", voorraad1, new Adres("Verenigde Koningkrijk", "London", "Davidson Building", "Southampton", 5));

        bedrijven.add(bedrijf1);
        bedrijven.add(bedrijf2);
        bedrijven.add(bedrijf3);
        bedrijven.add(alibaba);

        Scanner sc = new Scanner(System.in);
        System.out.println("Welkom bij alibaba!");
        while (true) {
            System.out.println("Om de voorraad te bekijken type: voorraad");
            System.out.println("Om te bestellen type: bestellen");
            System.out.println("Als u het programma wilt sluiten type: exit");
            System.out.print("Wat wilt u doen: ");
            String antwoord = sc.nextLine().toLowerCase();
            if (antwoord.equals("voorraad")) {
                System.out.println("U wilt de voorraad bekijken.");
                MainManager.clearScreen(true);
                MainManager.voorraadBekijken(bedrijven);
            } else if (antwoord.equals("bestellen")) {
                System.out.println("U wilt winkelen");
                MainManager.clearScreen(true);
                Klant klant = klanten.get(MainManager.welkeKlant(klanten));
                MainManager.clearScreen(false);


                ArrayList<Product> totaleVoorraad = MainManager.getTotaleVoorraad(bedrijven);
                ArrayList<Bedrijf> bedrijfsVoorraad = bedrijven;

                if (totaleVoorraad.isEmpty()) {
                    System.out.println("Sorry voor het ongemak. Helaas is er geen vooraad meer.");
                } else {
                    // De gekozen producten en hun bedrijven
                    ArrayList<Product> winkelwagen = new ArrayList<Product>();
                    ArrayList<Bedrijf> gekozenBedrijven = new ArrayList<Bedrijf>();

                    antwoord = "";
                    Scanner s = new Scanner(System.in);
                    do {
                        MainManager.clearScreen(false);
                        Product gekozenProduct = MainManager.kiesProduct(klant, bedrijfsVoorraad);
                        Bedrijf gekozenBedrijf = MainManager.kiesBedrijf(klant, bedrijfsVoorraad, gekozenProduct.getNaam());
                        gekozenBedrijven.add(gekozenBedrijf);
                        Product product = new Product("", 0.0f);
                        for (int i = 0; i < bedrijfsVoorraad.size(); i++) {
                            if (bedrijfsVoorraad.get(i).getNaam() == gekozenBedrijf.getNaam()) {
                                Voorraad voorraad = bedrijfsVoorraad.get(i).getVoorraad();
                                ArrayList<Product> bedrijfsProducten = voorraad.getProducten();
                                Product toRemove = null;
                                for (Product bedrijfProduct : bedrijfsProducten) {
                                    if (bedrijfProduct.getNaam() == gekozenProduct.getNaam()) {
                                        winkelwagen.add(bedrijfProduct);
                                        toRemove = bedrijfProduct;
                                    }
                                }
                                bedrijfsProducten.remove(toRemove);
                            }
                        }
                        System.out.print("Wilt u nog iets bestellen? (Y/N) : ");
                        antwoord = s.nextLine().toLowerCase();
                    } while (!antwoord.equals("n"));

                    MainManager.clearScreen(false);

                    int klantId = 0;
                    for (int i = 0; i < klanten.size(); i++) {
                        if (klant.getEmail() == klanten.get(i).getEmail() && klant.getNaam() == klanten.get(i).getNaam()) {
                            klantId = i;
                        }
                    }
                    Bestelling bestelling = new Bestelling(klantId, gekozenBedrijven);
                    for (Product product : winkelwagen) {
                        bestelling.addProduct(product);
                    }

                    ArrayList<Integer> bedrijfIds = BestellingManager.bedrijfNaarId(bedrijven, gekozenBedrijven);
                    ArrayList<Integer> levertijden = new ArrayList<Integer>();
                    for (Integer bedrijfId : bedrijfIds) {
                        Adres bedrijfAdres = bedrijven.get(bedrijfId).getAdres();
                        Adres klantAdres = klanten.get(klantId).getAdres();
                        levertijden.add(AdresManager.BerekenLevertijd(bedrijfAdres, klantAdres));
                    }
                    bestelling.setGeschatteLevertijdInDagen(Collections.max(levertijden));

                    // Laat de bestelling zien
                    BestellingManager.bekijkBestelling(bestelling);

                    // Kijk of de klant genoeg geld heeft.
                    if (BestellingManager.heeftGenoegGeld(klanten, bestelling)) {
                        if (BestellingManager.wilKopen()) {
                            klanten.get(klantId).betalen(bestelling.getTotaleStonks());
                            for (int i = 0; i < bestelling.getProducten().size(); i++) {
                                // Doe de betalingen
                                Product currentProduct = bestelling.getProducten().get(i);
                                int currentBedrijfId = bedrijfIds.get(i);
                                bedrijven.get(currentBedrijfId).addStonks(currentProduct.getPrijs());

                                // Haal de producten uit de voorraaden.
                                Voorraad voorraad = bedrijven.get(currentBedrijfId).getVoorraad();
                                ArrayList<Product> bedrijfsProducten = voorraad.getProducten();
                                Product toRemove = null;
                                for (Product bedrijfsProduct : bedrijfsProducten) {
                                    if (bedrijfsProduct.getNaam() == currentProduct.getNaam()) {
                                        toRemove = bedrijfsProduct;
                                    }
                                }
                                bedrijfsProducten.remove(toRemove);
                                voorraad.setProducten(bedrijfsProducten);
                                bedrijven.get(currentBedrijfId).setVoorraad(voorraad);
                            }
                            System.out.println("Uw bestelling is onderweg!");
                        }
                    }
                }
            } else if (antwoord.equals("exit")) {
                System.out.println("Bedankt voor het gebruiken van ons programma!\n tot een volgende keer!");
                MainManager.clearScreen(true);
                break;
            } else {
                System.out.println("Dat commando wordt niet herkend.");
                MainManager.clearScreen(true);
            }
        }
//        // The real deal
//        Klant klant = klanten.get(MainManager.welkeKlant(klanten));
//        MainManager.clearScreen(false);
//
//
//        ArrayList<Product> totaleVoorraad = MainManager.getTotaleVoorraad(bedrijven);
//        ArrayList<Bedrijf> bedrijfsVoorraad = bedrijven;
//
//        // De gekozen producten en hun bedrijven
//        ArrayList<Product> winkelwagen = new ArrayList<Product>();
//        ArrayList<Bedrijf> gekozenBedrijven = new ArrayList<Bedrijf>();
//
//        String antwoord;
//        Scanner s = new Scanner(System.in);
//        do {
//            MainManager.clearScreen(false);
//            Product gekozenProduct = MainManager.kiesProduct(klant, bedrijfsVoorraad);
//            Bedrijf gekozenBedrijf = MainManager.kiesBedrijf(klant, bedrijfsVoorraad, gekozenProduct.getNaam());
//            gekozenBedrijven.add(gekozenBedrijf);
//            Product product = new Product("", 0.0f);
//            for (int i = 0; i < bedrijfsVoorraad.size(); i++) {
//                if (bedrijfsVoorraad.get(i).getNaam() == gekozenBedrijf.getNaam()) {
//                    Voorraad voorraad = bedrijfsVoorraad.get(i).getVoorraad();
//                    ArrayList<Product> bedrijfsProducten = voorraad.getProducten();
//                    Product toRemove = null;
//                    for (Product bedrijfProduct : bedrijfsProducten) {
//                        if (bedrijfProduct.getNaam() == gekozenProduct.getNaam()) {
//                            winkelwagen.add(bedrijfProduct);
//                            toRemove = bedrijfProduct;
//                        }
//                    }
//                    bedrijfsProducten.remove(toRemove);
//                }
//            }
//            System.out.print("Wilt u nog iets bestellen? (Y/N) : ");
//            antwoord = s.nextLine().toLowerCase();
//        } while (!antwoord.equals("n"));
//
//        MainManager.clearScreen(false);
//
//        int klantId = 0;
//        for (int i = 0; i < klanten.size(); i++) {
//            if (klant.getEmail() == klanten.get(i).getEmail() && klant.getNaam() == klanten.get(i).getNaam()) {
//                klantId = i;
//            }
//        }
//        Bestelling bestelling = new Bestelling(klantId, gekozenBedrijven);
//        for (Product product : winkelwagen) {
//            bestelling.addProduct(product);
//        }
//
//        // Laat de bestelling zien
//        BestellingManager.bekijkBestelling(bestelling);
//
//        // Kijk of de klant genoeg geld heeft.
//        if (BestellingManager.heeftGenoegGeld(klanten, bestelling)) {
//            if (BestellingManager.wilKopen()) {
//                klanten.get(klantId).betalen(bestelling.getTotaleStonks());
//                for (int i = 0; i < bestelling.getProducten().size(); i++) {
//                    // Doe de betalingen
//                    Product currentProduct = bestelling.getProducten().get(i);
//                    ArrayList<Integer> bedrijfIds = BestellingManager.bedrijfNaarId(bedrijven, gekozenBedrijven);
//                    int currentBedrijfId = bedrijfIds.get(i);
//                    bedrijven.get(currentBedrijfId).addStonks(currentProduct.getPrijs());
//
//                    // Haal de producten uit de voorraaden.
//                    Voorraad voorraad = bedrijven.get(currentBedrijfId).getVoorraad();
//                    ArrayList<Product> bedrijfsProducten = voorraad.getProducten();
//                    Product toRemove = null;
//                    for (Product bedrijfsProduct : bedrijfsProducten) {
//                        if (bedrijfsProduct.getNaam() == currentProduct.getNaam()) {
//                            toRemove = bedrijfsProduct;
//                        }
//                    }
//                    bedrijfsProducten.remove(toRemove);
//                    voorraad.setProducten(bedrijfsProducten);
//                    bedrijven.get(currentBedrijfId).setVoorraad(voorraad);
//                }
//            }
//        }


//        Product product = MainManager.kiesProduct(klant, bedrijven);
//        Bedrijf bedrijf = MainManager.kiesBedrijf(klant, bedrijven, product.getNaam());

//        Product product = MainManager.kiesProduct(klant, bedrijven);
//        System.out.println(product.getNaam());
//        Bedrijf bedrijf = MainManager.kiesBedrijf(klant, bedrijven, product.getNaam());
//        System.out.println(bedrijf.getNaam());
//        MainManager.printTotaleVoorraad(totaleVoorraad);
    }


}