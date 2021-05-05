import java.io.*;
public class ReverseList {
    public static Node insert(Node head,int data){
        if(head == null){
            head = new Node(data);
        }else{
            Node cur = head;
            while(cur.next!=null)
                cur = cur.next;
            cur.next = new Node(data);
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
        Node current = head;
        Node temp = head;
        Node prev = null;
        while(temp!=null){
            current = temp.next;
            temp.next = prev;
            prev = temp;
            temp = current;
        }
        return prev;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head = null;
        System.out.println("Enter Linked List Size");
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size>0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        printList(head);
        head = reverse(head);
        System.out.println("\nReverse Linked List");
        printList(head);
    }
}
