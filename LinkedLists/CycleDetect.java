import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class CycleDetect {
    public static Node insert(Node head,int data){
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


    public static boolean hasCycle(Node head){
        Node fast = head.next;
        Node slow = head;
        while(slow!=null && fast!=null && fast.next!=null){
            if(slow == fast)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    } 



    public static int countNode(Node node){
        if(node.next == node)
            return 1;
        else
            return 1+countNode(node.next);
        
    }

    public static int countLoopNodes(Node head){
        Node fast = head.next;
        Node slow = head;
        while(slow!=null && fast!=null && fast.next!=null){
            if(slow == fast)
                return countNode(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        return 0;
    }

    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int list_size = Integer.parseInt(buffer.readLine());
        Node head = null;
        while(list_size>0){
            list_size-=1;
        }
    }    
}
