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
public class Traversal {
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

    static void inOrder(Node root){
        if(root!=null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    static void preOrder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static void postOrder(Node root){
        if(root!=null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        int tree_size = Integer.parseInt(buffer.readLine());
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        System.out.println("\nInorder Traversal : ");
        inOrder(root);
        System.out.println("\nPreorder Traversal : ");
        preOrder(root);
        System.out.println("\nPostorder Traversal : ");
        postOrder(root);
        buffer.close();
    }
}
