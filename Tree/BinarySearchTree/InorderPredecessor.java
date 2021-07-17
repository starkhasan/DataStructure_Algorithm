import java.util.*;
import java.io.*;
class Node{
    Node left;
    Node right;
    Node parent;
    int data;
    Node(int data){
        this.data = data;
        left = right = parent = null;
    }
}
public class InorderPredecessor {
    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data){
                root.left = insert(root.left,data);
                root.left.parent = root;
            }else{
                root.right = insert(root.right,data);
                root.right.parent = root;
            }
            return root;
        }
    }


    static Node search(Node root,Node key){
        if(root == null)
            return null;
        if(key.data == root.data)
            return root;
        if(key.data < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }

    static Node inorderPredecessor(Node root,Node key){
        var find = search(root, key);
        if(find.left!=null)
            return predecessor(find.left);
        else{
            var temp = find;
            while(temp.parent!=null){
                if(temp.parent.data < find.data){
                    find = temp.parent;
                    break;
                }
                temp = temp.parent;
            }
            return find;
        }

    }


    static Node predecessor(Node root){
        var temp = root;
        while(temp.right!=null)
            temp = temp.right;
        return temp;
    }

    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node root = null;
        Node key = null;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                key = new Node(Integer.parseInt(scanner.nextLine()));
        }

        for (String string : input.split(" ")) {
            root = insert(root, Integer.parseInt(string));
        }
        var temp = inorderPredecessor(root, key);
        System.out.println("Inorder Predecessor = "+temp.data);
        scanner.close();    
    }
}
