import java.util.Arrays;

class Pokemon_1 {
    static String GENERATION = "Gen-I";
    static final String LOCATION = "Kanto";
    static final String[] VERSIONS = { "RED", "GREEN", "YELLOW", "BLUE" };

    int health_max = 100;
    int moves_max = 5;
    String type = "";
    String name = "";

    public Pokemon_1(String name, String type, int health_max) {
        this.name = name;
        this.type = type;
        if (health_max > 0) {
            this.health_max = health_max;
        }
    }
    public String toString() {
        return this.name + " (" + this.type + ", " + this.health_max + ")";
    }

    public static void main(String[] args)
    {
     Pokemon_1 Charmander = new Pokemon_1("Charmander", "Fire", 39);
     System.out.println(Charmander);
     Pokemon_1 Bulbasaur = new Pokemon_1("Bulbasaur", "Grass", 45);
     System.out.println(Bulbasaur);
     Pokemon_1 Squirtle = new Pokemon_1("Squirtle", "Fire", 44);
     System.out.println(Squirtle);
     System.out.println(Pokemon_1.GENERATION);
     System.out.println(Pokemon_1.LOCATION);
     System.out.println(Arrays.toString(Pokemon_1.VERSIONS));

     System.out.println(Charmander.GENERATION);
    }
}
