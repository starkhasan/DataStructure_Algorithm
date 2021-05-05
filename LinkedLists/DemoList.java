import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class DemoList{

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
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static int getSize(Node head){
        if(head == null)
            return 0;
        else
            return 1+getSize(head.next);
    }



    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head = null;
        System.out.println("Enter Size of Linked List : ");
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size>0){
            head = insert(head, Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        printList(head);
        
    }
}