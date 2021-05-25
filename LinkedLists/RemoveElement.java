import java.util.*;
import java.io.*;
public class RemoveElement {
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

    static void printList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node removeElement(Node head,int element){
        if(head == null)
            return head;
        else{
            Node tempHead = null;
            Node temp = head;
            while(temp!=null){
                if(temp.data != element)
                    tempHead = insert(tempHead, temp.data);
                temp = temp.next;
            }

            return tempHead;
        }
    }
    

    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node head = null;
        var input = "";
        var element = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                element = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")) {
            head = insert(head, Integer.parseInt(string));
        }
        head = removeElement(head,element);
        printList(head);
        scanner.close();
    } 
}
