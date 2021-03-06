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
class Demo{

    static int difference = Integer.MAX_VALUE;
    static int nodeData = 0;
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

    
    static void closetElement(Node root,int k){
        if(root != null){
            if(difference > Math.abs(k-root.data)){
                difference = Math.abs(k-root.data);
                nodeData = root.data;
            }
            closetElement(root.left, k);
            closetElement(root.right, k);
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
        closetElement(root,12);
        System.out.println("closest Element = "+nodeData);
        scanner.close();
    }
}