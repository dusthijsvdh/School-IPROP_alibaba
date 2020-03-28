package managers;

import classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BestellingManager {
//    public void addKlant(Klant klant) {
//        this.klanten.add(klant);
//    }
//
//    public void addBedrijf(Bedrijf bedrijf) {
//        this.bedrijven.add(bedrijf);
//    }
//
//    public void addBestelling(Bestelling bestelling) {
//        this.bestellingen.add(bestelling);
//    }

    public static void koopProducten(Bestelling bestelling, ArrayList<Bedrijf> bedrijven) {
        ArrayList<Product> kanKopen = kanKopen(bestelling, bedrijven);
        boolean wilKopen = false;
        if (kanKopen.size() == bestelling.getProducten().size()) {
            wilKopen = wilKopen();
        } else if (kanKopen.isEmpty()) {
            System.out.println("Exuses voor het ongemak, geen van de producten zijn op vooraad");
        } else {
            System.out.println("Van de producten die u wou bestellen, zijn alleen deze producten nog op voorraad: ");
            for (Product product : bestelling.getProducten()) {
                System.out.println(product.getNaam() + ", €" + product.getPrijs());
            }
            wilKopen = wilKopen();
        }

//        if (wilKopen) {
//            //TODO check genoeg crediet van klant
//            if (KlantManager.heeftGenoegGeld(bestelling)) {
//                ArrayList<Product> voorraadBedrijf = bestelling.getLeverancier().getVoorraad().getProducten();
//                for (Product bestellingProduct : bestelling.getProducten()) {
//                    voorraadBedrijf = ProductManager.verwijderProduct(voorraadBedrijf, bestellingProduct.getNaam());
//                }
//
//                //TODO yeetus deluts voorraad
//                bestelling.getLeverancier().setProducten(voorraadBedrijf);
//                VoorraadManager.bekijkVoorraad(bestelling.getLeverancier().getVoorraad());
//
//                //TODO Haal geld van klant en zet over naar bedrijf
//                bestelling.getKlant().betalen(bestelling.getTotaleStonks());
//                bestelling.getLeverancier().addStonks(bestelling.getTotaleStonks());
//
//                //TODO Laat de klant de levertijd zien
//                System.out.println("Uw bestelling is geplaats.");
//                System.out.println("Uw bestelling komt aan over: " + bestelling.getGeschatteLevertijdInDagen() + " dag(en).");
//            } else {
//                System.out.println("U heeft niet genoeg geld om deze bestelling te plaatsen.");
//                System.out.println("Uw balans is: " + bestelling.getKlant().getVermogen() + ",terwijl de bestelling: " + bestelling.getTotaleStonks() + " kost.");
//            }
//        }
    }

    public static boolean wilKopen() {
        Scanner s = new Scanner(System.in);
        System.out.print("Wilt u deze bestelling plaatsen? (Y/N) : ");
        String klantKeuze = s.nextLine().toLowerCase();
        return klantKeuze.equals("y");
    }

    //TODO count producten, dus als je een product 2 keer besteld staat er 2x productNaam
    public static void bekijkBestelling(Bestelling bestelling) {
//        System.out.println("Dit is de bestelling van: " + bestelling.getKlant().getNaam());
        System.out.println("De geschatte levertijd van de bestelling is: " + bestelling.getGeschatteLevertijdInDagen());
        System.out.println("De bestelling bevat de volgende producten: ");
        for (Product product : bestelling.getProducten()) {
            System.out.println(product.getNaam() + ", €" + product.getPrijs());
        }
    }

    public static ArrayList<Product> kanKopen(Bestelling bestelling, ArrayList<Bedrijf> bedrijven) {
        ArrayList<Product> kanKopen = new ArrayList<Product>();

        ArrayList<Product> bestellingProducten = bestelling.getProducten();
        ArrayList<Product> voorraadProducten = MainManager.getTotaleVoorraad(bedrijven);

        for (Product bestellingProduct : bestellingProducten) {
            boolean gevonden = false;
            for (Product voorraadProduct : voorraadProducten) {
                if (bestellingProduct.getNaam() == voorraadProduct.getNaam()) {
                    voorraadProducten.remove(voorraadProduct);
                    gevonden = true;
                    break;
                }
            }
            if (gevonden) {
                kanKopen.add(bestellingProduct);
            }
        }

        return  kanKopen;
    }
}
