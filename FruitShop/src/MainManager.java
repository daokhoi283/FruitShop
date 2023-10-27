/**
 *
 * @author ADMIN
 */
public class MainManager {
    private static void displayMenu(){
        System.out.println(Message.MAIN_MENU);
        System.out.println(Message.MAIN_1);
        System.out.println(Message.MAIN_2);
        System.out.println(Message.MAIN_3);
        System.out.println(Message.MAIN_4);
    }
    public static void main(String[] args) {
        FruitList fruit = new FruitList();
        while (true) {            
            displayMenu();
            int input = ValidData.inputChoice();
            switch(input){
                case 1:
                    fruit.addFruit();
                    break;
                case 2:
                    fruit.viewOrder();
                    break;
                case 3: 
                    fruit.Shopping();
                    break;
                case 4:
                    return;
            }
            
        }
    }
}
