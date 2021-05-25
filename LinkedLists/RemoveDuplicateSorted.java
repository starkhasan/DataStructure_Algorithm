import java.util.*;
import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class RemoveDuplicateSorted{
    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            var current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new Node(data);
            return head;
        }
    }

    static void printLinkedList(Node head){
        System.out.println("\nLinked List : ");
        var temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node removeDuplicate(Node head){
        var temp = head;
        if(head == null)
            return head;
        while(temp.next!=null){
            if(temp.data == temp.next.data)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            Node head = null;
            var input = "";
            while(scanner.hasNext()){
                input = scanner.nextLine();
            }
            var strAr = input.split(" ");
            for (var string : strAr) {
                head = insert(head,Integer.parseInt(string));
            }
            printLinkedList(head);
            head = removeDuplicate(head);
            printLinkedList(head);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}