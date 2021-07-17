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
    static int count = 0;
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

    static void inorder(Node root,int n){
        if(root!=null ){
            inorder(root.left,n);
            count+=1;
            if(count == n){
                System.out.println(root.data);
                return;
            }
            inorder(root.right,count);
        }
    }


    static int countNode(Node focusNode){
        if(focusNode == null)
            return 0;
        else
            return 1+countNode(focusNode.left)+countNode(focusNode.right);
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine().split(" ");
        Node root =null;
        for (String string : input) {
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root, 4);
        System.out.println("\nCount Nodes = "+countNode(root));
        scanner.close();
    }
}