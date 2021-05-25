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
public class RotateClock {

    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            var current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new Node(data);
            return head;
        }
    }

    static void printList(Node head){
        System.out.println();
        var temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static int listSize(Node head){
        if(head == null)
            return 0;
        else
            return 1+listSize(head.next);
    }

    static Node makeCycle(Node head){
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = head;
        return head;
    }

    static boolean hasCycle(Node head){
        if(head == null || head.next == null || head.next.next == null)
            return false;
        Node fast = head.next.next;
        Node slow = head.next;
        while(slow!=null && fast!=null && fast.next!=null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

    static Node rotateList(Node head,int k){
        var size = listSize(head);
        var n = size;
        if(n<=1 || k == 0)
            return head;
        else{
            n = k%n;
            System.out.println("Remainder = "+n);
            if(n == 0)
                return head;
            else{
                printList(head);
                head = makeCycle(head);
                k = size - n;
                var count = 1;
                var temp = head;
                System.out.println("Head data = "+temp.data);
                while(count < k){
                    count+=1;
                    temp = temp.next;
                }
                head = temp.next;
                temp.next = null;
                return head;
            }
        }
    }



    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            Node head = null;
            var input = "";
            var isFirst = true;
            var k = 0;
            while(scanner.hasNext()){
                if(isFirst){
                    isFirst = false;
                    input = scanner.nextLine();
                }else{
                    k = Integer.parseInt(scanner.nextLine());
                }
            }
            var strAr = input.split(" ");
            for (var str : strAr) {
                head = insert(head,Integer.parseInt(str));
            }
            printList(head);
            head = rotateList(head, k);
            printList(head);;
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
