import java.io.*;
public class CircularLinkedList {
    public static Node insert(Node head,int data){
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

    public static void printList(Node head){
        Node temp = head;
        System.out.println();
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static Node makeCircular(Node head){
        Node temp = head;
        while(temp.next != null)
            temp = temp.next;
        temp.next = head;
        return head;
    }



    public static boolean hasCycle(Node head){
        Node fast = head.next.next;
        Node slow = head.next;
        while(fast!=null && slow!=null && fast.next!=null){
            if(fast == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }

    public static int nodeContain(Node temp){
        int count = 1;
        Node node = temp.next;
        while(temp != node){
            count++;
            node = node.next;
        }
        return count;
    }

    public static int cycleNode(Node head){
        Node fast = head.next;
        Node slow =head;
        while(slow!=null && fast!=null && fast.next!=null){
            if(fast == slow)
                return nodeContain(slow);
            slow = slow.next;
            fast = fast.next.next;
        }
        return 0;
    }

    public static Node cycleFirstNode(Node head){
        Node fast = head.next.next;
        Node slow = head.next;
        while(slow!=null && fast!=null && fast.next!= null){
            if(fast == slow)
                return fast;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }

    public static Node cycleLastNode(Node head){
        Node slow = head.next;
        Node fast = head.next.next;
        Node last = head;
        while(slow!=null && fast!=null && fast.next!=null){
            if(fast == slow)
                return last;
            last = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        return null;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head = null;
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size > 0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        printList(head);
        head = makeCircular(head);
        if(hasCycle(head))
            System.out.println("\nLinked List has Cycle");
        else
            System.out.println("\nLinked List has not Cycle");
        int loopNodeCount = cycleNode(head);
        System.out.println(loopNodeCount);
        Node newNode = cycleFirstNode(head);
        if(newNode == null)
            System.out.println("\n Cycle Not Found");
        else
            System.out.println("\nCycle First Node is "+newNode.data);
        System.out.println("\n");
        newNode = cycleLastNode(head);
        if(newNode == null)
            System.out.println("\n Cycle Not Found");
        else
            System.out.println("\nCycle Last Node is "+newNode.data);
        System.out.println("\n");
        buffer.close();        
    }    
}
