import java.util.*;
import java.io.*;
public class MoveLastFrom {
    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            Node current = head;
            while(current.next != null)
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

    static Node moveLastFront(Node head){
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        var newNode = new Node(temp.next.data);
        newNode.next = head;
        head = newNode;
        temp.next = null;
        return head;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node head = null;
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")){
            head = insert(head, Integer.parseInt(string));
        }
        printLinkedList(head);
        System.out.println();
        var newHead = moveLastFront(head);
        printLinkedList(newHead);
        scanner.close();
    }  
}
