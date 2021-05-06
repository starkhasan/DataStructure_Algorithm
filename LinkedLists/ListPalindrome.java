//Using Stack Implementation 
import java.io.*;
public class ListPalindrome {
    public static Node insertList(Node head,int data){
        if(head == null)
            head = new Node(data);
        else{
            Node current = head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(data);
        }
        return head;
    }


    public static Node insertStack(Node head,int data){
        Node newNode = new Node(data);
        if(head == null)
            head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    public static void printList(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static int getSize(Node head){
        if(head == null)
            return 0;
        else
            return 1+getSize(head.next);
    }

    public static boolean checkPalindrome(Node listHead,Node stackHead){
        int listSize = getSize(listHead);
        int stackSize = getSize(stackHead);
        if(listSize != stackSize)
            return false;

        while(listHead!=null){
            if(listHead.data != stackHead.data)
                return false;
            listHead = listHead.next;
            stackHead = stackHead.next;
        }
        return true;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Size");
        int list_size = Integer.parseInt(buffer.readLine());
        Node listHead = null;
        Node stackHead =null;
        int _inputData = 0;
        while(list_size > 0){
            _inputData = Integer.parseInt(buffer.readLine());
            listHead = insertList(listHead, _inputData);
            stackHead = insertStack(stackHead, _inputData);
            list_size-=1;
        }

        if(checkPalindrome(listHead, stackHead))
            System.out.println("Palindrome");
        else    
            System.out.println("Not Palindrome");
    }
}


// We can also implement this using reverse of linked list and recursion
