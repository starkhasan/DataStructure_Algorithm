import java.util.*;
import java.io.*;
public class ReverseKTimes {

    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            Node current = head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(data);
            return  head;
        }
    }

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node reverse(Node head,int k){
        if(head == null)
            return null;
        Node temp = head;
        Node current;
        Node prev = null;
        var count = 0;

        while(temp!=null && count < k){
            current = temp.next;
            temp.next = prev;
            prev = temp;
            temp = current;
            count+=1;
        }

        if(temp!=null)
            head.next = reverse(temp, k);
        return prev;
    }

    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node head = null;
        var input = "";
        var k = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                k = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")) {
            head = insert(head,Integer.parseInt(string));
        }
        printList(head);
        head = reverse(head, k);
        System.out.println();
        printList(head);
        scanner.close();
    }   
}
