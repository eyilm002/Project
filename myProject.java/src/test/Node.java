package test;


public class Node {
    public char data;
    public Node next;

  
    public Node getNext() {
        return this.next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    public Node(char c) {
        this.data = c;
        this.next = null;
    }
}