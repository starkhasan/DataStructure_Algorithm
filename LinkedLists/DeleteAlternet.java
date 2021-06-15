import java.util.*;
import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class DeleteAlternet{  

    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            Node current = head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(data);
            return head;
        }
    }

    static void printLinkedList(Node head){
        var temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node deleteAlternet(Node head){
        var prev = head;
        var current = head.next;
        while(prev.next!=null && current.next!=null){
            prev.next = current.next;
            prev = prev.next;
            if(prev.next != null)
                current = prev.next;
        }
        prev.next = null;
        return head;
    } 

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node head = null;
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")) {
            head = insert(head, Integer.parseInt(string));
        }
        printLinkedList(head);
        System.out.println("\nDelete Alternet");
        head = deleteAlternet(head);
        printLinkedList(head);
        scanner.close();
    }
}