import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
    }
}
public class LinkedListLength {
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

    public static int listSizeItr(Node head){
        //return Size of LinkedList Iteratively
        Node temp = head;
        int size = 0;
        while(temp!=null){
            size+=1;
            temp = temp.next;
        }

        return size;
    }

    public static int listSize(Node head){
        //return size of LinkedList Recursively
        if(head == null)
            return 0;
        else
            return 1 + listSize(head.next);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int list_size = Integer.parseInt(buffer.readLine());
        Node head = null;
        while(list_size > 0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        list_size = listSize(head);
        System.out.println("Size of Linked List = "+list_size);
    }
}
