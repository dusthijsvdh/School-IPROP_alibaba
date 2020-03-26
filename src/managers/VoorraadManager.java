package managers;

import classes.Product;
import classes.Voorraad;

public class VoorraadManager {
    public static void bekijkVoorraad(Voorraad voorraad) {
        System.out.println("De voorraad van dit bedrijf bevat:");
        for (Product product : voorraad.getProducten()) {
            System.out.println(product.getNaam() + ", €" + product.getPrijs());
        }
    }
}
