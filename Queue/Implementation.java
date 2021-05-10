import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class Implementation {

    static boolean isEmpty(Node head){
        return head == null;
    }

    static int peek(Node head){
        return head.data;
    }

    static Node add(Node temp,int data){
        if(temp == null)
            temp = new Node(data);
        else{
            Node current = temp;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(data);
        }
        return temp;
    }

    static int remove(Node head,Node tail){
        int data = head.data;
        head = head.next;
        if(head == null)
            tail = null;
        return data;
    }

    static void printQueue(Node head){
        Node temp = head;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int queue_size = Integer.parseInt(buffer.readLine());
        Node head = null;
        Node tail = null;
        while(queue_size > 0){
            if(head == null){
                head = add(head,Integer.parseInt(buffer.readLine()));
            }else{
                if(tail == null){
                    tail = add(tail,Integer.parseInt(buffer.readLine()));
                    head.next = tail;
                }else{
                    tail = add(tail,Integer.parseInt(buffer.readLine()));
                }
            }
            queue_size-=1;
        }
        printQueue(head);
        if(isEmpty(head))
            System.out.println("\nQueue is Empty");
        else
            System.out.println("\nQueue is not Empty");
        buffer.close();
    }
}
