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
public class Height {
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

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static int getHeight(Node root){
        if(root == null)
            return -1;
        else{
            int ldepth = getHeight(root.left);
            int rdepth = getHeight(root.right);
            if(ldepth > rdepth)
                return ldepth+1;
            else
                return rdepth+1;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int tree_size = Integer.parseInt(buffer.readLine());
        Node root = null;
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        System.out.println("\nInorder Traversal : ");
        inorder(root);
        int height = getHeight(root);
        System.out.println("\nHeight of Tree = "+height);
    }   
}
