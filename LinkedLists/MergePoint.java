import java.io.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class MergePoint {

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

    static int listCount(Node head){
        if(head == null)
            return 0;
        else
            return 1 + listCount(head.next);
    }

    static int getIntersection(Node head1,Node head2){
        //this solution will work when the item in LinkedList will be distinct
        int c1 = listCount(head1);
        int c2 = listCount(head2);
        int d = 0;
        if(c1 > c2){
            d = c1 - c2;
            return _intersectionPoint(d,head1,head2);
        }else{
            d = c2 - c1;
            return _intersectionPoint(d,head2,head1);
        }
    }

    static int _intersectionPoint(int d,Node node1,Node node2){
        Node current1 = node1;
        Node current2 = node2;
        for (int i = 0; i < d; i++) {
            if(current1 == null)
                return -1;
            current1 = current1.next;
        }
        while(current1 != null && current2 != null){
            if(current1.data == current2.data)
                return current1.data;
            current1 = current1.next;
            current2 = current2.next;
        }
        return -1;
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node head1 = null;
        Node head2 = null;
        System.out.println("Enter Size of First Linked List : ");
        int list_size = Integer.parseInt(buffer.readLine());
        System.out.println("Enter Element : ");
        while(list_size > 0){
            head1 = insert(head1, Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        System.out.println("Enter Size of Second Linked List");
        list_size = Integer.parseInt(buffer.readLine());
        System.out.println("Enter Element");
        while(list_size > 0){
            head2 = insert(head2,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        int result = getIntersection(head1,head2);
        if(result > 0)
            System.out.println("Found the Intersection point : "+result);
        else
            System.out.println("Intersection point not found!!");
        buffer.close();
    }
}
