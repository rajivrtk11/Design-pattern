package designPatterns.factoryDp.factory;

import designPatterns.factoryDp.product.Product;
import designPatterns.factoryDp.product.ProductB;

public class ProductBCreator implements ProductFactory{
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}
