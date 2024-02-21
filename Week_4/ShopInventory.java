
import java.text.DecimalFormat;


abstract class Item {
     final String name;
     int expiresInDays;
     double price;
     Item(String name) {
         this.name = name;
     }
 

     public String toString() {
         return this.name;
     }
 }
 interface StorageCondition {
     String storageProcedure();
 }
 

 interface Refrigerate extends StorageCondition {

     boolean refrigerate(double currentTemp);
 }
 

 interface SecureItem extends StorageCondition {

     void attachSecurityTag();
 

     boolean removeSecurityTag();
 }
 

 interface ReducedPrice {

     double reduction(double totalAmount);
 }
 

 interface OnSale extends ReducedPrice {

     boolean saleCondition(Item[] items);
 }

 class Milk extends Item implements Refrigerate {
     int maxRefrigerateTemp;
 

     private Milk(String name) {
         super(name);
     }
 

     Milk(String name, int expiryDays, double price, int maxRefrigerateTemp) {
         this(name);
         this.expiresInDays = expiryDays;
         this.price = price;
         this.maxRefrigerateTemp = maxRefrigerateTemp;
     }
 

     public boolean refrigerate(double currentTemp) {
         if (currentTemp > maxRefrigerateTemp) {
             return true;
         }
         return false;
     }

     public String storageProcedure() {
         return "refrigeration needed";
     }
 }


 class Bread extends Item implements StorageCondition {
 
     private Bread(String name) {
         super(name);
    }

    Bread(String name, int expiryDays, double price){
         this(name);
        this.expiresInDays = expiryDays;
       this.price = price;
     }

     public String storageProcedure() {
         return "Airtight Storage";
     }
 }
 

 class Perfume extends Item implements SecureItem {
     private boolean locked;
     private Perfume(String name) {
         super(name);
     }

     Perfume(String name, int expiryDays, double price) {
         this(name);
         this.expiresInDays = expiryDays;
         this.price = price;
         this.attachSecurityTag();
     }
 

     public void attachSecurityTag() {
         this.locked = true;
     }
 

     public boolean removeSecurityTag() {
         if (this.locked != true) {
             return false;
         }
         this.locked = false;
         return this.locked;
     }
 

     public boolean getLocked() {
         return this.locked;
     }
 

     public String storageProcedure() {
         return "Away from Sunlight";
     }
 }

 class PlasticCup extends Item {
 
  
     private PlasticCup(String name) {
         super(name);
     }
 

     PlasticCup(String name, int expiryDays, double price) {
        this(name);
         this.expiresInDays = expiryDays;
         this.price = price;
     }
 }
 

 class EasterSale implements OnSale {
 
     final String message;
     final double minimumAmount;
     final double salePercent;
 

     EasterSale(double salePercent, double minimumAmount) {
         this.salePercent = salePercent / 100;
         this.minimumAmount = minimumAmount;
         DecimalFormat format = new DecimalFormat("0.#");
         this.message = "Spend over " + format.format(minimumAmount) + ", Get " 
             + (this.salePercent*100) + "% off for Easter!";
     }
 

     public double reduction(double totalAmount) {
         return totalAmount - (totalAmount * salePercent);
     }
 

     public boolean saleCondition(Item[] items) {
         double totalAmount = 0;
         for(Item item : items) {
             totalAmount += item.price;
         }
         if (totalAmount > this.minimumAmount) {
             return true;
         }
         return false;
     }
 

     public String toString() {
         return this.message;
     }
 }
 

 public class ShopInventory {
 

    public static double billItems(Item[] items, OnSale Sale) {
         double total = 0;
 
         for (Item item : items) {
         
             System.out.print(item);

             total += item.price;
             System.out.print(" (" + item.price + ")");

             if (item instanceof StorageCondition) {
                 System.out.print(" (Storage: ");
                 if (item instanceof Refrigerate && ((Refrigerate) item).refrigerate(getCurrentTemperature())) {
                         System.out.print(((Refrigerate) item).storageProcedure());
                 } else if (item instanceof SecureItem) {
                     ((SecureItem) item).removeSecurityTag();
                     System.out.print(((StorageCondition) item).storageProcedure());
                 } else if (item instanceof StorageCondition) {
                     System.out.print(((StorageCondition) item).storageProcedure());
                 }
                 System.out.print(")");
             }
 
             System.out.println();
         }
 
         if (Sale == null || Sale.saleCondition(items) == false) {
             return total;
         }
 
         System.out.println("Actual Total: " + total);
         System.out.println(Sale);
         total = Sale.reduction(total);
 
         return total;
     }
 

     private static int getCurrentTemperature() {
         return 24;
     }

     public static void main(String[] args) {
         DecimalFormat df = new DecimalFormat("#.##");

         System.out.println("--- Customer 1 ---");
         Item[] items_no_sale = {
             new Milk("Avenmore Fresh", 5, 1.90, 12),
             new Bread("Bretzel Tortano", 7, 4.50),
             new Perfume("Lynx Vanilla", 500, 7),
             new PlasticCup("Tea Mug", 1200, 12),
         };
         double total_no_sale = billItems(items_no_sale, null);
         System.out.println("Total Amount: " + df.format(total_no_sale));

         System.out.println("--- Customer 2 ---");
        Item[] items_easter_sale = {
             new Milk("Mulled Wine", 60, 22.20, 8),
             new Bread("Fruit Cakes", 20, 13.50),
             new Perfume("Pot-pourri", 500, 15),
             new PlasticCup("Party Cups (set of 12)", 1200, 2),
         };
         double total_easter_sale = billItems(items_easter_sale, new EasterSale(7.5, 50));
         System.out.println("Total Amount: " + df.format(total_easter_sale));

     }
 }