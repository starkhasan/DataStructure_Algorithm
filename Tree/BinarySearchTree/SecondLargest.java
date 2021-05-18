import java.io.*;
import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class SecondLargest {

    static int count = 2;

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
            Stack<Node> stack = new Stack<Node>();
            Node current = root;
            while(current != null|| !stack.isEmpty()){
                while(current!=null){
                    stack.push(current);
                    current = current.right;
                }
                Node temp = stack.pop();
                
                if(count == 1){
                    System.out.print(temp.data+" ");
                    break;
                }else
                    count-=1;
                current = temp.left;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
        String input = "";
        Node root = null;
        while(buffer.readLine()!= null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        for (String string : strAr) {
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root);
        buffer.close();
    }
}
