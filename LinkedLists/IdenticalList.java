import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class IdenticalList {
    static Node insert(Node head,int data){
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

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static boolean identical(Node first,Node second){
        while(first!=null && second!=null){
            if(first.data != second.data)
                return false;
            first = first.next;
            second = second.next;
        }
        return (first == null && second == null);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int list_size = Integer.parseInt(buffer.readLine());
        Node head = null;
        Node head1 = null;
        int inputData = 0;
        while(list_size>0){
            inputData = Integer.parseInt(buffer.readLine());
            head = insert(head, inputData);
            head1 = insert(head1, inputData);
            list_size-=1;
        }
        if(identical(head,head1))
            System.out.println("Both Linked List are Identical");
        else
            System.out.println("Linked List are not identical");
    }
}
