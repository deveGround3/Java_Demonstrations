
import java.util.Scanner;

/**
 *
 * @author Nicholas Schons
 */
public class MainApplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Scanner keyboard = new Scanner(System.in);
        MyArrayList<String> k = new MyArrayList<>();
        MyLinkedList<String> j = new MyLinkedList<>();
        MyDLinkedList<String> l = new MyDLinkedList<>();
        MainListTest("ArrayList", k);
        MainListTest("LinkedList", j);
        MainListTest("MyDLinkedTest", l);
        
    }   
        //E list = keyboard.nextLine();
    static void displayList(String type, MyAbstractList<String> input) {
        System.out.print(type + ": ");
        System.out.println(input.toString());
    }
    static void MainListTest(String type, MyAbstractList<String> input) {
        Scanner keyboard = new Scanner(System.in);
        //isEmptyD(input);
        displayList(type, input);
        System.out.print("Enter in a series of words seperated by spaces: ");
        String words = keyboard.nextLine();
        String[] wordA = words.split(" ");
        
        for (String s : wordA) {
           input.add(s);
        }
        displayList(type, input);
        
        System.out.print("Enter in an int list index to delete. (0-" + (input.size() - 1) + "): ");
        int index = keyboard.nextInt();
        String rElement = input.remove(index);
        System.out.println("Removed Element: " + rElement);
        displayList(type, input);
        
        System.out.print("Enter in a string to add to the list: ");
        String word = keyboard.next();
        System.out.print("Enter the int list index where it is to be placed. (0-" + input.size() + "): ");
        int addIndex = keyboard.nextInt();
        input.add(addIndex, word);
        displayList(type, input);
        
        System.out.print("Enter in another string to add to the list: ");
        String word2 = keyboard.next();
        System.out.print("Enter the int list index where it is to be placed. (0-" + input.size() + "): ");
        int addIndex2 = keyboard.nextInt();
        input.add(addIndex2, word2);
        displayList(type, input);
        System.out.println("");
        
    }
}
