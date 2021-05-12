import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class Implementation {
    static int getHeight(Node root){
        if(root == null)
            return -1;
        else
            return Math.max(getHeight(root.left)+1,getHeight(root.right)+1);
    }

    static Node insert(Node root,int data){
        if(root == null){
            return new Node(data);
        }else{
            Node current = root;
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node temp = queue.peek();
                queue.remove();
                if(temp.left == null){
                    current.left = new Node(data);
                    break;
                }else{
                    if(temp.right != null)
                        current = current.left;
                    queue.add(temp.left);
                }

                if(temp.right == null){
                    current.right = new Node(data);
                    break;
                }else{
                    queue.add(temp.right);
                }
            }
            return root;
        }
    }


    static void inorder(Node temp){
        if(temp!=null){
            inorder(temp.left);
            System.out.print(temp.data+" ");
            inorder(temp.right);
        }
    }

    static void preorder(Node temp){
        if(temp!=null){
            System.out.print(temp.data+" ");
            preorder(temp.left);
            preorder(temp.right);
        }
    }

    static void postorder(Node temp){
        if(temp!=null){
            postorder(temp.left);
            postorder(temp.right);
            System.out.print(temp.data+" ");
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
        System.out.println("\nInorder Traversal");
        inorder(root);
        System.out.println("\nPreorder Traversal");
        preorder(root);
        System.out.println("\nPostorder Traversal");
        postorder(root);
        System.out.print("\nHeight of Tree : ");
        int height = getHeight(root);
        System.out.print(height);
        buffer.close();
    }
}
