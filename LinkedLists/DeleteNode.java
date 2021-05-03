import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class DeleteNode {
    public static Node insert(Node head,int data){
        if(head == null){
            head = new Node(data);
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = new Node(data);
        }
        return head;
    }

    public static void printLinkedList(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static Node deleteNode(Node head,int key){
        Node temp = head;
        Node prev = null;
        if(temp.data == key){
            head = temp.next;
            return head;
        }

        while(temp!=null && temp.data != key){
            prev = temp;
            temp = temp.next;
        }

        if(temp == null)
            return head;
        
        prev.next = temp.next;

        return head;
    }



    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Size of LinkedList");
        Node head = null;
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size>0){
            head = insert(head, Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        System.out.println("Enter Elemen to Delete");
        int delete_item = Integer.parseInt(buffer.readLine());
        printLinkedList(head);
        head = deleteNode(head, delete_item);
        printLinkedList(head);
    }
}
