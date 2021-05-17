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
            Node cur;
            if(data <= root.data){
                cur = insert(root.left,data);
                root.left = cur;
            }else{
                cur = insert(root.right,data);
                root.right = cur;
            }
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
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int tree_size = Integer.parseInt(buffer.readLine());
        Node root = null;
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size -=1;
        }
        Node temp = lca(root,14,8);
        if(temp!=null)
            System.out.println("LCA Node = "+temp.data);
        buffer.close();        
    }
}
