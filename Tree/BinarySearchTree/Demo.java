import java.util.*;
import java.io.*;
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

    static void printInorder(Node focusNode){
        if(focusNode != null){
            printInorder(focusNode.left);
            System.out.println(focusNode.data+" ");
            printInorder(focusNode.right);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        Node root = null;
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")) {
            root = insert(root, Integer.parseInt(string));
        }
        printInorder(root);
        scanner.close();
    }
}