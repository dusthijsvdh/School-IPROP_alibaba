import classes.Adres;
import managers.AdresManager;

public class Main {
    public static void main(String[] args) {
        System.out.println("Here begins the story of a great package");

        Adres leverancier = new Adres("netherlands", "Zuid-Holland", "Alphen aan den Rijn","Zeewinde", 90);
        Adres klant = new Adres("United States", "Ohio", "Loser Town", "Winners Street", 69);

        int geschatteLevertijd = AdresManager.BerekenLevertijd(leverancier, klant);
        System.out.println("Our package wil travel far and wide, but he wil return in " + geschatteLevertijd + " days!");
    }
}