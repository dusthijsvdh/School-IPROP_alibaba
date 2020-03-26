package managers;

import classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BestellingManager {

    private ArrayList<Klant> klanten = new ArrayList<Klant>();
    private ArrayList<Bedrijf> bedrijven = new ArrayList<Bedrijf>();
    private ArrayList<Bestelling> bestellingen = new ArrayList<Bestelling>();

    public void addKlant(Klant klant) {
        this.klanten.add(klant);
    }

    public void addBedrijf(Bedrijf bedrijf) {
        this.bedrijven.add(bedrijf);
    }

    public void addBestelling(Bestelling bestelling) {
        this.bestellingen.add(bestelling);
    }

    public static void koopProducten(Bestelling bestelling, Voorraad voorraad) {
        ArrayList<Product> kanKopen = kanKopen(bestelling, voorraad);
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
        System.out.println(wilKopen);
    }

    public static boolean wilKopen() {
        Scanner s = new Scanner(System.in);
        System.out.print("Wilt u deze bestelling plaatsen? (Y/N) : ");
        String klantKeuze = s.nextLine().toLowerCase();
        return klantKeuze.equals("y");
    }

    //TODO count producten, dus als je een product 2 keer besteld staat er 2x productNaam
    public static void bekijkBestelling(Bestelling bestelling) {
        System.out.println("Dit is de bestelling van: " + bestelling.getKlant().getNaam());
        System.out.println("De geschatte levertijd van de bestelling is: " + bestelling.getGeschatteLevertijdInDagen());
        System.out.println("De bestelling bevat de volgende producten: ");
        for (Product product : bestelling.getProducten()) {
            System.out.println(product.getNaam() + ", €" + product.getPrijs());
        }
    }

    public static ArrayList<Product> kanKopen(Bestelling bestelling, Voorraad voorraad) {
        ArrayList<Product> kanKopen = new ArrayList<Product>();

        ArrayList<Product> bestellingProducten = bestelling.getProducten();
        ArrayList<Product> voorraadProducten = voorraad.getProducten();

        for (Product bestellingProduct : bestellingProducten) {
            boolean gevonden = false;
            for (Product voorraadProduct : voorraadProducten) {
                if (bestellingProduct.getNaam() == voorraadProduct.getNaam()) {
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
