import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class SearchElement {
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

    public static void printLinkedList(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static boolean searchItem(Node head,int search){
        Node temp = head;
        while(temp!=null){
            if(temp.data == search)
                return true;
            temp = temp.next;
        }
        return false;
    }

    public static boolean searchRecursive(Node temp,int search){
        if(temp == null) 
            return false;
        if(temp.data == search)
            return true;
        return searchRecursive(temp.next, search);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head = null;
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size>0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        printLinkedList(head);
        System.out.println();
        int searchElement = Integer.parseInt(buffer.readLine());
        if(searchRecursive(head, searchElement))
            System.out.println("Element Present");
        else
            System.out.println("Not Found!");
        buffer.close();
    }   
}
