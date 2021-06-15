import java.util.*;
import java.io.*;
public class AlternetOddEven {
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

    static Node alternetOddEven(Node head){
        var temp = head;
        Node newHead = null;
        while(temp!=null){
            if(temp.data %2 != 0){
                newHead = insert(newHead,temp.data);
            }
            temp = temp.next;
        }

        temp = head;
        var oddHead = newHead;
        while(temp != null){
            if(temp.data%2 == 0){
                var newNode = new Node(temp.data);
                if(oddHead.next != null){
                    newNode.next = oddHead.next;
                    oddHead.next = newNode;
                    oddHead = oddHead.next.next;
                }else{
                    oddHead.next = newNode;
                    oddHead = oddHead.next;
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
        System.out.println();
        var newHead = alternetOddEven(head);
        System.out.println();
        printLinkedList(newHead);
        scanner.close();
    }
}
