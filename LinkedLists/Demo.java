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
class Demo{
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

    static Node removeDuplicateFromSorted(Node head){
        var prev = head;
        var temp = head;
        while(temp!=null){
            if(temp.data != prev.data){
                prev.next = temp;
                prev = temp;
            }
            temp = temp.next;
        }
        prev.next = null;
        return head;
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
        System.out.println();
        var newHead = removeDuplicateFromSorted(head);
        System.out.println();
        printLinkedList(newHead);
        scanner.close();
    }
}