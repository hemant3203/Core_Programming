package Queue;

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
