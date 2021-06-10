import java.util.*;
import java.io.*;
public class SelectionSort {

    static void selectionSort(int[] ar){
        var key = 0;
        var pos = 0;
        for (int i = 0; i < ar.length-1; i++) {
            key = ar[i];
            pos = i;
            for (int j = i+1; j < ar.length; j++) {
                if(key > ar[j]){
                    key = ar[j];
                    pos = j;
                }
            }
            var temp = ar[i];
            ar[i] = ar[pos];
            ar[pos] = temp;
        }

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
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        System.out.println("\nBefore Sorting Array");
        printArray(ar);
        System.out.println("\nAfter Sorting Array");
        selectionSort(ar);
        printArray(ar);
        scanner.close();       
    }
}