interface Animal {
    void makeSound();
}

public class Mammal implements Animal {
    String name;
    
    public Mammal(String name) {
        this.name = name;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " makes a sound.");
    }

    public static void main(String[] args) {
        Mammal mammal = new Mammal("Crocodile");
        Dog dog = new Dog("Buddy", "Golden Retriever");
        
        mammal.makeSound();
        dog.makeSound();
        
        // Demonstrating casting
        Mammal castedDog = dog; // Upcasting, implicitly done
        castedDog.makeSound(); // This will call the overridden method in Dog
        
        if (castedDog instanceof Dog) {
            ((Dog) castedDog).displayBreed(); // Downcasting to call Dog-specific method
        }
        dog.displayBreed();
    }
}

class Dog extends Mammal {
    String breed;
    
    public Dog(String name, String breed) {
        super(name);
        this.breed = breed;
    }
    
    @Override
    public void makeSound() {
        System.out.println(name + " barks.");
    }
    
    public void displayBreed() {
        System.out.println(name + " is a " + breed);
    }
}