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
public class SortLinkedList {
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

    static Node sortLinkedList(Node head){
        var temp = head;
        Node newHead = null;
        while(temp!=null){
            if(newHead == null){
                newHead = new Node(temp.data);
            }else if(newHead.data >= temp.data){
                var newNode = new Node(temp.data);
                newNode.next = newHead;
                newHead = newNode;
            }else{
                var current = newHead;
                while(current.next != null){
                    if(current.data < temp.data && current.next.data >= temp.data)
                        break;
                    current = current.next;
                }
                var tempNode = new Node(temp.data);
                if(current.next == null)
                    current.next = tempNode;
                else{
                    tempNode.next = current.next;
                    current.next = tempNode;
                }    
            }
            temp = temp.next;
        }
        return newHead;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node head = null;
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")) {
            head = insert(head, Integer.parseInt(string));
        }
        printLinkedList(head);
        head = sortLinkedList(head);
        System.out.println();
        printLinkedList(head);
        scanner.close();
    }    
}
