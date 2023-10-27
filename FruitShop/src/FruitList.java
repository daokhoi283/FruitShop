
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ADMIN
 */
public class FruitList extends ArrayList<Fruit>{ 
    HashMap<String, ArrayList<Customer>> hashCustomer = new HashMap<>();
    ArrayList<Customer> arr = new ArrayList<>();
    public void addFruit(){
        int fruitID;
        String fruitName;
        String fruitOrigin;
        int fruitPrice;
        int fruitQuanity;
        while (true) {            
            if(this.size() > 0){
                if(!ValidData.inputContinue(Message.INPUT_CONTINUE)){
                    displayFruit();
                    break;
                }
            }
            fruitID = ValidData.isDuplicateID(this);
            fruitName = ValidData.inputString(Message.INPUT_NAME);
            fruitPrice = ValidData.inputInt(Message.INPUT_PRICE);
            fruitQuanity = ValidData.inputInt(Message.INPUT_QUANTITY);
            fruitOrigin = ValidData.inputString(Message.INPUT_ORIGIN);
            add(new Fruit(fruitID, fruitName, fruitPrice, fruitQuanity, fruitOrigin));
        }
    }
    public void displayFruit(){
        System.out.printf(Message.FORMAT, Message.FRUIT_ID, Message.FRUIT_NAME,
                Message.FRUIT_PRICE, Message.FRUIT_QUANTITY, Message.FRUIT_ORIGIN);
        System.out.println();
        this.forEach((fruit) -> {
            System.out.printf(Message.FORMAT, fruit.getFruitID(),fruit.getFruitName(),
                fruit.getPrice()+ Message.DO, fruit.getQuantity(),fruit.getOrigin());
            System.out.println();
        });
    }
    private void displayShopping(){
        System.out.println(Message.LIST);
        System.out.printf(Message.FORMAT_1, Message.FRUIT_ITEM, Message.FRUIT_NAME,
                Message.FRUIT_ORIGIN, Message.FRUIT_PRICE);
        System.out.println();
        this.forEach((fruit) -> {
            System.out.printf(Message.FORMAT_1, fruit.getFruitID(),fruit.getFruitName()
                ,fruit.getOrigin(),fruit.getPrice()+ Message.DO);
            System.out.println();
        });
    } 
    //System.out.println(Message.NOT_FOUND);
    private Fruit getFruit(int id){ 
        while (true) {            
            for(Fruit fruit: this){
            if(fruit.getFruitID() != id){
                continue;
            }
            return fruit;
        } 
            
      } 
    }
    private Fruit getFruit(){
        while (true) {            
            int input = ValidData.inputInt("Enter select: ");
            for(Fruit fruit: this){
            if(fruit.getFruitID() == input){
                    return fruit;
                }
            }   
            System.out.println("Error"); 
       } 
    }
    private void displayOrder(ArrayList<Customer> arr){
        System.out.printf("%-10s%-10s%-10s%-10s", "Product", "Quantity", "Price",
                "Amount");
        for(Customer c: arr){
        System.out.printf("%-10s%-10s%-10s%-10s", c.getProduct(), c.getQuantity(), c.getPrice(),
                    c.getQuantity() * c.getPrice());
            System.out.println();
        }
        
    }
    public void viewOrder(){
        if(hashCustomer.isEmpty()){
            System.out.println("List order is empty!");
            return;
        }
        for(String name: hashCustomer.keySet()){
            System.out.println("Custormer: " + name);
            System.out.printf("%-10s%-10s%-10s%-10s", "Product", "Quantity", "Price",
                "Amount");
            System.out.println();
            int count = 0;
            int total = 0;
            for(Customer c: hashCustomer.get(name)){
                System.out.printf("%-10s%-10s%-10s%-10s", (++count) + c.getProduct(), c.getQuantity(),
                        c.getPrice(), c.getAmount());
                System.out.println();
                total += c.getAmount();
            }
            System.out.println("Total: " + total + "$\n"); 
        }  
    }
    
    public void Shopping(){
        int input;
        int quantity;
        String name;
        ArrayList<Customer> cus = new ArrayList<>();
        while (true) {   
            displayShopping();
            //input = ValidData.inputInt(Message.INPUT_SELECT);  
            Fruit fruitObj = getFruit();
            System.out.println(Message.SELECTED + fruitObj.getFruitName());
            quantity = ValidData.inputInt(Message.INPUT_PLEASE);  
            cus.add(new Customer(fruitObj.getFruitName(), quantity, fruitObj.getPrice(),
            quantity * fruitObj.getPrice()));
            
            if(!ValidData.inputContinue("Do you order now")){
                continue;
            }
            name = ValidData.inputString("Input your name: ");
            displayOrder(arr); 
            hashCustomer.put(name, cus); 
            break;
        }
    }
}
