package managers;

import classes.Product;

import java.util.ArrayList;
import java.util.Iterator;

public class ProductManager {
    public static ArrayList<Product> voegProductToe(ArrayList<Product> products, Product product) {
        products.add(product);
        return products;
    }

    public static ArrayList<Product> verwijderProduct(ArrayList<Product> products, String productNaam) {
        for (Product product : products) {
            if (product.getNaam() == productNaam) {
                products.remove(product);
                break;
            }
        }

//        products.removeIf(product -> product.getNaam() == productNaam);
        return products;
    }
}
