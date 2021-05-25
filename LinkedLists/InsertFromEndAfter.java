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
public class InsertFromEndAfter {
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

    static int listSize(Node head){
        if(head == null)
            return 0;
        else    
            return 1+listSize(head.next);
    }

    static Node insertEnd(Node head,int n,int k){
        Node temp = head;
        Node newNode  = new Node(k);
        int size = listSize(head);
        size = size - n;
        if(size == 0){
            newNode.next = temp.next;
            temp.next = newNode;
        }else{
            var count = 0;
            while(count < size){
                temp = temp.next;
                count+=1;
            }
            if(temp.next == null){
                temp.next = newNode;
                newNode.next = null;
            }else{
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
        return head;
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var n = 0;
        var x = 0;
        var isFirst = true;
        var isSecond = true;
        Node head = null;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else if(isSecond){
                isSecond = false;
                n = Integer.parseInt(scanner.nextLine());
            }else{
                x = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")) {
            head = insert(head,Integer.parseInt(string));
        }

        head = insertEnd(head, n, x);
        printList(head);
        scanner.close();
    }
}
