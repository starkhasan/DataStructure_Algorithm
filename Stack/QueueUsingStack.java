import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class QueueUsingStack {

    static Node insert(Node head,int data){
        Node newNode = new Node(data);
        if(head == null)
            head = newNode;
        else{
            newNode.next = head;
            head = newNode;
        }
        return head;
    }

    static Node pop(Node head){
        Node queueHead = null;
        Node temp = head;
        while(temp != null){
            queueHead = insert(queueHead,temp.data);
            temp = temp.next;
        }
        return queueHead;
    }

    static void printStack(Node head){
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node stackHead = null;
        Node queueHead = null;
        System.out.println("Enter Size of Stack : ");
        int stack_size = Integer.parseInt(buffer.readLine());
        while(stack_size > 0){
            stackHead = insert(stackHead,Integer.parseInt(buffer.readLine()));
            stack_size-=1;
        }
        System.out.println("Stack ");
        printStack(stackHead);
        queueHead = pop(stackHead);
        System.out.println("\nQueue ");
        printStack(queueHead);
        buffer.close();
    }
}
