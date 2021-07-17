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

    static int count = 1;

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
                if(count == 0){
                    System.out.print(temp.data+" ");
                    break;
                }else
                    count-=1;
                current = temp.left;
            }
        }
    }

    static int maxNode(Node focusNode){
        if(focusNode.right == null)
            return focusNode.data;
        else
            return maxNode(focusNode.right);
    }

    static int secondMaxNode(Node focusNode,int max){
        if(focusNode.right.data == max)
            return focusNode.data;
        else
            return secondMaxNode(focusNode.right, max);
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine().split(" ");
        Node root = null;
        for (String string : input) {
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root);
        var max = maxNode(root);
        var result = secondMaxNode(root, max);
        System.out.println("\nSecond Max Node = "+result);
        scanner.close();
    }
}
