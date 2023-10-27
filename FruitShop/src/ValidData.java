
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class ValidData {
    public static Scanner sc = new Scanner(System.in);
    public static String inputString(String msg){
        while (true) {  
            System.out.print(msg);
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println(Message.ERROR_INPUT);
                continue;
            }
            return input;
        }
    }
    public static int inputInt(String msg){
        while (true) {            
            try {
                int input = Integer.parseInt(inputString(msg));
                if(input <= 0){
                    System.out.println(Message.ERROR_INT);
                    continue;
                }
                return input;
            } catch (NumberFormatException e) {
                System.out.println(Message.ERROR_INT);
            }
        }
    }
    
    public static boolean inputContinue(String msg){
        while (true) {            
            String input = inputString(msg);
            if(!input.equalsIgnoreCase(Message.INPUT_N) && !input.equalsIgnoreCase(Message.INPUT_Y)){
                System.out.println(Message.INPUT_INVALID);
                continue;
            }
            return input.equalsIgnoreCase(Message.INPUT_Y);
        }
    }
    
    public static int isDuplicateID(ArrayList<Fruit> arr){
        while (true) {            
            int input = inputInt(Message.INPUT_ID);
            arr.stream().filter((fruit) -> (fruit.getFruitID() == input)).forEachOrdered((_item) -> {
                System.out.println(Message.DUPLICATE);
            });
            return input;
        }
    }
     
    public static int inputChoice(){
        while (true) {            
            int input = inputInt(Message.INPUT_CHOICE);
            if(input > 4 || input < 1){
                System.out.println(Message.INPUT_INVALID);
                continue;
            }
            return input;
        }
    }
}
