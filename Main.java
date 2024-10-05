import singletonDp.Dbc;

public class Main {
    public static void main(String[] args) {
//        Hello obj = new Hello();
//        obj.getText();
//        System.out.println("hello world rajiv");
//        D d = new Ds
//        b.eat();
//        System.out.println();

//        MySql db = new MySql();
//        db.createQuery();
//        db.createConnection();
//
//        Database db1 = new MongoDb();
//        db1.createQuery();

//        Student st = Student.createBuilder()
//                .setAge("12")
//                .setfName("Rajiv")
//                .setlName("singh")
//                .setWeight("32")
//                .build();
//        System.out.println(st.getWeight());
        Dbc url = Dbc.createConnection();
        System.out.println("connection is"+ url);
    }
}
