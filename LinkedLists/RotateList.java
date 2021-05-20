import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class RotateList {
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

    static void makeCycle(Node head){
        Node temp = head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = head;
    }

    static Node firstNode(Node head){
        Node slow = head.next;
        Node fast = head.next.next;
        while(slow!=null && fast!=null && fast.next!=null){
            if(fast == slow)
                return slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    static int listSize(Node head){
        if(head == null)
            return 0;
        else
            return 1+listSize(head.next);
    }

    static Node rotation(Node head,int k){
        int size = listSize(head);
        k = k%size;
        if(k != 0){
            makeCycle(head);
            Node first = firstNode(head);
            Node temp = first;
            Node newHead = null;
            int count = 1;
            while(count < k){
                count+=1;
                temp = temp.next;
            }
            newHead = temp.next;
            temp.next = null;
            return newHead;
        }else{
            return head;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head = null;
        System.out.println("Enter LinkedList Size : ");
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size>0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        printList(head);
        System.out.println("\nRotation Times : ");
        int key = Integer.parseInt(buffer.readLine());
        System.out.print("Anti-Clockwise Rotation of Linked List : ");
        head = rotation(head,key);
        printList(head);
        buffer.close();
    }
}
