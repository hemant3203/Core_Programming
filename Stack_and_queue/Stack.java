package Stack_and_queue;

// public class Stack {
//     private int [] stack;
//     private int capacity;
//     private int top;

//     public Stack(int size){
//         capacity=size;
//         stack=new int[capacity];
//         top=-1;
//     }

//     public boolean isEmpty(){
//         return top==-1;
//     }

//     public boolean isFull(){
//         return top==capacity-1;
//     }

//     public void push(int data){
//         if(isFull()){
//             System.out.println("Stack Overflow");
//             return;
//         }
//         stack[++top]=data;
//     }

//     public int pop(){
//         if(isEmpty()){
//             System.out.println("Stack Underflow");
//             return -1;
//         }
//         return stack[top--];
//     }

//     public int peek(){
//              if(isEmpty()){
//                 System.out.println("Stack is Empty");
//                 return -1;
//              }
//              return stack[top];
//     }

//     public void display(){
//         if(isEmpty()){
//             System.out.println("Stack is already empty");
//             return;
//         }
//         for(int i=0;i<=top;i++){
//             System.out.print(stack[i]+" ");
//         }
//         System.out.println();
//     }

//     public static void main(String [] args){
//         Stack st=new Stack(5);
//         st.push(10);
//         st.push(20);
//         st.push(30);
//         st.display();
//         System.out.println("Top Element of the stack is :"+ st.peek());
//         st.pop();
//         st.display();
//     }
// }
// Implementation using Linkedlist for dynamic

// Node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Stack {
    private Node top;  


    public Stack() {
        top = null;
    }

   
    public boolean isEmpty() {
        return top == null;
    }

    
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

  
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1; 
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

   
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return top.data;
    }

    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

 
    public static void main(String[] args) {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();

        System.out.println("Top element: " + stack.peek());

        stack.pop();
        stack.display();
    }
}
