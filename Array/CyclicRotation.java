import java.util.*;
import java.io.*;
public class CyclicRotation {

    static void cyclicRotation(int[] ar){
        var n = ar.length;
        var first = ar[n-1];
        for (int i = n-2; i >= 0; i--) {
            ar[i+1] = ar[i];
        }
        ar[0] = first;
    }

    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var strAr = input.split(" ");
        var ar = new int[strAr.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(strAr[i]);
        }
        cyclicRotation(ar);
        System.out.println("\nCyclic Rotation : ");
        printArray(ar);
        scanner.close();
    }
    
}
