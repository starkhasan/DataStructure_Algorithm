// import java.util.*;
// import java.io.*;
// class Node{
//     Node left;
//     Node right;
//     int data;
//     Node(int data){
//         this.data = data;
//         left = right = null;
//     }
// }
// public class KthSmallestSum {
//     static int count = 0;
//     static int sum = 0;
//     static Node insert(Node root,int data){
//         if(root == null)
//             return new Node(data);
//         else{
//             if(data <= root.data)
//                 root.left = insert(root.left,data);
//             else
//                 root.right = insert(root.right,data);
//             return root;
//         }
//     }

//     static void inorder(Node focusNode,int k){
//         if(focusNode!=null && count < k){
//             inorder(focusNode.left,k);
//             sum+=focusNode.data;
//             count+=1;
//             inorder(focusNode.right,k);
//         }
//     }
    
//     public static void main(String[] args) throws FileNotFoundException{
//         var file = new File("Input.txt");
//         var scanner = new Scanner(file);
//         Node root = null;
//         var input = "";
//         var isFirst = true;
//         var k = 0;
//         while(scanner.hasNext()){
//             if(isFirst){
//                 isFirst = false;
//                 input = scanner.nextLine();
//             }else{
//                 k = Integer.parseInt(scanner.nextLine());
//             }
//         }
//         for (String string : input.split(" ")) {
//             root = insert(root,Integer.parseInt(string));
//         }
//         inorder(root,k);
//         System.out.println("\nSummation = "+sum);
//         scanner.close();
//     }
// }









//Second Method Using Agumented Data Structure
import java.util.*;
import java.io.*;
class Node{
    Node left;
    Node right;
    int lCount;
    int sum;
    int data;
    Node(int data){
        this.data = data;
        lCount = sum = 0;
        left = right = null;
    }
}
public class KthSmallestSum {
    static int count = 0;
    static int temp_sum = 0;
    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data){
                root.lCount+=1;
                root.sum+=data;
                root.left = insert(root.left,data);
            }else
                root.right = insert(root.right,data);
            return root;
        }
    }

    static void kSmallestSum(Node root, int k ){
        if (root == null)
            return ;
        if ((root.lCount + 1) == k){
            temp_sum += root.data + root.sum ;
            return ;
        }else if (k > root.lCount){
            // store sum of all element smaller than current root ;
            temp_sum += root.data + root.sum;
            // decremented k and call right sub-tree
            k = k -( root.lCount + 1);
            kSmallestSum(root.right , k );
        }else // call left sub-tree
            kSmallestSum(root.left , k );
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
        kSmallestSum(root,k);
        System.out.println("\nSummation = "+temp_sum);
        scanner.close();
    }
}
