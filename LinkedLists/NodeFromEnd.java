import java.util.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class NodeFromEnd {

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
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static Node reverse(Node head){
        Node temp = head;
        Node current = head;
        Node prev = null;
        while(temp!=null){
            current = temp.next;
            temp.next = prev;
            prev = temp;
            temp = current;
        }
        return prev;
    }

    public static int getLastValue(Node head,int lastIndex){
        int tempIndex = 1;
        Node temp = head;
        while(temp!=null){
            if(tempIndex == lastIndex)
                return temp.data;
            temp = temp.next;
            tempIndex+=1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        System.out.println("Enter Size : ");
        int list_size = sc.nextInt();
        while(list_size>0){
            head = insert(head,sc.nextInt());
            list_size-=1;
        }
        printList(head);
        head = reverse(head);
        System.out.println("Enter Search Index From Last");
        int lastIndex = sc.nextInt();
        int data = getLastValue(head,lastIndex);
        if(data!=-1)
            System.out.println("Item found = "+data);
        else
            System.out.println("Item not found!");
        sc.close();
    }  
}
