/**
 * The idea is based on the fact that inorder and preorder/postorder uniquely identify a binary tree. Tree S is a subtree of T if both inorder and preorder traversals of S arew substrings of inorder and preorder traversals of T respectively.
 * Following are detailed steps.
 * 1) Find inorder and preorder traversals of T, store them in two auxiliary arrays inT[] and preT[].
 * 2) Find inorder and preorder traversals of S, store them in two auxiliary arrays inS[] and preS[].
 * 3) If inS[] is a subarray of inT[] and preS[] is a subarray preT[], then S is a subtree of T. Else not.
 */
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
public class Subtree {
    static int index = 0;
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

    static Node search(Node root,Node k){
        if(root!=null){
            if(root.data == k.data)
                return root;
            else{
                if(root.data < k.data)
                    return search(root.right, k);
                return search(root.left, k);
            }
        }
        return null;
    }

    static void inorder(Node focusNode,int[] ar){
        if(focusNode!=null){
            inorder(focusNode.left,ar);
            ar[index] = focusNode.data;
            index+=1;
            inorder(focusNode.right,ar);
        }
    }

    static int countNode(Node focusNode){
        if(focusNode == null)
            return 0;
        else
            return countNode(focusNode.left) + countNode(focusNode.right) + 1;
    }


    static boolean checkSubArray(int[] ar1,int[] ar2){
        var n1 = ar1.length;
        var n2 = ar2.length;

        var strA2 = "";
        for (int i : ar2) {
            strA2+=String.valueOf(i);
        }
        var strA1 = "";
        for (int i = 0; i <= n1-n2; i++) {
            for (int j = i; j < n2; j++) {
                strA1+=String.valueOf(ar1[j]);
            }
            if(strA1.equals(strA2))
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node root = null;
        Node secondRoot = null;
        String[] input = null;
        String[] second = null;
        Node newNode = null;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine().split(" ");
            }else{
                second = scanner.nextLine().split(" "); 
            }
        }
        for (String string : input) {
            root = insert(root,Integer.parseInt(string));
        }
        for (String string : second) {
            secondRoot = insert(secondRoot,Integer.parseInt(string));
        }

        var totalNode = countNode(root);
        var ar = new int[totalNode];
        index = 0;
        inorder(root, ar);


        totalNode = countNode(secondRoot);
        var secondAr = new int[totalNode];
        index = 0;
        inorder(secondRoot, secondAr);

        var result = checkSubArray(ar,secondAr);
        if(result)
            System.out.println("Second Tree is the SubTree of First Tree");
        else
            System.out.println("Not Subtree");
        scanner.close();
    }
}
