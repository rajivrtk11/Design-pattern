package designPatterns.factoryDp.factory;

import designPatterns.factoryDp.product.Product;
import designPatterns.factoryDp.product.ProductC;

public class ProductCCreator implements ProductFactory{
    @Override
    public Product createProduct() {
        return new ProductC();
    }
}
