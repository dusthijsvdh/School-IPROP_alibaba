package managers;

import classes.Adres;

public class AdresManager {

    public static int BerekenLevertijd(Adres leverancier, Adres klant) {

        if(leverancier.land == klant.land) {
            return 1;
        } else {
            int afstand = leverancier.straat.length() - klant.straat.length();

            if(afstand <= -1) {
                return 3;
            } else if(afstand == 0) {
                return 1;
            } else if(afstand >= 3) {
                return 2;
            } else {
                return 4;
            }
        }
    }

}
