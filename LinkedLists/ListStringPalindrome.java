import java.io.*;
class Node{
    Node next;
    String data;
    Node(String data){
        this.data = data;
        next = null;
    }
}
public class ListStringPalindrome {
    public static Node insert(Node head,String data){
        if(head == null)
            head = new Node(data);
        else{
            Node current = head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = new Node(data);
        }
        return head;
    }

    public static void printList(Node head){
        Node temp = head;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static boolean isPalindrome(String data){
        StringBuffer strBuffer = new StringBuffer(data);
        if(data.equals(strBuffer.reverse().toString()))
            return true;
        return false;
    }

    public static boolean checkPalindrome(Node head){
        String data = "";
        Node temp = head;
        while(temp!=null){
            data += temp.data;
            temp = temp.next;
        }

        return isPalindrome(data);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int list_size = Integer.parseInt(buffer.readLine());
        Node head = null;
        while(list_size>0){
            head = insert(head,buffer.readLine());
            list_size-=1;
        }
        printList(head);
        if(checkPalindrome(head))
            System.out.println("\nLinkedList String is Palindrome");
        else
            System.out.println("\nLinkedList String is not Palindrome");
        buffer.close();
    }
}
