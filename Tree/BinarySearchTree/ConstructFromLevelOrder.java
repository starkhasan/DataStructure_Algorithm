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
public class ConstructFromLevelOrder {
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

    public static void main(String[] args) throws IOException{
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
        System.out.println("\nInorder Traversal : ");
        inorder(root);
        scanner.close();
    }
}
