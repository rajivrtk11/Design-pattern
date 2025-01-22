package solidPrinciple.liskovSubstitutionPrinciple;

public class Main {
    interface Flyable {
        void fly();
    }

    class Bird {
        // Common bird functionality
    }

    class Sparrow extends Bird implements Flyable {
        public void fly() {
            System.out.println("Sparrow is flying");
        }
    }

    class Penguin extends Bird {
        // Penguin-specific behavior, no flying method
    }

    public void makeFly(Flyable flyable) {
        flyable.fly();
    }

    public void main(String[] args) {
        Flyable sparrow = new Sparrow();
        makeFly(sparrow);  // Works fine
        System.out.println("Hello world!!");
    }
}
