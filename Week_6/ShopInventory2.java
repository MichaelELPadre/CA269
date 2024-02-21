import java.util.*;

class Item {
    private final String name;
    private final double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }
    @Override
    public String toString() {
        return this.name + " " + this.price;
    }
}




class Basket {
    public final Stack<Item> basket;

    Basket() {
        basket = new Stack<>();
    }

    public void addItem(Item item) {
        basket.push(item);
    }

    public Item removeItem() {
        if (!basket.isEmpty()) {
            return basket.pop();
        }
        return null;
    }

    @Override
    public String toString() {
        return "basket:" + basket.toString();
    }
}











class Checkout {
    private final Queue<Item> checkout;

    Checkout(Basket basket) {
        checkout = new LinkedList<>();
        while (!basket.basket.isEmpty()) {
            addItem(basket.removeItem());
        }
    }

    public void addItem(Item item) {
        checkout.add(item);
    }

    public Item removeItem() {
        if (!checkout.isEmpty()) {
            return checkout.poll();
        }
        return null;
    }

    @Override
    public String toString() {
        return "checkout:" + checkout.toString();
    }
}

class Bill {
    private final Map<String, Integer> basket;
    private double price;

    Bill(Checkout checkout) {
        basket = new LinkedHashMap<>();
        price = 0.0;
        Item item;
        while ((item = checkout.removeItem()) != null) {
            billItem(item);
        }
    }

    public void billItem(Item item) {
        basket.put(item.getName(), basket.getOrDefault(item.getName(), 0) + 1);
        price += item.getPrice();
    }

    public double getTotal() {
        return this.price;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (String item : basket.keySet()) {
            output.append(item).append(" (").append(basket.get(item)).append("nos)\n");
        }
        output.append("total: ").append(price);
        return output.toString();
    }
}

public class ShopInventory2 {
    public static void main(String[] args) {
        Basket basket = new Basket();
        loadBasket(basket);
    
        Checkout checkout = new Checkout(basket);
        Bill bill = new Bill(checkout);
        System.out.println(bill);
    }
    static void loadBasket(Basket basket) {
        basket.addItem(new Item("Twinings Earl Grey Tea", 4.50));
        basket.addItem(new Item("Folans Orange Marmalade", 4.00));
        basket.addItem(new Item("Free-range Eggs", 3.35));
        basket.addItem(new Item("Brennan's Bread", 2.15));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        basket.addItem(new Item("Ferrero Rocher", 7.00));
        System.out.println(basket);
    }
}
