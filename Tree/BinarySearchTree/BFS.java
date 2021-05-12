import java.io.*;
import java.util.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class BFS {
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

    static int getHeight(Node root){
        if(root == null)
            return -1;
        else{
            return Math.max(getHeight(root.left)+1 ,getHeight(root.right)+1);
        }
    }

    static void bfs(Node root){
        int treeHeight = getHeight(root);
        for (int i = 0; i <= treeHeight; i++) {
            levelTraverse(root, i);
        }
    }

    static void levelTraverse(Node root,int level){
        if(root!=null){
            if(level == 0)
                System.out.print(root.data+" ");
            else if(level > 0){
                levelTraverse(root.left, level-1);
                levelTraverse(root.right, level-1);
            }
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        int tree_Size = Integer.parseInt(buffer.readLine());
        while(tree_Size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_Size-=1;
        }
        System.out.println("\nBreadth First Search or Level Order Traversal");
        bfs(root);
        buffer.close();
    }
}
