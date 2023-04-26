package test;
public abstract class EditorApp implements Functions  {
    private Node head;
    private Node tail;
    private int size;

    public EditorApp() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
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
 
    @Override
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
    @Override
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
            size -= (endIndex - startIndex + 1);
        }
    }
    @Override
    public void upperCase() {
        Node curr = head;
        while (curr != null) {
            curr.data = Character.toUpperCase(curr.data);
            curr = curr.next;
        }
    }
    @Override
    public void print() {
        Node curr = head;
        int i=0;
        while (curr != null) {
            System.out.print(curr.data);
            curr = curr.next;
        i++;
        }

        System.out.println();
        System.out.println("The character number of the text is: " + i);
    }
    
    public Node getNodeAtIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }

        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr;
    }
 }