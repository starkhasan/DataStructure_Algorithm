import java.util.*;
import java.io.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
class Implementation{
    static Node root;
    static void insert(Node current,int data){
        if(current == null){
            current = new Node(data);
            return;
        }else{
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(current);
            while(!queue.isEmpty()){
                current = queue.peek();
                queue.remove();
                if(current.left == null){
                    current.left = new Node(data);
                    break;
                }else{
                    queue.add(current.left);
                }

                if(current.right == null){
                    current.right = new Node(data);
                    break;
                }else{
                    queue.add(current.right);
                }
            }
        }
    }


    // static void insert(Node temp, int key)
    // {
 
    //     if (temp == null) {
    //         root = new Node(key);
    //         return;
    //     }
    //     Queue<Node> q = new LinkedList<Node>();
    //     q.add(temp);
 
    //     // Do level order traversal until we find
    //     // an empty place.
    //     while (!q.isEmpty()) {
    //         temp = q.peek();
    //         q.remove();
 
    //         if (temp.left == null) {
    //             temp.left = new Node(key);
    //             break;
    //         }
    //         else
    //             q.add(temp.left);
 
    //         if (temp.right == null) {
    //             temp.right = new Node(key);
    //             break;
    //         }
    //         else
    //             q.add(temp.right);
    //     }
    // }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        
        System.out.println("Inorder Before Insertion : ");
        inorder(root);

        insert(root,12);
        System.out.println("\nInorder After Insertion : ");
        inorder(root);
        scanner.close();
    }
}