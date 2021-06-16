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
public class InsertCircularList {
    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            var current = head;
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

    static Node makeCycle(Node head){
        var temp = head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = head;
        return head;
    }

    static Node insertInCircular(Node head,int item){
        var first = head;
        var temp = head.next;
        while(temp.next != first)
            temp = temp.next;

        var newNode = new Node(item);
        newNode.next = head;
        temp.next = newNode;
        return head;
    } 


    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node head = null;
        var isFirst = true;
        var item = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                item = Integer.parseInt(scanner.nextLine());
        }
        for (String string : input.split(" ")){
            head = insert(head,Integer.parseInt(string));
        }

        printLinkedList(head);
        head = makeCycle(head);
        head = insertInCircular(head, item);
        printLinkedList(head);
        scanner.close();
    }
}
