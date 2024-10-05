package solidPrinciple;

// solution 1.
public class Bird {
    public String name;
    public String color;
    public Integer age;
    public Integer weight;
    public String breed;

    public void collectFood() {
        System.out.println("Collects food");
    }

    public void buildNest() {
        System.out.println("Build nest");
    }

    public void makeSound() {
        System.out.println("Make sound");
    }

    public void fly() {
        System.out.println("Birds fly");
    }
}

/**
 * Problems
 * 1. There are some common method but some are more specific to the birds. Those uncommon methods cann't be given to all
 * birds.
 * 2.
 * */

// solution-2

abstract class Bird1 {
    String color;
    Integer weight;
    String name;
    Integer age;
    String breed;

    Bird1(String color, Integer weight, String name, Integer age, String breed) {
        this.color = color;
        this.weight = weight;
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    abstract void collectFood();
    abstract void buildNest();
    abstract void fly();
    abstract void makeSound();
}

class Sparrow extends Bird1 {

    Sparrow(String color, Integer weight, String name, Integer age, String breed) {
        super(color, weight, name, age, breed);
    }

    @Override
    void collectFood() {
        System.out.println("Sparrow collect food");
    }

    @Override
    void buildNest() {
        System.out.println("Sparrow build nest");
    }

    @Override
    void fly() {
        System.out.println("Sparrow fly");
    }

    @Override
    void makeSound() {
        System.out.println("Sparrow make sound.");
    }
}

