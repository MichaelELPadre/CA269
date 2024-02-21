import java.util.*;


enum  Console{
    Xbox, Ps4, Ps5, Switch;
}

class Item {
    private final String name;
    private final int price;
    private final Console console;
    Item(String name, int price, Console console){
        this.name = name;
        this.price = price;
        this.console = console;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
    public Console getConsoles(){
        return console;
    }
    @Override
    public String toString(){
        return ("The game " + name + " costs " + price + " for " + console);
    }

}
class Basket {
    public final Stack<Item> basket;
    Basket(){
        basket = new Stack<>();
    }
    public void addItem(Item item){
        basket.push(item);
    }
    public Item removeItem(){
        if(!basket.isEmpty())
            return basket.pop();
        else
            return null;
    }
    @Override
    public String toString(){
        return ("basket:" + basket.toString());
    }
}

class Checkout{
    private final Queue<Item> checkout;
    
    Checkout(Basket basket){
        checkout = new LinkedList<>();
        while(!basket.basket.isEmpty()){
            addItem(basket.removeItem());
        }
    }
    public void addItem(Item item){
        checkout.add(item);
    }
    @Override
    public String toString(){
        return  "checkout: " + checkout.toString();
    }
}