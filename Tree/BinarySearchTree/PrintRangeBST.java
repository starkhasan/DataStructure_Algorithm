import java.util.*;
import java.io.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class PrintRangeBST {
    static int countNode = 0;
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

    //printing all keys between n1 and n2
    static void printKeys(Node root,int n1,int n2){
        if(root != null){
            if(n1 <= root.data && root.data <= n2)
                System.out.print(root.data+" ");
            printKeys(root.left, n1, n2);
            printKeys(root.right, n1, n2);
        }
    }

    static void countKeys(Node root,int n1,int n2){
        if(root!=null){
            if(n1 <= root.data && root.data <= n2)
                countNode+=1;
            countKeys(root.left, n1, n2);
            countKeys(root.right, n1, n2);
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        String[] input = null;
        Node root = null;
        String[] range = null;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine().split(" ");
            }else
                range = scanner.nextLine().split(" ");
        }
        for (String string : input) {
            root = insert(root,Integer.parseInt(string));
        }
        printKeys(root, Integer.parseInt(range[0]), Integer.parseInt(range[1]));
        countKeys(root, Integer.parseInt(range[0]), Integer.parseInt(range[1]));
        System.out.println("Total Keys Between Range = "+countNode);
        scanner.close();
    }
}
