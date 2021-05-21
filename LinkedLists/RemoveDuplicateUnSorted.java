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
public class RemoveDuplicateUnSorted {

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
        System.out.println();
        var temp = head;
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node removeDuplicatNode(Node head){
        //Basically It's kind of Hashing Method to remove the Duplicate from UnSorted LinkedList.
        Node newHead = null;
        var _listLinked = new ArrayList<Integer>();
        var temp = head;
        while (temp!=null) {
            if(!_listLinked.contains(temp.data)){
                _listLinked.add(temp.data);
                newHead = insert(newHead,temp.data);
            }
            temp = temp.next;
        }
        return newHead;
    }


    public static void main(String[] args) {
       try {
           var file = new File("Input.txt");
           var scanner = new Scanner(file);
           var input = "";
           Node head = null;
           while(scanner.hasNext()){
               input = scanner.nextLine();
           }
           var strAr =input.split(" ");
           for (var string : strAr) {
               head = insert(head,Integer.parseInt(string));
           }
           printLinkedList(head);
           System.out.println("\nRemove Duplicate Element From UnSorted LinkedList : ");
           head = removeDuplicatNode(head);
           printLinkedList(head);
           scanner.close();
       } catch (FileNotFoundException e) {
           System.out.println(e.getMessage());
       } 
    }
}
