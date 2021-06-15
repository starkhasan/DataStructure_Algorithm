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
public class CountOccurence {
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

    static int occurenceCount(Node head,int key){
        var count = 0;
        var temp = head;
        while(temp!=null){
            if(temp.data == key)
                count++;
            temp = temp.next;
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        Node head = null;
        var key = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                key = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")) {
            head = insert(head, Integer.parseInt(string));
        }
        var count = occurenceCount(head, key);
        System.out.println("\nOccurrence of "+key+" = "+count);
        scanner.close();
    }
}
