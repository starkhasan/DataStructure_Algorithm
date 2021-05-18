import java.io.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class NodeDIstance {
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

    static Node lca(Node root,int n1,int n2){
        while(root!=null){
            if(root.data > n1 && root.data > n2)
                root = root.left;
            else if(root.data < n2 && root.data < n1)
                root = root.right;
            else break;
        }
        return root;
    }

    static int depthNode(Node root,int key){
        if(root.data == key)
            return count;
        if(root.data > key){
            count+=1;
            return depthNode(root.left, key);
        }else{
            count+=1;
            return depthNode(root.right, key);
        }
        
    }

    public static void main(String[] args) throws IOException{
       BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
       String input = "";
       Node root = null;
       while(buffer.readLine()!=null){
           input = buffer.readLine();
       }
       String[] strAr = input.split(" ");
       for (String string : strAr) {
           root = insert(root,Integer.parseInt(string));
       }
       inorder(root);
       Node temp = lca(root, 3, 9);
       int firstDistance = depthNode(temp, 3);
       count = 0;
       int secondDistance = depthNode(temp, 9);
       System.out.println("\nShortest Distance Between Nodes = "+(firstDistance+secondDistance));
       buffer.close();
   } 
}
