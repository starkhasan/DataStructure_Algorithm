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

public class LeafNodeCount {

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

    static int leafNode(Node root){
        if(root == null)
            return 0;
        else{
            var count = 0;
            if(root.left == null && root.right == null)
                count+=1;
            count+=leafNode(root.left);
            count+=leafNode(root.right);
            return count;
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
        System.out.println("Total Leaf Node = "+leafNode(root));
        scanner.close();
    }
}
