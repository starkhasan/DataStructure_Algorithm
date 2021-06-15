import java.util.*;
import java.io.*;
public class SegregateEvenOdd {
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

    static Node segregateEvenOdd(Node head){
        Node newHead = null;
        var temp = head;
        while(temp!=null){
            if(temp.data %2 == 0)
                newHead = insert(newHead, temp.data);
            temp = temp.next;
        }
        temp = head;
        while(temp!=null){
            if(temp.data %2 != 0)
                newHead = insert(newHead, temp.data);
            temp = temp.next;
        }
        return newHead;
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
        var newHead = segregateEvenOdd(head);
        System.out.println("\nNew LinkedList ");
        printLinkedList(newHead);
        scanner.close();
    }    
}
