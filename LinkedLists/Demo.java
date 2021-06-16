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

    static Node makeCycle(Node head){
        var temp = head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = head;
        return head;
    }

    static boolean hasCycle(Node head){
        var slow = head.next;
        var fast = head.next.next;
        while(slow != null && fast!= null && fast.next!= null){
            if(slow == fast)
                return true;    
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node head = null;
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")){
            head = insert(head,Integer.parseInt(string));
        }       
        printLinkedList(head);
        head = makeCycle(head);
        var result = hasCycle(head);
        if(result)
            System.out.println("Yes Loop is Present");
        else
            System.out.println("No! Loop not present");
        scanner.close();
    }
}