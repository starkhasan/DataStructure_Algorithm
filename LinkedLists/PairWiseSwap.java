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
public class PairWiseSwap {

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

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }   


    static void swap(Node head){
        var temp = head;
        while(temp != null && temp.next != null){
            var tempData = temp.data;
            temp.data = temp.next.data;
            temp.next.data = tempData;
            temp = temp.next.next;
        }
    }


    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node head = null;
        var input = "";
        while(scanner.hasNext()){
            input = scanner.nextLine();
        }
        for (String string : input.split(" ")) {
            head = insert(head,Integer.parseInt(string));
        }
        printList(head);
        swap(head);
        System.out.println("\nPairWise Swap : ");
        printList(head);
        scanner.close();
    }
}
