package factoryDp;

import javax.xml.crypto.Data;

public class MongoDb implements Database {

    @Override
    public void createQuery() {
        System.out.println("Mongo db");
    }
}
