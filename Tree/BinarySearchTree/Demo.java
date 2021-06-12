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
class Demo{
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

    static void inorder(Node focusNode){
        if(focusNode!=null){
            inorder(focusNode.left);
            System.out.print(focusNode.data+" ");
            inorder(focusNode.right);
        }
    }

    static void preorder(Node focusNode){
        if(focusNode!=null){
            System.out.print(focusNode.data+" ");
            preorder(focusNode.left);
            preorder(focusNode.right);
        }
    }

    static void postorder(Node focusNode){
        if(focusNode!=null){
            postorder(focusNode.left);
            postorder(focusNode.right);
            System.out.print(focusNode.data+" ");
        }
    }

    static int height(Node root){
        if(root == null)
            return -1;
        else
            return Math.max(height(root.left)+1,height(root.right)+1);
    }

    static void bfs(Node root){
        var treeHeight = height(root);
        for (int i = 0; i <= treeHeight; i++) {
            level(root,i);
        }
    }

    static void level(Node focusNode,int level){
        if(focusNode!=null){
            if(level == 0)
                System.out.print(focusNode.data+" ");
            else if(level > 0)
                level(focusNode.left,level-1);
                level(focusNode.right, level-1);
        }
    }

    static int maximum(Node root){
        if(root.right == null)
            return root.data;
        else
            return maximum(root.right);
    }


    static int minimum(Node root){
        if(root.left == null)
            return root.data;
        else
            return minimum(root.left);
    }

    static int totalSum(Node root){
        var sum = 0;
        var leftSum = 0;
        var rightSum = 0;
        if(root == null)
            return 0;
        else{
            leftSum = totalSum(root.left);
            rightSum = totalSum(root.right);
            sum += root.data + leftSum + rightSum;
            return sum;
        }
    }

    static Node search(Node root,Node key){
        if(root == null)
            return root;
        if(root.data == key.data)
            return root;
        if(key.data < root.data)
            return search(root.left, key);
        return search(root.right, key);
    }

    static Node lca(Node root,int n1,int n2){
        if(root == null)
            return root;
        else{
            while(root!=null){
                if(n1 < root.data && n2 < root.data)
                    root = root.left;
                else if(n1 > root.data && n2 > root.data)
                    root = root.right;
                else break;
            }
            return root;
        }
    }

    static Node deleteNode(Node root,int key){
        if(root == null)
            return root;
        if(key < root.data)
            root.left = deleteNode(root.left, key);
        else if(key > root.data)
            root.right = deleteNode(root.right, key);
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.data = inorderSuccessor(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    static int inorderSuccessor(Node root){
        var temp = root;
        while(temp.left!=null)
            temp = temp.left;
        return temp.data;
    }


    static Node mirror(Node root){
        if(root == null)
            return root;
        else{
            Node tempLeft = mirror(root.left);
            Node tempRight = mirror(root.right);
            root.left = tempRight;
            root.right = tempLeft;
            return root;
        }
    }

    static Node inorderSuccessor(Node root,int key){
        if(root == null)
            return root;
        var find = search(root, new Node(key));
        if(find.right!=null)
            find = successor(find.right);
        else{
            var temp = find;
            while(temp.parent!=null){
                if(temp.parent.data > find.data){
                    find = temp.parent;
                    break;
                }
                temp = temp.parent;
            }
        }
        return find;
    }

    static Node successor(Node root){
        var temp = root;
        while (temp.left!=null) {
            temp = temp.left;
        }
        return temp;
    }


    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        Node root = null;
        Node tempNode = null;
        while(scanner.hasNext())
            input = scanner.nextLine();
        for (String string : input.split(" ")) {
            root = insert(root,Integer.parseInt(string));
        }
        System.out.println("Inorder Traversal of Tree");
        inorder(root);
        System.out.println("\nPreorder Traversal of Tree");
        preorder(root);
        System.out.println("\nPostorder Traversal of Tree");
        postorder(root);
        var result = height(root);
        System.out.println("\nHeight of the Tree = "+result);
        System.out.println("\nDepth First Search of Tree : ");
        preorder(root);
        System.out.println("\nBreadth First Search of the Tree : ");
        bfs(root);
        result = maximum(root);
        System.out.println("\nMaximum Element in Binary Search Tree : "+result);
        result = minimum(root);
        System.out.println("\nMinimum Element in Binary Search Tree : "+result);
        result = totalSum(root);
        System.out.println("\nTotal Sum of Binary Search Tree : "+result);
        tempNode = search(root, new Node(6));
        if(tempNode != null)
            System.out.println("\nNode Found = "+tempNode.data);
        else
            System.out.println("\nSorry! Node Not Found!!");
        tempNode = lca(root, 4, 7);
        System.out.println("\nLeast Common Ancestor of n1 and n2 is "+tempNode.data);
        System.out.println("\nDeletion of Node ");
        tempNode = deleteNode(root,6);
        inorder(tempNode);
        // System.out.println("\nBFS of Mirror BST : ");
        // tempNode = mirror(root);
        // bfs(tempNode);
        tempNode = inorderSuccessor(root, 8);
        System.out.println("\nInorder Successor = "+tempNode.data);
        

        scanner.close();
    }
}