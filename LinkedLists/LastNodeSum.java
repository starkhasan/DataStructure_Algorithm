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
public class LastNodeSum {

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

    static int listSize(Node head){
        if(head ==null)
            return 0;
        else
            return 1 + listSize(head.next);
    }

    static void printList(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static int lastSum(Node head,int n){
        var result = 0;
        var count = 0;
        var temp = head;
        var size = listSize(head);
        size = size - n;
        while(temp!=null){
            if(count == size){
                result+=temp.data;
            }else
                count+=1;
            temp = temp.next;
        }

        return result;
    }


    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner  = new Scanner(file);
        Node head = null;
        var input = "";
        var n = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                n = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")) {
            head = insert(head,Integer.parseInt(string));
        }
        printList(head);
        var result = lastSum(head,n);
        System.out.println("\nTotal Summation = "+result);
        scanner.close();
    }   
}
