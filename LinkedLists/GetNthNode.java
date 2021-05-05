import java.io.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class GetNthNode {
    public static void printList(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static Node insert(Node head,int data){
        if(head == null){
            head = new Node(data);
        }else{
            Node current = head;
            while(current.next!= null){
                current = current.next;
            }
            current = new Node(data);
        }
        return head;
    }

    public static int getSize(Node head){
        if(head == null)
            return 0;
        else
            return 1+getSize(head.next);
    }

    public static int getIndexValue(Node head,int index){
        int tempIndex = 0;
        Node temp = head;
        while(temp!=null){
            if(tempIndex == index)
                return temp.data;
            tempIndex+=1;
            temp = temp.next;
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head = null;
        System.out.println("Enter Size of Linked List : ");
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size>0){
            head = insert(head, Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        printList(head);
        int search_element = Integer.parseInt(buffer.readLine());
        search_element = getIndexValue(head, search_element);
        if(search_element != -1)
            System.out.println("Element Found  = "+search_element);
        else
            System.out.println("Element Not Found!");
    }
}
