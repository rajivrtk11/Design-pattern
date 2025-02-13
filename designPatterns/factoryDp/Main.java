package designPatterns.factoryDp;

import designPatterns.factoryDp.factory.ProductACreator;
import designPatterns.factoryDp.factory.ProductBCreator;
import designPatterns.factoryDp.factory.ProductCCreator;
import designPatterns.factoryDp.factory.ProductFactory;
import designPatterns.factoryDp.product.Product;
import designPatterns.factoryDp.product.ProductC;

public class Main {
    public static void main(String[] args) {
        ProductFactory productAFactory = new ProductCCreator();
        Product productA = productAFactory.createProduct();
        productA.display();
    }
}
