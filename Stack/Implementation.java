import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class Implementation {

    static Node push(Node top,int data){
        Node newNode = new Node(data);
        if(top == null)
            top = newNode;
        else{
            newNode.next = top;
            top = newNode;
        }
        return top;
    }

    static void printStack(Node top){
        Node temp = top;
        System.out.println();
        while (temp!=null) {
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    static boolean isEmpty(Node top){
        return top == null;
    }

    static int pop(Node top){
        int data = top.data;
        top = top.next;
        return data;
    }



    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node top = null;
        int stack_size = Integer.parseInt(buffer.readLine());
        while(stack_size > 0){
            top = push(top, Integer.parseInt(buffer.readLine()));
            stack_size-=1;
        }
        printStack(top);
        if(isEmpty(top))
            System.out.println("\nStack Empty");
        else
            System.out.println("\nStack is not empty");
        int data = pop(top);
        System.out.println(data);
        buffer.close();
    }
}
