public class Stack<Item> {
    private int n;
    private Node first;

    //constructor: creates an empty Stack
    public Stack() {
	    first = null;
	    n = 0;
    }

    //adds item to the top of the Stack
    public void push(Item item) {
        Node newFirst = first;
        first = new Node();
        first.item = item;
        first.next = newFirst;
        n++;
    }

    //removes and returns the top item from the Stack
    //throw EmptyStackException if the Stack is empty
    public Item pop() throws EmptyStackException {
	    if (first == null) {
            throw new EmptyStackException();
        }
	    Node returnedFirst = first;
	    first = first.next;
	    n--;
	    return returnedFirst.item;
    }
    
    //return true if the Stack is empty, false else
    public boolean isEmpty() {
	    return (first == null);
    }

    //return the size (number of items) of the Stack
    public int size() {
	    return n;
    }

    //return but do not remove the top item from the Stack
    //throw EmptyStackException if the Stack is empty
    public Item peek() throws EmptyStackException {
        if (first == null) {
            throw new EmptyStackException();
        }
        return first.item;
    }

    private class Node {
	    Item item;
	    Node next;
    }

    public int getN() {
        return n;
    }

    public Node getFirst() {
        return first;
    }
}