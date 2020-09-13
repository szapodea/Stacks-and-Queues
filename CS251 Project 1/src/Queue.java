import java.lang.Math;

public class Queue<Item> {
    private Item[] queue;
    private int front;
    private int back;
    private int originalSize;
    private int size;

    //constructor: create an empty Queue with initial
    //capacity of 1
    public Queue() {
        this.queue = (Item[]) new Object[1];
        this.front = 0;
        this.back = 0;
        this.originalSize = 1;
        size = 0;
    }

    //constructor: create an empty Queue with initial
    //capacity of n
    public Queue(int n) {
        this.queue = (Item[]) new Object[n];
        this.front = 0;
        this.back = 0;
        size = 0;
        this.originalSize = n;
    }

    //add an item to the back of the Queue
    //double the array capacity if the Queue is full
    public void enqueue(Item item) {
        if (size == queue.length) {
            changeSize(queue.length  * 2);
        }
        queue[back] = item;
        back++;
        size++;
        if (back == queue.length) {
            back = 0;
        }
    }

    //remove and return the front item from the Queue
    //throw EmptyQueueException if the Queue is empty
    //reduce the array capacity by half if the queue.length
    //of the Queue falls below 1/4 full
    public Item dequeue() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new EmptyQueueException();
        }
        Item remove = queue[front];
        queue[front] = null;
        front++;
        size--;
        if (front == queue.length) {
            front = 0;
        }
        if ((size > originalSize) && (size == queue.length/ 4)) {
            changeSize(queue.length / 2);
        }
        return remove;
    }

    public void changeSize(int newSize) {
        Item[] newQueue = (Item[]) new Object[newSize];

        for (int i = 0; i < size; i++) {
            newQueue[i] = queue[(front + i) % queue.length];
        }
        queue = (Item[]) new Object[newSize];
        queue = newQueue;
        front = 0;

        back = size;
    }

    //return true if the Queue is empty
    //return false if the Queue is not empty
    public boolean isEmpty() {
        return (size() == 0);
    }

    //return the size of the Queue (i.e. the 
    //number of elements currently in the Queue)
    public int size() {
        return this.size;
    }

    //return but do not remove the front item in the Queue
    //throw an exception if the Queue is empty
    public Item peek() throws EmptyQueueException {
        if (this.isEmpty()) {
            throw new  EmptyQueueException();
        }
        return queue[front];
    }

    //return the underlying array
    public Item[] getArray() {
        return queue;
    }
    //returns the back index
    public int getBack() {
        return back;
    }
    public int getFront() {
        return front;
    }
}