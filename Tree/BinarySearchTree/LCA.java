import java.io.*;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class LCA {

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

    static Node lca(Node root,int n1,int n2){
        while(root != null){
            if(root.data > n1 && root.data > n2)
                root = root.left;
            else if(root.data < n1 && root.data < n2)
                root = root.right;
            else break;
        }
        return root;
    }

    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node root = null;
        var input = "";
        var n1 = 0;
        var n2 = 0;
        var isFirst = true;
        var isSecond = true;
        while(scanner.hasNext()){
            if(isFirst){
                input = scanner.nextLine();
                isFirst = false;
            }else if(isSecond){
                isSecond = false;
                n1 = Integer.parseInt(scanner.nextLine());
            }else{
                n2 = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")) {
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root);
        Node temp = lca(root,n1,n2);
        if(temp!=null)
            System.out.println("LCA Node = "+temp.data);
        scanner.close();        
    }
}
