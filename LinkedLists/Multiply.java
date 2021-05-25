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
public class Multiply{
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

    static Node reverse(Node head){
        Node temp = head;
        Node current = head;
        Node prev = null;
        while(temp!=null){
            current = temp.next;
            temp.next = prev;
            prev = temp;
            temp = current;
        }
        return prev;
    }


    static long multiplication(Node head1,Node head2){
        Node tempA = head1;
        Node tempB = head2;
        var N = 1000000007;
        var num1 = 0;
        var num2 = 0;
        while(tempA!=null || tempB!=null){
            if(tempA!=null){
                num1 = ((num1)*10)%N + tempA.data;
                tempA = tempA.next;
            }

            if(tempB!=null){
                num2 = ((num2)*10)%N + tempB.data;
                tempB = tempB.next;
            }
        }


        return ((num1%N)*(num2%N))%N;
    }

    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node head1 = null;
        Node head2 = null;
        var inputFirst = "";
        var inputSecond = "";
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                inputFirst = scanner.nextLine();
            }else{
                inputSecond = scanner.nextLine();
            }
        }
        for (String string : inputFirst.split(" ")) {
            head1 = insert(head1,Integer.parseInt(string));
        }

        for (String string : inputSecond.split(" ")) {
            head2 = insert(head2, Integer.parseInt(string));
        }

        var result = multiplication(head1, head2);
        System.out.println("Multiplication of two Number = "+result);
        scanner.close();
    }
}