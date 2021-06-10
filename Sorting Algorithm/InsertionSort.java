import java.io.*;
import java.util.*;
public class InsertionSort {

    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    static void insertionSort(int[] ar){
        var key = 0;
        for (int j = 1; j < ar.length; j++) {
            var i = j-1;
            key = ar[j];
            while (i>=0 && ar[i] > key) {
                ar[i+1] = ar[i];
                i-=1;
            }
            ar[i+1] = key;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        printArray(ar);
        insertionSort(ar);
        System.out.println("Array After Insertion Sorting : ");
        printArray(ar);
        scanner.close();
    }
}
