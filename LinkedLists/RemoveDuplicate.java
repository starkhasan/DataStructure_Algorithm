//Removing Dulicate From Sorted LinkedList
// import java.io.*;
// class Node{
//     Node next;
//     int data;
//     Node(int data){
//         this.data = data;
//         next = null;
//     }
// }
// public class RemoveDuplicate {
//     public static Node insert(Node head,int data){
//         if(head == null)
//             head = new Node(data);
//         else{
//             Node current = head;
//             while(current.next!=null){
//                 current = current.next;
//             }
//             current.next = new Node(data);
//         }
//         return head;
//     }

//     public static void printList(Node head){
//         System.out.println();
//         Node temp = head;
//         while(temp!=null){
//             System.out.print(temp.data+" ");
//             temp = temp.next;
//         }
//     }

//     public static void removeDuplicate(Node head){
//         Node temp = head;
//         while(temp.next!=null){
//             System.out.print(temp.data+" ");
//             if(temp.data == temp.next.data){
//                 temp.next = temp.next.next;  
//             }else{
//                 temp = temp.next;
//             }
//         }
//     }
//     public static void main(String[] args) throws IOException{
//         BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//         System.out.println("Enter Size");
//         int list_size = Integer.parseInt(buffer.readLine());
//         Node head = null;
//         while(list_size > 0){
//             head = insert(head, Integer.parseInt(buffer.readLine()));
//             list_size-=1;
//         }
//         removeDuplicate(head);
//         //printList(head);
//     }
// }



//Program for remove duplicate form unsorted LinkedList

import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class RemoveDuplicate {
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
        System.out.println();
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public static void removeDuplicate(Node head){
        Node temp = head;
        while(temp.next!=null){
            System.out.print(temp.data+" ");
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;  
            }else{
                temp = temp.next;
            }
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Size");
        int list_size = Integer.parseInt(buffer.readLine());
        Node head = null;
        while(list_size > 0){
            head = insert(head, Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
        removeDuplicate(head);
        //printList(head);
    }
}