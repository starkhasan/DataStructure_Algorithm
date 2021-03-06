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
public class MinimumNode {
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

    static Node getMin(Node root){
        if(root.left == null)
            return root;
        else
            return getMin(root.left);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        int tree_size = Integer.parseInt(buffer.readLine());
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        Node temp = getMin(root);
        if(temp !=null)
            System.out.println("Minimum Node = "+temp.data);
        buffer.close();
    }
}
