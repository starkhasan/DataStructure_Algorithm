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
public class QuickSortList {
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

    static Node partition(Node start,Node end){
        if (start == end || start == null || end == null)
            return start;
        var key = end.data;
        var curr = start;
        var prev = start;
        var tempData = 0;
        while(start != end){
            if(start.data < key){
                prev = curr;
                tempData = curr.data;
                curr.data = start.data;
                start.data = tempData;
                curr = curr.next;
            }
            start = start.next;
        }
        tempData = curr.data;
        curr.data = end.data;
        end.data = curr.data;
        return prev;
    }

    static Node quickSort(Node head,Node start,Node end){
        if(start != null && start != end || start != end.next){
            Node pivot = partition(start,end);
            quickSort(head, start, pivot);
            quickSort(head, pivot.next, end);
        }
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
        
        scanner.close();
    }
}
