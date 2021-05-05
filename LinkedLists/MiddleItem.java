import java.util.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class MiddleItem {
    public static Node insert(Node head,int data){
        if(head == null){
            head = new Node(data);
        }else{
            Node current = head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(data);
        }
        return head;
    }

    public static int getSize(Node head){
        if(head == null)
            return 0;
        else
            return 1+getSize(head.next);
    }

    public static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static int getMiddleItem(Node head){
        int list_size = getSize(head);
        int tempIndex = 0;
        list_size = list_size/2;
        Node temp = head;
        while(temp!=null){
            if(tempIndex == list_size)
                return temp.data;
            tempIndex+=1;
            temp = temp.next;
        }
        return -1;
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
        int item = getMiddleItem(head);
        if(item!=-1)
            System.out.println("Middle Item = "+item);
        else
            System.out.println("Middle Item not found!");
        sc.close();
    }
}
