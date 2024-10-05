package designPatterns.factoryDp;

public class MongoDb implements Database {

    @Override
    public void createQuery() {
        System.out.println("Mongo db");
    }
}
