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
public class NthNodeFromLast {
    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new Node(data);
            return head;
        }
    }

    static void printLinkedList(Node head){
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
            return 1 + listSize(head.next);
    }

    static Node lastNode(Node head,int lastPos){
        var size = listSize(head);
        lastPos = size + 1 - lastPos;
        var count = 1;
        var temp = head;
        while(temp!=null){
            if(count == lastPos)
                return temp;
            count+=1;
            temp = temp.next;
        }
        return null;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var lastIndex = 0;
        Node head = null;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                lastIndex = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")){
            head = insert(head, Integer.parseInt(string));
        }
        printLinkedList(head);
        var newNode = lastNode(head, lastIndex);
        if(newNode != null)
            System.out.println("\nNode from Last = "+newNode.data);
        else
            System.out.println("\nNode Not Found");
        scanner.close();
    }
}
