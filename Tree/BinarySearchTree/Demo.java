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
class Demo{
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

    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }

    static Node findNode(Node root,Node find){
        if(root == null)
            return null;
        if(root.data == find.data)
            return root;
        if(find.data < root.data)
            return findNode(root.left, find);
        return findNode(root.right, find);
    }

    static Node inorderSuccessor(Node focusNode,Node item){
        Node findNode = findNode(focusNode, item);
        if(findNode.right != null)
            findNode = returnSuccessor(findNode.right);
        return findNode;
    }

    static Node returnSuccessor(Node root){
        Node temp = root;
        while(temp.left!=null){
            temp = temp.left;
        }
        return temp;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        Node root = null;
        Node findNode = null;
        while (scanner.hasNext()) {
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                findNode = new Node(Integer.parseInt(scanner.nextLine()));
            }
        }
        for (String string : input.split(" ")) {
            root = insert(root,Integer.parseInt(string));
        }
        findNode = inorderSuccessor(root,findNode);
        System.out.println("\nInorder Successor = "+findNode.data);
        scanner.close();
    }
}