import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class AddLinkedListNumber {

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

    static Node addLinkedList(Node head1,Node head2){
        Node newNode = null;
        Node first = head1;
        Node second = head2;
        int remainder = 0;
        int temp = 0;

        while(first!=null || second!=null){
            if(first!=null){
                temp+=first.data;
                first = first.next; 
            }

            if(second!=null){
                temp+=second.data;
                second = second.next;
            }
            if(temp/10 > 0){
                if(first == null && second == null)
                    newNode = insert(newNode, temp);
                else{
                    remainder = temp%10;
                    newNode = insert(newNode, remainder);
                    temp = temp/10;
                }
            }else{
                newNode = insert(newNode, temp);
                temp = 0;
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
        Node newNode = addLinkedList(head,headSecond);
        printList(newNode);
        buffer.close();
    }
}
