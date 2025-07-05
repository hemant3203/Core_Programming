package LinkedList;

import java.util.Scanner;

public class InventoryManagementSystem {
    class Node{
        String Item_name;
        long Item_id;
        int Quantity;
        double price;
        Node next;
       
        Node(String Item_name,long Item_id,int Quantity,double price){
            this.Item_name=Item_name;
            this.Item_id=Item_id;
            this.Quantity=Quantity;
            this.price=price;
            this.next=null;
        }
    }


    Node head=null;
    void addAtBeginning(String Item_name,long Item_id,int Quantity,double price){
        Node newNode=new Node(Item_name,Item_id,Quantity,price);
        newNode.next=head;
        head=newNode;
    }

    void addAtEnd(String Item_name,long Item_id,int Quantity,double price){
         Node newNode=new Node(Item_name,Item_id,Quantity,price);
         if(head==null){
            head=newNode;
            return;
         }
         Node temp=head;
         while(temp.next!=null){
            temp=temp.next;
         }
        temp.next=newNode;
    }
   
    void addAtPosition(int pos,String Item_name,long Item_id,int Quantity,double price){
        if(pos==1){
            addAtBeginning(Item_name, Item_id, Quantity, price);
            return;
        }
        Node newNode=new Node(Item_name, Item_id, Quantity, price);
        Node temp=head;
        for(int i=1;temp!=null && i<pos-1;i++){
            temp=temp.next;
        }
        if(temp==null){
            return;
        }
        newNode.next=temp.next;
        temp.next=newNode;
    }

    void deleteByItemId(long Item_id){
        if(head==null){
           return; 
        }
        if(head.Item_id==Item_id){
            head=head.next;
            return;
        }
        Node temp=head;
        while(temp.next!=null && temp.next.Item_id!=Item_id){
            temp=temp.next;
        }
        if(temp.next==null){
            return;
        }
        temp.next=temp.next.next;
    }
    void updateQuantityByItem_id(long Item_id,int Quantity){
        Node temp=head;
        while(temp!=null){
           if(temp.Item_id==Item_id){
            temp.Quantity=Quantity;
            return;
           }
           temp=temp.next;
        }
        System.out.println("Item ID not found");
    }

    void searchByID(long Item_id){
        Node temp=head;
        while(temp!=null){
            if(temp.Item_id==Item_id){
                System.out.println("Item Found");
               System.out.println("Item Name: "+ temp.Item_name);
               System.out.println("Item Id:"+ temp.Item_id);
               System.out.println("Quantity :"+temp.Quantity);
               System.out.println("Price:"+temp.price);
               return;
            }
            temp=temp.next;
        }
        System.out.println("Item Not Found");
    }

    void searchByName(String Item_name){
        Node temp=head;
        while(temp!=null){
            if(temp.Item_name==Item_name){
               System.out.println("Item Found");
               System.out.println("Item Found");
               System.out.println("Item Name: "+ temp.Item_name);
               System.out.println("Item Id:"+ temp.Item_id);
               System.out.println("Quantity :"+temp.Quantity);
               System.out.println("Price:"+temp.price);
               return;
            }
            temp=temp.next;
        }
        System.out.println("Item Not Found");
    }

    void calvalofinventory(){
        Node temp=head;
        double totalSum=0.0;
        while(temp.next!=null){
          int quant=temp.Quantity;
          double price=temp.price;
          totalSum=totalSum+(quant*price);
          temp=temp.next;
        }
        System.out.println("Total Value of Inventory:"+totalSum);
    }

    void sortBynameAscending(){
        if(head==null){
            return;
        }

        for(Node i=head;i.next!=null;i=i.next){
            for(Node j=i.next;j!=null;j=j.next){
                if(i.Item_name.compareTo(j.Item_name)>0){
                    swap(i,j);
                }
            }
        }
    }

    void sortbyprice(){
        if(head==null){
            return ;
        }
        for(Node i=head;i.next!=null;i=i.next){
            for(Node j=i.next;j!=null;j=j.next){
                if(i.price>j.price){
                    swap(i, j);
                }
            }
        }
    }

    void swap(Node a,Node b){
        String name=a.Item_name;
        long id=a.Item_id;
        int qty=a.Quantity;
        double price =a.price;

        a.Item_name=b.Item_name;
        a.Item_id=b.Item_id;
        a.Quantity=b.Quantity;
        a.price=b.price;

        b.Item_id=id;
        b.Item_name=name;
        b.Quantity=qty;
        b.price=price;
    }

    void display(){
        Node temp=head;
        System.out.println("Inventory:");
        while(temp.next!=null){
                 System.out.println("Name: " + temp.Item_name + ", ID: " + temp.Item_id + ", Qty: " + temp.Quantity + ", Price: " + temp.price);
                 temp=temp.next;
        }
    }

public static void main(String[] args) {
    InventoryManagementSystem ims = new InventoryManagementSystem();
    Scanner sc = new Scanner(System.in);
    int choice = -1;

    System.out.println("--- Inventory Management System ---");

    while (choice != 0) {
        System.out.println("\nMenu:");
        System.out.println("1. Add at Beginning");
        System.out.println("2. Add at End");
        System.out.println("3. Add at Position");
        System.out.println("4. Delete by Item ID");
        System.out.println("5. Update Quantity by Item ID");
        System.out.println("6. Search by Item ID");
        System.out.println("7. Search by Item Name");
        System.out.println("8. Calculate Inventory Value");
        System.out.println("9. Sort by Name (Ascending)");
        System.out.println("10. Sort by Price (Ascending)");
        System.out.println("11. Display Inventory");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
        
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
            sc.nextLine(); 
        } else {
            System.out.println("Please enter a valid number.");
            sc.nextLine();
            continue;
        }

        switch (choice) {
            case 1:
                System.out.print("Enter name, id, quantity, price: ");
                ims.addAtBeginning(sc.next(), sc.nextLong(), sc.nextInt(), sc.nextDouble());
                sc.nextLine();
                break;
            case 2:
                System.out.print("Enter name, id, quantity, price: ");
                ims.addAtEnd(sc.next(), sc.nextLong(), sc.nextInt(), sc.nextDouble());
                sc.nextLine();
                break;
            case 3:
                System.out.print("Enter position: ");
                int pos = sc.nextInt();
                System.out.print("Enter name, id, quantity, price: ");
                ims.addAtPosition(pos, sc.next(), sc.nextLong(), sc.nextInt(), sc.nextDouble());
                sc.nextLine();
                break;
            case 4:
                System.out.print("Enter Item ID to delete: ");
                ims.deleteByItemId(sc.nextLong());
                sc.nextLine();
                break;
            case 5:
                System.out.print("Enter Item ID and new Quantity: ");
                ims.updateQuantityByItem_id(sc.nextLong(), sc.nextInt());
                sc.nextLine();
                break;
            case 6:
                System.out.print("Enter Item ID to search: ");
                ims.searchByID(sc.nextLong());
                sc.nextLine();
                break;
            case 7:
                System.out.print("Enter Item Name to search: ");
                String name = sc.nextLine();
                ims.searchByName(name);
                break;
            case 8:
                ims.calvalofinventory();
                break;
            case 9:
                ims.sortBynameAscending();
                System.out.println("Inventory sorted by name.");
                break;
            case 10:
                ims.sortbyprice();
                System.out.println("Inventory sorted by price.");
                break;
            case 11:
                ims.display();
                break;
            case 0:
                System.out.println("Exiting system. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    sc.close();
}


}
