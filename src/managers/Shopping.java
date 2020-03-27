package managers;

import classes.Adres;
import classes.Klant;

import java.util.Scanner;

public class Shopping {

    public static void startShopping() {
        System.out.println("Welkom bij alibaba, het beste winkelsysteem!");
        System.out.println("Om te beginnen hebben wat informatie nodig.");
        Klant klant = klantRegistreren();
        KlantManager.showKlant(klant);
    }

    public static Klant klantRegistreren() {
        Scanner s = new Scanner(System.in);
        System.out.print("Wat is uw naam?: ");
        String klantNaam = s.nextLine();
        System.out.print("Wat is uw emailadres?: ");
        String klantMail = s.nextLine();
        System.out.print("In welk land woont u?: ");
        String klantLand = s.nextLine();
        System.out.println("In welke staat woont u?: ");
        String klantStaat = s.nextLine();
        System.out.print("In welke stad woont u?: ");
        String klantStad = s.nextLine();
        System.out.print("In welke straat woont u?: ");
        String klantStraat = s.nextLine();
        System.out.print("Wat is uw huisnummer?: ");
        int klantHuisnummer;
        do {
            while (!s.hasNextInt()) {
                System.out.println("Dat is niet een correct nummer! Het nummer moet postief zijn en geen letters bevatten.");
                s.next();
            }
            klantHuisnummer = s.nextInt();
            System.out.println("Het nummer moet wel positief zijn.");
        } while (klantHuisnummer <= 0);
        System.out.println("Hoeveel geld wilt u op uw account zetten?: ");
        float klantVermogen;
        do {
            while (!s.hasNextFloat()) {
                System.out.println("Dat is niet een correct nummer! Het nummer moet postief zijn en geen letters bevatten.");
                s.next();
            }
            klantVermogen = s.nextFloat();
        } while (klantVermogen <= 0.0f);

        Klant klant = new Klant(klantNaam, klantMail, new Adres(klantLand, klantStaat, klantStad, klantStraat, klantHuisnummer), klantVermogen);

        return klant;
    }
}
