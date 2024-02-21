import java.util.ArrayList;

interface Storable {
    void store();
}

abstract class Item {
    protected String name;
    protected double price;
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public abstract void display();
}

class FoodItem extends Item implements Storable {
    public FoodItem(String name, double price) {
        super(name, price);
    }
    @Override
    public void display() {
        System.out.println("Food Item: " + name + ", Price: " + price);
    }

    @Override
    public void store() {
        System.out.println("Store in a cool, dry place.");
    }
}

class ElectronicItem extends Item {
    public ElectronicItem(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("Electronic Item: " + name + ", Price: " + price);
    }
}
public class Shop {
    private ArrayList<Item> items;

    public Shop() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void displayItems() {
        for (Item item : items) {
            item.display();
            if (item instanceof Storable) {
                ((Storable) item).store();
            }
        }
    }
    public static void main(String[] args) {
        Shop inventory = new Shop();

        inventory.addItem(new FoodItem("Bread", 2.99));
        inventory.addItem(new ElectronicItem("Headphones", 59.99));

        inventory.displayItems();
    }
}