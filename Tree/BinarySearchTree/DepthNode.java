import java.io.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class DepthNode {

    static int count = 0;

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

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static int depth(Node root,int key){
        if(root == null)
            return -1;
        
        if(root.data == key)
            return count;
        
        if(key < root.data){
            count++;
            return depth(root.left, key);
        }
        count++;
        return depth(root.right,key);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
        String input = "";
        Node root = null;
        while((buffer.readLine()) != null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        for (String string : strAr) {
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root);
        System.out.println("\nEnter Node to Find the Depth From Root");
        int result = depth(root, 5);
        System.out.print(result);
        buffer.close();
    }
}
