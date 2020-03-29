package managers;

import classes.Bedrijf;
import classes.Klant;
import classes.Product;
import classes.Voorraad;

import java.util.ArrayList;
import java.util.Scanner;

public class MainManager {
    // Vraag naar de klant
    public static int welkeKlant(ArrayList<Klant> klanten) {
        for(int i = 0; i < klanten.size(); i++) {
            System.out.println((i + 1) + " : " + klanten.get(i).getNaam());
        }
        Scanner s = new Scanner(System.in);
        int id;
        do {
            System.out.print("Welke van deze klanten bent u? : ");
            while(!s.hasNextInt()) {
                System.out.println("Dat is niet een correct nummer! Het nummer moet postief zijn en geen letters bevatten.");
                System.out.print("Welke van deze klanten bent u? : ");
                s.next();
            }
            id = s.nextInt();
        } while(id <= 0 || id > klanten.size());

        return id - 1;
    }

//    public static ArrayList<Product> productenKiezen(Klant klant, ArrayList<Bedrijf> bedrijven) {
//        ArrayList<Product> winkelwagen = new ArrayList<Product>();
//        String antwoord;
//        Scanner s = new Scanner(System.in);
//        do {
//            Product product = MainManager.kiesProduct(klant, bedrijven);
//            Bedrijf bedrijf = MainManager.kiesBedrijf(klant, bedrijven, product.getNaam());
//            System.out.print("Wilt u nog iets bestellen? (Y/N) : ");
//            antwoord = s.nextLine().toLowerCase();
//        } while(!antwoord.equals("n"));
//        return winkelwagen;
//    }

    public static ArrayList<Bedrijf> bedrijfsBerichten(ArrayList<Bedrijf> bedrijven, String productNaam) {
        ArrayList<Bedrijf> bedrijvenDieHetHebben = new ArrayList<Bedrijf>();
        for(Bedrijf bedrijf : bedrijven) {
            Voorraad voorraad = bedrijf.getVoorraad();
            ArrayList<Product> producten = voorraad.getProducten();
            for(Product product : producten) {
                if(product.getNaam() == productNaam) {
                    bedrijvenDieHetHebben.add(bedrijf);
                }
            }
        }
        return bedrijvenDieHetHebben;
    }

    // Print alle producten 1 keer, laat daarna de bedrijven zien die het verkopen, met de prijzen en de levertijden
    public static Product kiesProduct(Klant klant, ArrayList<Bedrijf> bedrijven) {
        // Print alle producten 1 keer
        ArrayList<Product> totaleVoorraad = getTotaleVoorraad(bedrijven);
        ArrayList<String> gehad = new ArrayList<String>();
        int i = 1;
        for(Product product : totaleVoorraad) {
            if(!gehad.contains(product.getNaam())) {
                gehad.add(product.getNaam());
                System.out.println(i + " : " + product.getNaam());
                i++;
            }
        }

        // Kies een product
        Scanner s = new Scanner(System.in);
        int id;
        do {
            System.out.print("Welke van deze producten wilt u bestellen? : ");
            while(!s.hasNextInt()) {
                System.out.println("Dat is niet een correct nummer! Het nummer moet postief zijn en geen letters bevatten.");
                System.out.print("Welke van deze producten wilt u bestellen? : ");
                s.next();
            }
            id = s.nextInt();
        } while(id <= 0 || id > gehad.size());
        id--;
        String productNaam = gehad.get(id);
        Product gekozenProduct = new Product("", 0f);
        for(Product product : totaleVoorraad) {
            if(product.getNaam() == productNaam) {
                gekozenProduct = product;
            }
        }
        return gekozenProduct;
    }

    // Print alle producten 1 keer, laat daarna de bedrijven zien die het verkopen, met de prijzen en de levertijden
    public static Bedrijf kiesBedrijf(Klant klant, ArrayList<Bedrijf> bedrijven, String productNaam) {
        // Clear screen
        clearScreen(false);

        // Kies een bedrijf
        ArrayList<Bedrijf> bedijvenDieHetHebben = bedrijfsBerichten(bedrijven, productNaam);
        System.out.println("Het product " + productNaam + " is te verkrijgen bij de volgende bedrijven: ");
        for(int j = 0; j < bedijvenDieHetHebben.size(); j++) {
            int geschatteLevertijd = AdresManager.BerekenLevertijd(bedijvenDieHetHebben.get(j).getAdres(), klant.getAdres());
            Voorraad voorraad = bedijvenDieHetHebben.get(j).getVoorraad();
            ArrayList<Product> producten = voorraad.getProducten();
            for(Product product : producten) {
                if(product.getNaam() == productNaam) {
                    System.out.println((j + 1) + " : " + bedijvenDieHetHebben.get(j).getNaam() + ", €" + product.getPrijs() + ", met als geschatte levertijd " + geschatteLevertijd + " dagen.");

                }
            }
        }

        Scanner s = new Scanner(System.in);
        int bedrijfsId;
        do {
            System.out.print("Van welk bedrijf wilt u de producten bestellen? : ");
            while(!s.hasNextInt()) {
                System.out.println("Dat is niet een correct nummer! Het nummer moet postief zijn en geen letters bevatten.");
                System.out.print("Van welk bedrijf wilt u de producten bestellen? : ");
                s.next();
            }
            bedrijfsId = s.nextInt();
        } while(bedrijfsId <= 0 || bedrijfsId > bedijvenDieHetHebben.size());
        bedrijfsId--;
        Bedrijf bedrijf = bedijvenDieHetHebben.get(bedrijfsId);
        return bedrijf;
    }

    public static void printTotaleVoorraad(ArrayList<Product> totaleVoorraad) {
        for(int i = 0; i < totaleVoorraad.size(); i++) {
            System.out.println((i + 1) + " : " + totaleVoorraad.get(i).getNaam() + ", " + "€" + totaleVoorraad.get(i).getPrijs());
        }
    }

    // Helper functions for the array lists
    public static Klant getKlantById(ArrayList<Klant> klanten, int id) {
        return klanten.get(id);
    }

    public static Bedrijf getBedrijfById(ArrayList<Bedrijf> bedrijven, int id) {
        return bedrijven.get(id);
    }

    // Krijg alle producten van alle leveranciers
    public static ArrayList<Product> getTotaleVoorraad(ArrayList<Bedrijf> bedrijven) {
        ArrayList<Product> producten = new ArrayList<Product>();
        for(Bedrijf bedrijf : bedrijven) {
            Voorraad voorraad = bedrijf.getVoorraad();
            producten.addAll(voorraad.getProducten());
        }
        return producten;
    }

    // Clear the screen
    public static void clearScreen(boolean ask) {
        if(ask) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Druk op enter om door te gaan : ");
            scanner.nextLine();
        }
        for (int i = 0; i < 200; i++) {
            System.out.println("");
        }
    }

    public static void voorraadBekijken(ArrayList<Bedrijf> bedrijven) {
        for (Bedrijf bedrijf : bedrijven) {
            System.out.println(bedrijf.getNaam() + ":" );
            System.out.println("Voorraad:");
            for (Product product : bedrijf.getVoorraad().getProducten()) {
                System.out.println(product.getNaam() + ", €" + product.getPrijs());
            }
            System.out.println("");
        }
    }
}
