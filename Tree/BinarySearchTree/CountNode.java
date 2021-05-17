import java.io.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}

public class CountNode {
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

    static int totalNode(Node root){
        if(root == null)
            return 0;
        else
            return 1 + totalNode(root.left) + totalNode(root.right);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int tree_size = Integer.parseInt(buffer.readLine());
        Node root = null;
        while (tree_size > 0) {
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        int total_number_of_node = totalNode(root);
        System.out.println("Total Node = "+total_number_of_node);
        buffer.close();
    }
}
