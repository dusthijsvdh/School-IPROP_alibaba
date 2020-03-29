package managers;

import classes.Product;

import java.util.ArrayList;

public class ProductManager {
    public static ArrayList<Product> voegProductToe(ArrayList<Product> products, Product product) {
        products.add(product);
        return products;
    }

    public static ArrayList<Product> verwijderProduct(ArrayList<Product> products, String productNaam) {
        ArrayList<Product> toRemove = new ArrayList<Product>();
        for (Product product : products) {
            if (product.getNaam().equals(productNaam)) {
                toRemove.add(product);
                break;
            }
        }
        products.removeAll(toRemove);
        System.out.println(products);
        return products;
    }
}
