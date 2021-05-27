import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
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

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static int height(Node root){
        if(root == null)
            return -1;
        else
            return Math.max(height(root.left)+1,height(root.right)+1);
    }

    static void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static int minElement(Node root){
        if(root.left == null)
            return root.data;
        else
            return minElement(root.left);
    }

    static int maxElement(Node root){
        if(root.right == null)
            return root.data;
        else
            return maxElement(root.right);
    }

    static int summation(Node root){
        var sum = 0;
        var leftSum = 0;
        var rightSum = 0;
        if(root == null)
            return 0;
        leftSum = summation(root.left);
        rightSum = summation(root.right);
        sum+=root.data + leftSum + rightSum;
        return sum;
    }


    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node root = null;
        var input = "";
        while(scanner.hasNext()){
            input = scanner.nextLine();
        }
        for (String string : input.split(" ")) {
            root = insert(root,Integer.parseInt(string));   
        }
        System.out.println("Inorder Traversal of Binary Search Tree : ");
        inorder(root);
        var result = summation(root);
        System.out.println("\nTotal Summation = "+result);
        result = maxElement(root);
        System.out.println("\nMax Element in BST = "+result);
        result = minElement(root);
        System.out.println("\nMin Element in BST = "+result);
        scanner.close();
    }
}