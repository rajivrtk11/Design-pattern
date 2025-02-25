import hello.Hello;

import java.util.ArrayList;
import java.util.*;


public class Main {
    static int[] parent;

    // Find function with path compression
    public static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // Union function to connect two indices
    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static String getAlphabeticallyMinimalString(String s, List<Integer> arr, List<Integer> brr) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        parent = new int[n];

        // Initialize the parent array
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Connect indices using union operation
        for (int i = 0; i < arr.size(); i++) {
            union(arr.get(i), brr.get(i));
        }

        // Group characters belonging to the same set
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Sort characters in each group and place them in lexicographical order
        for (List<Integer> group : groups.values()) {
            List<Character> chars = new ArrayList<>();
            for (int index : group) {
                chars.add(charArray[index]);
            }
            Collections.sort(chars);

            // Replace original indices with sorted characters
            for (int i = 0; i < group.size(); i++) {
                charArray[group.get(i)] = chars.get(i);
            }
        }

        return new String(charArray);
    }

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
//        Dbc url = Dbc.createConnection();
//        System.out.println("connection is"+ url);
//        Test t = Test.RAJIV;
//        Hello hello = new Hello();
//
//        System.out.println("rajiv si "+ Test.getFromString("rajiv"));
        String s = "dcba";
        List<Integer> arr = Arrays.asList(0, 1, 2);
        List<Integer> brr = Arrays.asList(1, 2, 3);
        String alphabeticallyMinimalString = getAlphabeticallyMinimalString(s, arr, brr);
        System.out.println(alphabeticallyMinimalString);
    }
}
