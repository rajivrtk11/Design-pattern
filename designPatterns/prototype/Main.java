package designPatterns.prototype;

public class Main {
    public static void main(String[] args) {
        Student st = new Student();
        st.setName("Rajiv singh");
        st.setAge("26");
        st.setMobileNo("12121212");

        Student st1 = st.copy();
        Student clone = st.clone();
        System.out.println("cloned object is "+ clone.toString());

        st1.setAge("27");
        System.out.println("st is "+st);
        System.out.println("st1 is "+st1);
        System.out.println("ref is equal "+ (st == st1));
        st.getNameInInterface();
    }
}
