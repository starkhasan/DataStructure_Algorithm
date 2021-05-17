import java.io.*;
import java.util.*;
class Node{
    Node left;
    Node right;
    int data;
    Node(int data){
        this.data = data;
        left = right = null;
    }
}
public class CheckBST {

    static Node insertBST(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            if(data <= root.data)
                root.left = insertBST(root.left,data);
            else
                root.right = insertBST(root.right,data);
            return root;
        }
    }

    static Node insertBinary(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            Node current = root;
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while(!queue.isEmpty()){
                Node temp = queue.peek();
                queue.remove();
                if(temp.left == null){
                    current.left = new Node(data);
                    break;
                }else{
                    if(current.right!=null)
                        current = current.left;
                    queue.add(temp.left);
                }
                if(temp.right == null){
                    current.right = new Node(data);
                    break;
                }else{
                    queue.add(temp.right);
                }
            }
            return root;
        }
    }

    static void inorder(Node root,List<Integer> _listInorder){
        if(root!=null){
            inorder(root.left,_listInorder);
            _listInorder.add(root.data);
            inorder(root.right,_listInorder);
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        int tree_size = Integer.parseInt(buffer.readLine());
        while(tree_size > 0){
            root = insertBinary(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        List<Integer> _listInorder = new ArrayList<Integer>();
        inorder(root,_listInorder);
        List<Integer> _listtemp = new ArrayList<Integer>();
        _listtemp.addAll(_listInorder);
        Collections.sort(_listInorder);
        if(_listtemp.equals(_listInorder)) 
            System.out.println("It is Binary Search Tree : ");
        else
            System.out.println("Not Binary Search Tree : ");
        buffer.close();
    }
}

