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
public class DeleteCircularList {
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

    static void printCircularList(Node head){
        var first = head;
        var temp = head.next;
        System.out.print(first.data+" ");
        while(temp != first){
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



    static Node getLastNode(Node head){
        var temp = head.next;
        var first = head;
        while(temp.next != first){
            temp = temp.next;
        }
        return temp;
    }

    static Node deleteItem(Node head,int item){
        var temp = head;
        var lastNode = getLastNode(head);
        Node prev = null;
        if(head.data == item){
            head = temp.next;
            lastNode.next = head;
            temp.next = null;
        }else{
            while(temp.data != item){
                prev = temp;
                temp = temp.next;
            }
            prev.next = temp.next;
            temp.next = null;
        }
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
        head = deleteItem(head, item);
        System.out.println();
        printCircularList(head);
        scanner.close();
    }
}
