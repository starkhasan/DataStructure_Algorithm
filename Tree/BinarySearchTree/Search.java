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
class Search{
    static Node insert(Node root,int data){
        if(root == null)
            return new Node(data);
        else{
            Node cur;
            if(data <= root.data){
                cur = insert(root.left,data);
                root.left = cur;
            }else{
                cur = insert(root.right,data);
                root.right = cur;
            }
            return root;
        }
    }   
    static void inorder(Node root){
        if(root != null){
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
        }
    }

    static Node searchElement(Node root,int key){
        if(root!=null){
            if(root.data == key)
                return root;
            if(key < root.data)
                return searchElement(root.left, key);
            return searchElement(root.right, key);
        }
        return null;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Node root = null;
        System.out.println("Number of Nodes");
        int tree_size = Integer.parseInt(buffer.readLine());
        while(tree_size > 0){
            root =insert(root,Integer.parseInt(buffer.readLine()));
            tree_size-=1;
        }
        System.out.println("\nInorder Traversal : ");
        inorder(root);
        System.out.println("\nElement to Search : ");
        int element = Integer.parseInt(buffer.readLine());
        Node temp = searchElement(root, element);
        if(temp != null)
            System.out.println("Element Found : "+temp.data);
        else
            System.out.println("Element not Found!");
        buffer.close();
    }
}