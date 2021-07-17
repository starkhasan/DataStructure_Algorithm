import java.util.*;
import java.io.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class NodeDegree {
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

    static void nodeDegree(Node root, int element){
        var temp = search(root,element);
        if(temp == null)
            System.out.print("Node not found");
        else if(temp.left != null && temp.right != null)
            System.out.println("2 Degree");
        else
            System.out.println("1 Degree");
    }

    static Node search(Node root,int key){
        if(root!=null){
            if(root.data == key)
                return root;
            else{
                if(root.data < key)
                    return search(root.right, key);
                return search(root.left, key);
            }
        }
        return null;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine().split(" ");
        Node root = null;
        for (var item : input) {
            root = insert(root,Integer.parseInt(item));
        }
        nodeDegree(root,35);
        scanner.close();
    }
}
