class Animal{
    protected String name;
    protected int number_legs;

    public Animal(String name, int number_legs){
        this.name = name;
        this.number_legs = number_legs;
  
    }
    public String getName(){
        return name;
    }
    public int getLegs(){
        return number_legs;
    }

    public String getDescription(){
        return ("The animal: " + name + " has " + number_legs + " legs");
    }

}
class Birds extends Animal{
    enum Wings{

    }
    private boolean haswings;
    public Birds(String name, int number_legs, boolean haswings){
        super(name, number_legs);
        this.haswings = haswings;
    }
    public boolean haswings(){
        return haswings;
    }

    public String get_new_Description(){
        String wings = haswings ? "and has wings" : " and does not have wings";
        return ("This bird is a : " + name + ", it has " + number_legs + " legs " + wings);
    }
    public String toString(){
        return (name);
    }

}



public class Animals {
    public static void main(String[] args) {
        Animal cow = new Animal("Cow", 4);
        System.out.println(cow.getDescription());
        Birds penguin = new Birds("Penguin", 2, true);
        System.out.println(penguin.get_new_Description());
        penguin.get_new_Description();
        System.out.println(penguin);
    }
    
}
