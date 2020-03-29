package managers;

import classes.Product;

import java.util.ArrayList;

public class ProductManager {
    public static ArrayList<Product> voegProductToe(ArrayList<Product> products, Product product) {
        products.add(product);
        return products;
    }

    public static ArrayList<Product> verwijderProduct(ArrayList<Product> products, String productNaam) {
        for (Product product : products) {
            if (product.getNaam().equals(productNaam)) {
                try {
                    products.remove(product);
                } catch (Exception e) {
                    System.out.println(e);
                }
                break;
            }
        }

        return products;
    }
}
