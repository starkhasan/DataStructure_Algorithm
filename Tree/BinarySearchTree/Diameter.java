import java.util.*;
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
public class Diameter {

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

    static int height(Node root){
        if(root == null)
            return 0;
        else
            return Math.max(height(root.left)+1,height(root.right)+1);
    }

    static int diameter(Node root){
        if(root == null)
            return 0;
        var lHeight = height(root.left);
        var rHeight = height(root.right);
        var tempDiameter = lHeight + rHeight + 1;
        var lDiameter = diameter(root.left);
        var rDiameter = diameter(root.right);
        return Math.max(tempDiameter,Math.max(lDiameter,rDiameter));
    }


    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var sc = new Scanner(file);
            Node root = null;
            var input = "";
            while(sc.hasNext())
                input = sc.nextLine();
            var strAr = input.split(" ");
            for (String string : strAr) {
                root = insert(root,Integer.parseInt(string));
            }
            var result = diameter(root);
            System.out.println("\nDiameter of Binary Tree : "+result);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
