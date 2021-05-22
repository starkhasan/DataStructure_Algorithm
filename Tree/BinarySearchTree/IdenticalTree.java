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
public class IdenticalTree {

    static boolean isSame(Node a,Node b){
        if(a == null && b == null)
            return true;
        if(a != null && b != null)
            return (a.data == b.data && isSame(a.left, b.left) && isSame(a.right, b.right));
        return false;
    }

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
    
    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            Node head1 = null;
            Node head2 = null;
            var first = "";
            var second = "";
            var isFirst = true;
            while(scanner.hasNext()){
                if(isFirst){
                    isFirst = false;
                    first = scanner.nextLine();
                }else{
                    second = scanner.nextLine();
                }
            }
            var firstAr = first.split(" ");
            var secondAr = second.split(" ");
            for (String temp : firstAr) {
                head1 = insert(head1,Integer.parseInt(temp));
            }
            for (String string : secondAr) {
                head2 = insert(head2,Integer.parseInt(string));
            }
            if(isSame(head1, head2))
                System.out.println("Equal BST");
            else
                System.out.println("Not Equal");
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
