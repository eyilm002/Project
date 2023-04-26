import java.util.Scanner;
import test.ConcreteEditorApp;
import test.EditorApp;

public class App extends EditorApp {
   
    public static void main(String[] args) {
        EditorApp editor = new ConcreteEditorApp();
        Scanner scanner = new Scanner(System.in);
    
        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Delete Range");
            System.out.println("4. Make it Upper Case");
            System.out.println("5. Print");                       
            System.out.println("6. Quit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline character
    
            switch (choice) {
                case 1:
                    System.out.print("Enter text to insert: ");
                    String text = scanner.nextLine();
                    System.out.print("Enter index to insert at: ");
                    int pos = scanner.nextInt();
                    for (int i = 0; i < text.length(); i++) {
                        char c = text.charAt(i);
                        editor.insert(c, pos + i);
                    }
                    break;
                case 2:
                    System.out.println("1. Delete at index");
                    System.out.println("2. Delete range");
                    int deleteChoice = scanner.nextInt();
                    if (deleteChoice == 1) {
                        System.out.print("Enter index to delete: ");
                        int index = scanner.nextInt();
                        editor.delete(index);
                    } else if (deleteChoice == 2) {
                        System.out.print("Enter start index of range to delete: ");
                        int startIndex = scanner.nextInt();
                        System.out.print("Enter end index of range to delete: ");
                        int endIndex = scanner.nextInt();
                        editor.deleteRange(startIndex, endIndex);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    System.out.print("Enter start index of range to delete: ");
                    int startIndex = scanner.nextInt();
                    System.out.print("Enter end index of range to delete: ");
                    int endIndex = scanner.nextInt();
                    editor.deleteRange(startIndex, endIndex);
                    break;
                 
                case 4:
                    editor.upperCase();
                   
                    break;

                case 5:
                    editor.print();
                    break;

                case 6:
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
    