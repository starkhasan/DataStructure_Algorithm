import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class IntersectionList {
    static Node insert(Node head,int data){
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

    static void printList(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static Node intersectionSortedList(Node headFirst,Node headSecond){
        Node first = headFirst;
        Node second = headSecond;
        Node newNode = null;
        while(first!=null && second !=null){
            if(first.data == second.data){
                newNode = insert(newNode, first.data);
                first = first.next;
                second = second.next;
            }else if(first.data < second.data){
                first =  first.next;
            }else{
                second = second.next;
            }
        }
        return newNode;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Size of First LinkedList : ");
        int list_size = Integer.parseInt(buffer.readLine());
        Node head = null;
        System.out.println("\nEnter Elment in First LinkedList : ");
        while(list_size > 0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        Node headSecond = null;
        System.out.println("\nEnter Size of Second LinkedList : ");
        int list_size1 = Integer.parseInt(buffer.readLine());
        System.out.println("\nEnter Element in Second LinkedList");        
        while(list_size1>0){
            headSecond = insert(headSecond, Integer.parseInt(buffer.readLine()));
            list_size1-=1;
        }
        Node newNode = intersectionSortedList(head,headSecond);
        printList(newNode);
    }
}
