import java.io.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
public class Implementation {
    static Node insert(Node root,int data){
        if(root == null){
            root = new Node(data);
            return root;
        }else{
            Node cur = root;
            if(data <=  root.data){
                cur = insert(root.left,data);
                root.left = cur;
            }else{
                cur =insert(root.right,data);
                root.right = cur;
            }
        }
        return root;
    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        System.out.println("Enter Tree Size : ");
        int tree_size = Integer.parseInt(buffer.readLine());
        while(tree_size > 0){
            root = insert(root, Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        inorder(root);
        buffer.close();
    }  
}
