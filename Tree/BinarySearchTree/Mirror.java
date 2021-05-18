import java.io.*;
import java.util.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Mirror {

    static Node newNode = null;
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

    static Node insertMirror(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data)
                root.right = insertMirror(root.right, data);
            else
                root.left = insertMirror(root.left, data);
            return root;
        }
    }


    static int getHeight(Node root){
        if(root == null)
            return -1;
        else
            return Math.max(getHeight(root.left)+1, getHeight(root.right)+1);
    }

    static void levelOrder(Node root){
        int height = getHeight(root);
        for (int i = 0; i <= height; i++) {
            levelTraverse(root,i);
        }
    }

    static void levelTraverse(Node root,int level){
        if(root!=null){
            if(level == 0)
                newNode = insertMirror(newNode, root.data);
            else if(level > 0)
                levelTraverse(root.left, level-1);
                levelTraverse(root.right, level-1);
        }
    }

    static Node mirrorRecur(Node root){
        if(root == null)
            return root;
        Node left = mirrorRecur(root.left);
        Node right = mirrorRecur(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    static void inorder(Node root){
        if(root!=null){
            Stack<Node> stack = new Stack<Node>();
            Node current = root;
            while(current != null || !stack.isEmpty()){
                while(current!=null){
                    stack.push(current);
                    current = current.left;
                }
                Node temp = stack.pop();
                System.out.print(temp.data+" ");
                current = temp.right;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
        String input = "";
        Node root = null;
        while(buffer.readLine() != null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        for (String string : strAr) {
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root);
        //levelOrder(root);
        newNode = mirrorRecur(root);
        System.out.println("\nMirror of Tree : ");
        inorder(newNode);
        buffer.close();
    }
}
