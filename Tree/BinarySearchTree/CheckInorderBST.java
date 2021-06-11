import java.util.*;
import java.io.*;
public class CheckInorderBST {
    static boolean checkInorderBST(int[] ar){
        for (int i = 0; i < ar.length-1; i++) {
            if(ar[i] > ar[i+1])
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        if(checkInorderBST(ar))
            System.out.print("Given Array is Inorder of BST");
        else
            System.out.println("No! Array is not BST");
        scanner.close();
    }
}
