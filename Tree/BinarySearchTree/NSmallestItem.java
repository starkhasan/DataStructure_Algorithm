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
public class NSmallestItem {

    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <=  root.data)
                root.left = insert(root.left,data);
            else
                root.right = insert(root.right,data);
            return root;
        }
    }


    static void inorder(Node root,List<Integer> listInorder){
        if(root != null){
            inorder(root.left, listInorder);
            listInorder.add(root.data);
            inorder(root.right, listInorder);
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
        System.out.println("\nEnter Nth Position : ");
        int pos = Integer.parseInt(buffer.readLine());
        List<Integer> listInrder = new ArrayList<Integer>();
        inorder(root,listInrder);
        for (int i = 1; i <= listInrder.size(); i++) {
            if(pos == i){
                System.out.println(listInrder.get(i-1));
                break;
            }
        }
        buffer.close();
    }
}
