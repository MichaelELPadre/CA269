
enum Brand{
    Mercedes, BMW, Toyota, Ferrari
}

interface Description{
    void getDescription();
}
public class Vehicle implements Description{
    Brand brand;
    String owner;
    int mph;
    public Vehicle(String owner, Brand brand, int mph){
        this.owner = owner;
        this.brand = brand;
        this.mph = mph;
    }
    String getOwner(){
        return this.owner;
    }
    Brand getBrand(){
        return this.brand;
    }
    int getMph(){
        return this.mph;
    }
    @Override
    public void getDescription(){
        System.out.println("This vehicle can reach speeds as high as: " + mph+ ". This " + brand + " is owned by " + owner);
    }
    public static void main(String[] args){
        Vehicle motorbike = new Vehicle("Ben", Brand.BMW, 110);
        motorbike.getDescription();
        Car i8 = new Car("Michael", Brand.BMW, 150, 4, true);
        i8.getDescription();


    }
}


class Car extends Vehicle{
    int doors;
    boolean car;
    public Car(String owner, Brand brand, int mph, int doors, boolean car){
        super(owner, brand, mph);
        this.doors = doors;
        this.car = car;
    }
    public boolean is_car(){
        return car;
    }
    @Override
    public void getDescription(){
        String carrr = is_car() ? "is a car" : "is not a car";
        System.out.println("This " + brand +" "+ carrr + ". It is owned by " + owner);
    }
}






