import java.util.*;
import java.io.*; 
class Node{
    Node left;
    Node right;
    int data;
    int lCount;
    Node(int data){
        this.data = data;
        left = right = null;
        lCount = 0;
    }
}
public class KthSmallestItem {
    static int count = 0;
    static int item = 0;
    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data){
                root.lCount+=1;
                root.left = insert(root.left,data);
            }
            else{
                root.right = insert(root.right,data);
            }
            return root;
        }
    }

    static void kSmallestItem(Node root, int k ){
        if (root == null)
            return ;
        if ((root.lCount + 1) == k){
            item = root.data;
            return ;
        }else if (k > root.lCount){
            // store sum of all element smaller than current root ;
            item = root.data;
            // decremented k and call right sub-tree
            k = k -( root.lCount + 1);
            kSmallestItem(root.right , k );
        }else // call left sub-tree
            kSmallestItem(root.left , k );
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node root = null;
        var input = "";
        var isFirst = true;
        var k = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                k = Integer.parseInt(scanner.nextLine());
            }
        }
        for (String string : input.split(" ")) {
            root = insert(root,Integer.parseInt(string));
        }
        kSmallestItem(root,k);
        System.out.println("\nKth Smallest Item = "+item);
        scanner.close();
    }
}
