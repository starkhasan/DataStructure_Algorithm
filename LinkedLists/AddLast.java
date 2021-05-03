import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class AddLast {
    public static Node insert(Node head,int data){
        if(head == null){
            head = new Node(data);
        }else{
            Node cur = head;
            while(cur.next!=null){
                cur = cur.next;
            }
            cur.next = new Node(data);
        }
        return head;
    }

    public static void printLinkedList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException{
        Node head = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Size of LinkedList");
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size>0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        printLinkedList(head);
    }
}


