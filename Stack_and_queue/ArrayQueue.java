
package Stack_and_queue;

public class ArrayQueue{
   private int[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    public ArrayQueue(int capacity){
        this.capacity=capacity;
        queue=new int[capacity];
        front=0;
        size=0;
        rear=-1;
    }

    public boolean isEmpty(){
        return size==0;
    }
    
    public boolean isFull(){
        return size==capacity;
    }

     public boolean offer(int element) {
        if (isFull()) return false;
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        return true;
    }
    public boolean enequeue(int element){
        return offer(element);
    }

     public int poll() {
        if (isEmpty()) return -1;
        int removed = queue[front];
        front = (front + 1) % capacity;
        size--;
        return removed;
    }

    public int dequeue(){
        return poll();
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return queue[front];
    }


    public void display() {
    if (isEmpty()) {
        System.out.println("Queue is empty.");
        return;
    }

    System.out.print("Queue elements: ");
    for (int i = 0; i < size; i++) {
        int index = (front + i) % capacity;
        System.out.print(queue[index] + " ");
    }
    System.out.println();
}

    public static void main(String[] args) {
        ArrayQueue q=new ArrayQueue(5);
    System.out.println(q.enequeue(10));
      System.out.println(  q.offer(20));
      q.display();
        System.out.println(q.peek());
        System.out.println(q.dequeue());
       System.out.println( q.poll());
        q.display();
    }
}
/*

public class LinkedListQueue {
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node front;
    private Node rear;

    public LinkedListQueue() {
        front = rear = null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(int element) {
        Node newNode = new Node(element);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int dequeue() {
        if (isEmpty()) return -1;
        int data = front.data;
        front = front.next;
        if (front == null) rear = null;
        return data;
    }

    public int peek() {
        if (isEmpty()) return -1;
        return front.data;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue elements: ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        System.out.println("Dequeued: " + q.dequeue());
        System.out.println("Peek: " + q.peek());
        q.enqueue(40);
        q.display();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.display();
    }
}
 */
