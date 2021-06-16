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
public class CountNodeInCircularList {
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


    static int countNodes(Node head){
        var nodeCount = 1;
        var temp = head.next;
        var first = head;
        while(temp!=first){
            nodeCount+=1;
            temp = temp.next;
        }
        return nodeCount;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node head = null;
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")){
            head = insert(head,Integer.parseInt(string));
        }       
        printLinkedList(head);
        head = makeCycle(head);
        var result = countNodes(head);
        System.out.println("Total Node Count = "+result);
        scanner.close();
    }
}
