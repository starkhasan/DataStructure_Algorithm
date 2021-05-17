import java.io.*;
import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
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
                    if(current.right != null)
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

    static int partition(int[] ar,int p,int r){
        int key = ar[r];
        int i = p-1;
        int temp = 0;

        for (int j = p; j < r; j++) {
            if(key < ar[r]){
                i+=1;
                temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        temp = ar[r];
        ar[r] = ar[i+1];
        ar[i+1] = temp;
        return i+1;
    }

    static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }

    static void storeInorder(Node root,int[] ar,int index){
        if(root != null){
            storeInorder(root.left, ar, index);
            ar[index] = root.data;
            index+=1;
            storeInorder(root.right, ar, index);
        }
    }

    static void arrayToBST(int[] ar,Node root,int index){
        if(root!=null){
            arrayToBST(ar, root.left, index);
            root.data = ar[index];
            index+=1;
            arrayToBST(ar, root.right, index);
        }
    }

    static Node binaryToBST(Node root){
        int nodeCount = totalNode(root);
        int[] ar = new int[nodeCount];
        storeInorder(root,ar,0);    
        quickSort(ar, 0, ar.length-1);
        printArray(ar);
        arrayToBST(ar,root,0);
        return root;
    }

    static void printInorder(Node root){
        if(root!=null){
            printInorder(root.left);
            System.out.print(root.data+" ");
            printInorder(root.right);
        }
    }

    static int totalNode(Node root){
        if(root == null)
            return 0;
        else
            return 1 + totalNode(root.left) + totalNode(root.right);
    }

    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int tree_size = Integer.parseInt(buffer.readLine());
        Node root = null;
        while(tree_size > 0){
            root = insert(root,Integer.parseInt(buffer.readLine()));
            tree_size -=1;
        }
        printInorder(root);
        root = binaryToBST(root);
        printInorder(root);
        buffer.close();        
    }
}