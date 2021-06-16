//Program for Moving Last item to first in Linked List
import java.util.*;
public class MoveLastFirst{
    public static Node insert(Node head,int data){
        if(head == null){
            head = new Node(data);
        }else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new Node(data);
        }
        return head;
    }

    public static void printList(Node head){
        Node temp = head;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static Node moveLastFirst(Node head){
        Node temp = head;
        int lastData = 0;
        while(temp!=null){
            if(temp.next.next == null){
                lastData = temp.next.data;
                temp.next = null;
            }
            temp = temp.next;
        }
        Node newNode = new Node(lastData);
        newNode.next = head;
        head = newNode;
        return head;
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
        head = moveLastFirst(head);
        printList(head);
        sc.close();
    }
}