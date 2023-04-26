import java.util.Scanner;

public class App {

    private static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    App() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insert a character at the given index
    public void insert(char c, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");

            }
      

        Node newNode = new Node(c);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            tail = newNode;
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }

        size++;
    }

    // Delete the character at the given index
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 0) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            if (curr.next == null) {
                tail = curr;
            }
        }

        size--;
    }

    public void deleteRange(int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= size || startIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }

        Node startNode = getNodeAtIndex(startIndex - 1);
        Node endNode = getNodeAtIndex(endIndex);

        if (startNode == null) {
            // Deleting from the beginning of the list
            head = endNode.next;
        } else {
            startNode.next = endNode.next;
        }

        if (endNode == tail) {
            // Deleting from the end of the list
            tail = startNode;
        }

        size -= (endIndex - startIndex + 1);
    }

    // Get the node at the given index
    private Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }

    // Print the current text buffer
    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
        }
        System.out.println();
    }

    public void toUpperCase() {
        Node curr = head;
        while (curr != null) {
            curr.data = Character.toUpperCase(curr.data);
            curr = curr.next;
        }
    }


 
    public static void main(String[] args) {
        App editor = new App();
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
                    editor.toUpperCase();
                    editor.print();
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
    