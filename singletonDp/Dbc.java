package singletonDp;

public class Dbc {
    private static Dbc connectionUrl;

    private Dbc() {}

    public static Dbc createConnection() {
//        if(connectionUrl == null) {
//            synchronized (Dbc.class) {
//                if(connectionUrl == null) {
                    connectionUrl = new Dbc();
//                }
//            }
//        }
        return connectionUrl;
    }
}
