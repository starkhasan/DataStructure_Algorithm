import java.io.*;
import java.util.Stack;
class Node{
    Node left,right;
    int data;
    Node(int data){
        left = right = null;
        this.data = data;
    }
}
public class IterativeTraversal {
    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data)
                root.left = insert(root.left,data);
            else
                root.right = insert(root.right,data);
            return root;
        }
    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static void inorderItr(Node root){
        if(root!=null){
            Stack<Node> stack = new Stack<Node>();
            Node current = root;
            while(current!= null || !stack.isEmpty()){
                while(current != null){
                    stack.push(current);
                    current = current.left;
                }
                current = stack.pop();
                System.out.print(current.data+" ");
                current = current.right;
            }
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
        String input = "";
        Node root = null;
        while(buffer.readLine()!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        for (String string : strAr) {
            root = insert(root,Integer.parseInt(string));
        }
        //inorder(root);//recursive solution
        System.out.println("\nInorder Traversal Iteratively : ");
        inorderItr(root);
        buffer.close();
    }
}
