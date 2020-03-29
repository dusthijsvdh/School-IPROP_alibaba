package managers;

import classes.Bedrijf;
import classes.Bestelling;
import classes.Klant;
import classes.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class BestellingManager {
    //TODO count producten, dus als je een product 2 keer besteld staat er 2x productNaam
    public static void bekijkBestelling(Bestelling bestelling) {
//        System.out.println("Dit is de bestelling van: " + bestelling.getKlant().getNaam());
        System.out.println("De geschatte levertijd van de bestelling is: " + bestelling.getGeschatteLevertijdInDagen());
        System.out.println("De bestelling bevat de volgende product(en): ");
        for (Product product : bestelling.getProducten()) {
            System.out.println(product.getNaam() + ", €" + product.getPrijs());
        }
    }

   public static boolean heeftGenoegGeld(ArrayList<Klant> klanten, Bestelling bestelling) {
        int klantId = bestelling.getKlantId();
        return klanten.get(klantId).getVermogen() >= bestelling.getTotaleStonks();
   }

   public static boolean wilKopen() {
        Scanner s = new Scanner(System.in);
        System.out.print("Wilt u deze bestelling plaatsen? (Y/N) : ");
        String antwoord = s.nextLine();
        return antwoord.toLowerCase().equals("y");
   }

   public static ArrayList<Integer> bedrijfNaarId(ArrayList<Bedrijf> bedrijven, ArrayList<Bedrijf> gekozenBedrijven) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for(Bedrijf gekozenBedrijf : gekozenBedrijven) {
            for(int id = 0; id < bedrijven.size(); id++) {
                if (gekozenBedrijf.getNaam() == bedrijven.get(id).getNaam()) {
                    ids.add(id);
                }
            }
        }
        return ids;
   }
}
