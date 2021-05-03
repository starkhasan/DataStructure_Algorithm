import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class DeletePosition {
    public static Node insert(Node head, int data){
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

    public static void printLinkedList(Node head){
        System.out.println();   
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static int listSize(Node head){
        int list_size = 0;
        Node temp = head;
        while(temp!=null){
            list_size+=1;
            temp = temp.next;
        }

        return list_size;
    }

    public static Node deletePosition(Node head,int pos){
        Node temp = head;
        int listIndex = 0;
        Node prev = null;
        if(pos == 0){
            head = temp.next;
            return head;
        }
        while(temp!=null && listIndex <  pos){
            prev = temp;
            temp = temp.next;
            listIndex+=1;
        }

        prev.next = temp.next;
        return head;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head = null;
        int list_size = Integer.parseInt(buffer.readLine());
        System.out.println();
        while(list_size > 0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        System.out.println();
        int delete_position = Integer.parseInt(buffer.readLine());
        head = deletePosition(head,delete_position);
        printLinkedList(head);
        buffer.close();
    }
}
