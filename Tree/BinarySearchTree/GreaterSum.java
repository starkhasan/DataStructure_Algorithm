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
public class GreaterSum {

    static int temp = 0;

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

    static int calculateSum(Node root){
        int sum = 0,leftSum = 0,rightSum = 0;
        if(root == null)
            return 0;
        else{
            if(root.left != null)
                leftSum = calculateSum(root.left);
            
            if(root.right!=null)
                rightSum =  calculateSum(root.right);

            sum = root.data + leftSum + rightSum;
            return sum;
        }
    }

    static void graterTree(Node root){
        if(root!=null){
            graterTree(root.left);
            root.data = temp - root.data;
            temp = root.data;
            graterTree(root.right);
        }
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
        int tree_size = Integer.parseInt(buffer.readLine());
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        inorder(root);
        temp = calculateSum(root);
        System.out.println("\nTotal Sum = "+temp);
        graterTree(root);
        inorder(root);
        buffer.close();
    }
}
