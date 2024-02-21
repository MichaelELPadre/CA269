class Duck {
    String colour;
    String id;
    public Duck(String colour, String id) {
        this.colour = colour;
        this.id = id;
    }



    public String toString() {
        return (id);
    }



}
class DuckFactory{
    public int counter = 0;
    public final int MAX_DUCKS;
    public final String colour;

    public DuckFactory(int max_ducks, String colour){
        this.MAX_DUCKS = max_ducks;
        this.colour = colour;
    }

    public Duck getNewDuck() {
        counter += 1;
        if (counter < MAX_DUCKS) {
            return new Duck(colour, colour);
        }
        return null ;
    }


public static void main(String[] args) {
    DuckFactory dfRed = new DuckFactory(100, "Red");
    Duck d1 = dfRed.getNewDuck();
    System.out.println(d1); // Red#1
    for(int i=1; i<100; i++) { dfRed.getNewDuck(); } // skip to duck #50
    d1 = dfRed.getNewDuck();
    System.out.println(d1); // Red#51

    DuckFactory dfGreen = new DuckFactory(0, "Green");
    d1 = dfGreen.getNewDuck();
    System.out.println(d1.colour); // error: d1 is null!
}
}