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
public class InorderSuccessor {

    static Node insert(Node root,int data){
        if(root  == null)
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

    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }

    static Node search(Node root,Node find){
        if(root == null)
            return null;
        if(root.data == find.data)
            return root;
        if(root.data > find.data)
            return search(root.left,find);
        return search(root.right, find);
    }

    static Node inorderSuccessor(Node root,Node key){
        Node find = search(root, key);
        if(find.right!=null)
            find = findSuccessor(find.right);
        else{
            Node temp = find;
            while(temp.parent != null){
                if(temp.parent.data > find.data){
                    find = temp.parent;
                    break;
                }
                temp = temp.parent;
            }
        }
        return find;
    }

    static Node findSuccessor(Node root){
        Node temp = root;
        while(temp.left!=null)
            temp = temp.left;
        return temp;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var isFirst = true;
        var input = "";
        Node root = null;
        Node key = null;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                key = new Node(Integer.parseInt(scanner.nextLine()));
            }
        }
        for (String string : input.split(" ")){
            root = insert(root,Integer.parseInt(string));
        }
        inorder(root);
        var result = inorderSuccessor(root,key);
        System.out.println("\nInorder Successor "+result.data);
        scanner.close();
    }
}
