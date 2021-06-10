import java.io.*;
import java.util.*;
public class BubbleSort {
    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    static void bubbleSort(int[] ar){
        var temp = 0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar.length-1; j++) {
                if(ar[j] > ar[j+1]){
                    temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                }
            }
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
        bubbleSort(ar);
        printArray(ar);
        scanner.close();
    }    
}
