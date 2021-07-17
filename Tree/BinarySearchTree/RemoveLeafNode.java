import java.io.*;
import java.util.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class RemoveLeafNode {

    //insert node in binary search tree
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

    //Removing leaf nodes
    static Node removeLeafNode(Node root){
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return null;
        root.left = removeLeafNode(root.left);
        root.right = removeLeafNode(root.right);
        return root;
    }

    //count total nodes
    static int countNode(Node root){
        if(root == null)
            return 0;
        else{
            var left = countNode(root.left);
            var right = countNode(root.right);
            return (left+right+1);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine().split(" ");
        Node root = null;
        for (String string : input) {
            root = insert(root,Integer.parseInt(string));
        }

        System.out.println("Total Nodes Before Removing = "+countNode(root));
        root = removeLeafNode(root);
        System.out.println("Total Nodes After Removing = "+countNode(root));
        scanner.close();
    }
}
