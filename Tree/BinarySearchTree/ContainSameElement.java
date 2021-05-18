import java.io.*;
import java.util.*;
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class ContainSameElement {

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

    static void inorder(Node root,List<Integer> _listInorder){
        if(root != null){
            inorder(root.left, _listInorder);
            _listInorder.add(root.data);
            inorder(root.right, _listInorder);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        List<Integer> _listFirstInorder = new ArrayList<Integer>();
        List<Integer> _listSecondInorder = new ArrayList<Integer>();
        System.out.println("Enter Tree Size : ");
        int tree_size = Integer.parseInt(buffer.readLine());
        int tempSize = tree_size;
        System.out.println("\nEnter Element in First BST : ");
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        inorder(root, _listFirstInorder);
        tree_size = tempSize;
        System.out.println("\nEnter Element in Second BST : ");
        root = null;
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        inorder(root, _listSecondInorder);
        if(_listFirstInorder.equals(_listSecondInorder))
            System.out.println("\nYes! Both BST are Equal");
        else
        System.out.println("\nNo! Both BST are not Equal");
        buffer.close();
    }
}
