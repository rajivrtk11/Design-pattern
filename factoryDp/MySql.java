package factoryDp;

public class MySql implements Database {


    @Override
    public void createQuery() {
        System.out.println("Mysql query");
    }

    public void createConnection() {
        System.out.println("Mysql connection");
    }
}
