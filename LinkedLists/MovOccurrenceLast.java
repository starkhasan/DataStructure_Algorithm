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
public class MovOccurrenceLast {
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

    static Node moveOccurrence(Node head,int item){
        Node newHead = null;
        var temp = head;
        while (temp!=null) {
            if(temp.data == item)
                newHead = insert(newHead, temp.data);
            temp = temp.next; 
        }
        temp = head;
        Node prev = head;
        while(temp!=null){
            if(temp == head && temp.data == item){
                head = temp.next;
                temp.next = null;
                temp = head;
                prev = head;
            }else if(temp.data == item){
                prev.next = temp.next;
                temp = temp.next;
            }else{
                prev = temp;
                temp = temp.next;
            }
        }
        prev.next = newHead;
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
        head = moveOccurrence(head,item);
        printLinkedList(head);
        scanner.close();
    }
}
