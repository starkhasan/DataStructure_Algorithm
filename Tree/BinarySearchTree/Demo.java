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
public class Demo{

    static int count = 0;

    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data)
                root.left = insert(root.left, data);
            else
                root.right = insert(root.right, data);
            return root;
        }
    }

    static int height(Node root){
        if(root == null)
            return -1;
        else
            return Math.max(height(root.left)+1, height(root.right)+1);
    }

    static void inorder(Node root){
        if(root!=null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static void preorder(Node root){
        if(root!=null){
            System.out.print(root.data+" ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void postorder(Node root){
        if(root!=null){
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data+" ");
        }
    }

    static void DepthFirstSearch(Node root){
        if(root != null){
            System.out.print(root.data+" ");
            DepthFirstSearch(root.left);
            DepthFirstSearch(root.right);
        }
    }

    static void BreadthFirstSearch(Node root){
        int treeHeight = height(root);
        for (var i = 0; i <= treeHeight; i++) {
            levelTraversal(root,i);
        }
    }

    static void levelTraversal(Node root,int level){
        if(root != null){
            if(level == 0)
                System.out.print(root.data+" ");
            else if(level > 0)
                levelTraversal(root.left, level-1);
                levelTraversal(root.right, level-1);
        }
    }

    static int totalSum(Node root){
        if(root == null)
            return 0;
        else{
            var leftSum = totalSum(root.left);
            var rightSum = totalSum(root.right);
            return (root.data + leftSum + rightSum);
        }
    }

    static int maxElement(Node root){
        if(root.right == null)
            return root.data;
        else
            return maxElement(root.right);
    }

    static int minElement(Node root){
        if(root.left == null)
            return root.data;
        else
            return minElement(root.left);
    }


    static Node mirror(Node root){
        if(root == null)
            return root;
        else{
            var left = mirror(root.left);
            var right = mirror(root.right);
            root.left = right;
            root.right = left;
            return root;
        }
    }

    static int totalNode(Node root){
        if(root == null)
            return 0;
        else
            return 1 + totalNode(root.left) + totalNode(root.right);
    }

    static Node lca(Node root,int n1,int n2){
        while(root != null){
            if(root.data >n1 && root.data>n2)
                root = root.left;
            else if(root.data < n1 && root.data < n2)
                root = root.right;
            else
                break;
        }
        return root;
    }

    static int diameter(Node root){

        if(root == null)
            return 0;
        
        var left = height(root.left)+1;
        var right = height(root.left)+1;
        var currentDiamater = left + right + 1;

        var lDiameter = diameter(root.left);
        var rDiameter = diameter(root.right);
        return Math.max(currentDiamater,Math.max(lDiameter, rDiameter));
    }



    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            Node root = null;
            var input = "";
            while(scanner.hasNext())
                input = scanner.nextLine();
            var strAr = input.split(" ");
            for (var str : strAr) {
                root = insert(root,Integer.parseInt(str));
            }
            var treeHeight = height(root);
            System.out.println("Height of Tree : "+treeHeight);
            System.out.println("\nInorder Traversal : ");
            inorder(root);
            System.out.println("\nMaximum Element : ");
            var max = maxElement(root);
            System.out.println(max);
            System.out.println("\nMinimum Element : ");
            var min = minElement(root);
            System.out.println(min);
            System.out.println("\nTotal Summation : ");
            System.out.println(totalSum(root));
            System.out.println("\nTotal Node : ");
            System.out.println(totalNode(root));
            System.out.println("\nDiameter of Tree : "+diameter(root));
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}