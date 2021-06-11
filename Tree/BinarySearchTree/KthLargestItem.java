import java.util.*;
import java.io.*;
class Node{
    Node left;
    Node right;
    int data;
    int rCount = 0;
    Node(int data){
        this.data = data;
        left = right = null;
        rCount = 0;
    }
}
public class KthLargestItem {
    static int largestItem = 0;
    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data)
                root.left = insert(root.left, data);
            else{
                root.rCount+=1;
                root.right = insert(root.right, data);
            }
            return root;
        }
    }

    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.right);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.left);
        }
    }

    static void kLargestItem(Node root,int k){
        if(root == null)
            return;
        if((root.rCount+1) == k){
            largestItem = root.data;
            return;
        }else if(root.rCount < k){
            largestItem = root.data;
            k = k - (root.rCount + 1);
            kLargestItem(root.left, k);
        }else
            kLargestItem(root.right, k);
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node root = null;
        while (scanner.hasNext()) {
            input = scanner.nextLine();
        }
        for (String string : input.split(" ")){
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root);
        kLargestItem(root,3);
        System.out.println("Kth Largest Item = "+largestItem);
        scanner.close(); 
    }
}
