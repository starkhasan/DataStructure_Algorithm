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
public class Demo{
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

    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }

    static Node deletion(Node root,int key){
        if(root == null)
            return root;
        
        if(key < root.data)
            root.left = deletion(root.left, key);
        else if(key > root.data)
            root.right = deletion(root.right, key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            else{
                root.data = minValue(root.right);
                root.right = deletion(root.right, root.data);
            }
        }

        return root;
    }

    static int minValue(Node root){
        var temp = root.data;
        while(root.left!=null){
            temp = root.left.data;
            root = root.left;
        }
        return temp;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node root = null;
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")){
            root = insert(root,Integer.parseInt(string));
        }
        System.out.println("\nInorder Traversal of Binary Search Tree : ");
        inorder(root);
        System.out.println("\nDelete Node in Binary Search Tree : ");
        root = deletion(root, 7);
        inorder(root);
        scanner.close();
    }
}