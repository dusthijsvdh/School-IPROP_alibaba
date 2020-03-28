package managers;

import classes.Bestelling;
import classes.Klant;

public class KlantManager {

    public static void showKlant(Klant klant) {
        System.out.println("De naam van deze klant is: " + klant.getNaam());
        System.out.println("Het email van deze klant is: " + klant.getEmail());
        System.out.println("Het vermogen van deze klant is: " + klant.getVermogen());
    }

//    public static boolean heeftGenoegGeld(Bestelling bestelling) {
//        return bestelling.getKlant().getVermogen() >= bestelling.getTotaleStonks();
//    }
}
