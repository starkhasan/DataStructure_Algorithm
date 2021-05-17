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
public class ArrayPreOrder {
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

    static void preorder(Node root,Queue<Integer> queuePreorder){
        if(root != null){
            queuePreorder.add(root.data);
            preorder(root.left, queuePreorder);
            preorder(root.right, queuePreorder);
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        int[] ar = {2,4,1};
        int count = 0;
        while(count < ar.length){
            root = insert(root,ar[count]);
            count+=1;
        }
        Queue<Integer> queuePreorder = new LinkedList<Integer>();
        preorder(root, queuePreorder);
        boolean isPreorder = true;
        for (int i = 0; i < ar.length; i++) {
            if(ar[i] != queuePreorder.peek().intValue()){
                isPreorder = false;
                break;
            }else
                queuePreorder.remove();
        }
        if(isPreorder)
            System.out.println("True");
        else 
            System.out.println("False");
        buffer.close();
    }
}
