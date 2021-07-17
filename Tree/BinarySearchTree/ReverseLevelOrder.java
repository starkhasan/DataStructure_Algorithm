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
public class ReverseLevelOrder{

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

    static int height(Node root){
        if(root == null)
            return -1;
        else
            return Math.max(height(root.left)+1,height(root.right)+1);
    }

    static void bfs(Node root){
        var treeHeight = height(root);
        for (int i = treeHeight; i >= 0; i--) {
            levelPrint(root,i);
        }
    }

    static void levelPrint(Node focusNode,int level){
        if(focusNode!=null){
            if(level == 0)
                System.out.print(focusNode.data+" ");
            else{
                levelPrint(focusNode.left, level-1);
                levelPrint(focusNode.right, level-1);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node root = null;
        var input = scanner.nextLine().split(" ");
        for (String string : input) {
            root = insert(root,Integer.parseInt(string));
        }
        System.out.println("\nReverse Level Order Traversal : ");
        bfs(root);
        scanner.close();
    }
}