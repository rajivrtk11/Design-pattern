package designPatterns.factoryDp.factory;

import designPatterns.factoryDp.product.Product;
import designPatterns.factoryDp.product.ProductA;

public class ProductACreator implements ProductFactory{
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}
