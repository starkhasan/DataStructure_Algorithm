import java.util.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class CountItem {
    public static Node insert(Node head,int data){
        if(head == null)
            head = new Node(data);
        else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new Node(data);
        }
        return head;
    }

    public static void printList(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static int getItemCount(Node head, int key){
        int itemCount = 0;
        Node temp = head;
        while(temp!=null){
            if(temp.data == key)
                itemCount++;
            temp = temp.next;
        }
        return itemCount;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size : ");
        int list_size = sc.nextInt();
        Node head = null;
        while(list_size>0){
            head = insert(head,sc.nextInt());
            list_size-=1;
        }
        printList(head);
        int key = sc.nextInt();
        int item = getItemCount(head,key);
        if(item > 0)
            System.out.println("Item Founds= "+item);
        else
            System.out.println("Item not found!");
        sc.close();
    }
}
