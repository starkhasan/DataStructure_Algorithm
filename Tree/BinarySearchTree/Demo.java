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

    static int leadNode(Node root){
        if(root == null)
            return 0;
        else{
            var count = 0;
            if(root.left == null && root.right == null)
                count+=1;
            count+=leadNode(root.left);
            count+=leadNode(root.right);
            return count;
        }
    }

    static int singleChildNode(Node root){
        if(root == null)
            return 0;
        else{
            var count = 0;
            if(root.left != null || root.right!=null){
                System.out.print(root.data+" ");
                count+=1;
            }
            count+=singleChildNode(root.left);
            count+=singleChildNode(root.right);
            return count;
        }
    }

    static Node removeLeadNode(Node root){
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return null;
        root.left = removeLeadNode(root.left);
        root.right =removeLeadNode(root.right);
        return root;
    }

    static int countNode(Node root){
        if(root == null)
            return 0;
        else{
            return countNode(root.left)+countNode(root.right)+1;
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
        System.out.println(leadNode(root));
        System.out.println("Count total Node = "+countNode(root));
        root = removeLeadNode(root);
        System.out.println("Count total Node = "+countNode(root));
        System.out.println("Single Child Node = "+singleChildNode(root));
        scanner.close();
    }
}