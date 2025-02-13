package designPatterns.prototype;

public interface Prototype<T>{
    public T copy();

    public T clone();

    default void getNameInInterface() {
        System.out.println("My name is Rajiv");
    }
}
