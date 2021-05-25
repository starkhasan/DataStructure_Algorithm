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
public class MergeSortedLinkedList {
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

    static int listSize(Node head){
        if(head == null)
            return 0;       
        else
            return 1+listSize(head.next);
    }

    static Node mergeList(Node first,Node second){
        if(first == null)
            return second;
        if(second == null)
            return first;
        Node tempHead = null;
        while(first!= null || second!=null){
            if(first == null){
                tempHead = insert(tempHead,second.data);     
                second = second.next;
            }else if(second == null){
                tempHead = insert(tempHead,first.data);
                first = first.next;
            }else if(first.data == second.data){
                tempHead = insert(tempHead,first.data);
                tempHead = insert(tempHead, second.data);
                first = first.next;
                second = second.next;
            }else if(first.data > second.data){
                tempHead = insert(tempHead,second.data);
                second = second.next;
            }else{
                tempHead = insert(tempHead,first.data);
                first = first.next;
            }
        }
        return tempHead;
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var inputSecond = "";
        var isFirst = true;
        Node head1 = null;
        Node head2 = null;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                inputSecond = scanner.nextLine();
            }
        }
        for (String string : input.split(" ")) {
            head1 = insert(head1, Integer.parseInt(string));
        }

        for (String string : inputSecond.split(" ")) {
            head2 = insert(head2, Integer.parseInt(string));
        }

        Node head = mergeList(head1, head2);
        System.out.println("Merge LinkedList : ");
        printList(head);
        scanner.close();
    }
}
