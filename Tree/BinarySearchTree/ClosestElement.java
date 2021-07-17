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
public class ClosestElement {
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

    
    static void closestElement(Node root,int k){
        if(root != null){
            if(difference > Math.abs(k-root.data)){
                difference = Math.abs(k-root.data);
                nodeData = root.data;
            }
            closestElement(root.left, k);
            closestElement(root.right, k);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        String[] input = null;
        Node root = null;
        var element = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine().split(" ");
            }else
                element = Integer.parseInt(scanner.nextLine());
        }
        for (String string : input) {
            root = insert(root,Integer.parseInt(string));
        }
        closestElement(root,element);
        System.out.println("closest Element = "+nodeData);
        scanner.close();
    }
}
