import java.util.Arrays;

class Pokemon_1 {
    static String GENERATION = "Gen-I";
    static final String LOCATION = "Kanto";
    static final String[] VERSIONS = { "RED", "GREEN", "YELLOW", "BLUE" };

    // copy for each instance
    int health_max = 100;
    int moves_max = 5;
    String type = "";
    String name = "";

    /** this is a constructor, it 'creates' objects
     * @param String name: the name of the pokemeon
     * @param String type: the type of pokemon
     * @param int health_max: the max health of that pokemon
     */
    public Pokemon_1(String name, String type, int health_max) {
        this.name = name;
        this.type = type;
        if (health_max > 0) {
            this.health_max = health_max;
        }
    }

    /** this is the "string" method that is called when we want to print
     * an instance as a string. In this case it returns the name and
     * a summary of that pokemon's type and max health
     */
    public String toString() {
        return this.name + " (" + this.type + ", " + this.health_max + ")";
    }

    public static void main(String[] args) {
        System.out.println(Pokemon_1.GENERATION);
        System.out.println(Pokemon_1.LOCATION);
        System.out.println(Arrays.toString(Pokemon_1.VERSIONS));

        // creating instances with their own variables
        // check the outputs are distinct
        Pokemon_1 Charmander = new Pokemon_1("Charmander", "Fire", 39);
        System.out.println(Charmander);
        Pokemon_1 Bulbasaur = new Pokemon_1("Bulbasaur", "Grass", 45);
        System.out.println(Bulbasaur);
        Pokemon_1 Squirtle = new Pokemon_1("Squirtle", "Fire", 44);
        System.out.println(Squirtle);

        // this also works! Class variables are shared amongst instances
        System.out.println(Charmander.GENERATION);
        Charmander.GENERATION = "Gen-II";
        System.out.println(Bulbasaur.GENERATION);
        // change the GENERATION variable to final and
        // check if the above is still alloweß
        }
}