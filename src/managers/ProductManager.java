package managers;

import classes.Product;

import java.util.List;

public class ProductManager {
    public static List<Product> VerwijderProduct(List<Product> products, String productNaam) {
        products.removeIf(product -> product.getNaam() == productNaam);
        return products;
    }
}
