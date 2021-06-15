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
public class InsertAtMiddle {
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

    static int lengthList(Node head){
        if(head == null)
            return 0;
        else
            return 1 + lengthList(head.next);
    }

    static Node insertAtMiddle(Node head,int item){
        var n = lengthList(head);
        if(n%2 == 0)
            n = n/2;
        else
            n = (n+1)/2;
        var count = 1;
        var temp = head;
        while(count < n){
            temp = temp.next;
            count+=1;
        }
        var newNode = new Node(item);
        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node head = null;
        var input = "";
        var isFirst = true;
        var item = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                item = Integer.parseInt(scanner.nextLine());
        }
        for (String string : input.split(" ")) {
            head = insert(head, Integer.parseInt(string));
        }
        printLinkedList(head);
        System.out.println();
        var newHead = insertAtMiddle(head,item);
        System.out.println();
        printLinkedList(newHead);
        scanner.close();
    }

}
