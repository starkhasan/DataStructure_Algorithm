import java.util.*;
import java.io.*;
public class CountingSort {
    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    static int findMax(int[] ar){
        var temp = 0;
        for (int i : ar) {
            if(temp < i)
                temp = i;
        }
        return temp;
    }



    static int[] countingSort(int[] ar){
        var max = findMax(ar);
        var countAr = new int[max+1];
        var output = new int[ar.length];
        for (int i = 0; i <= max; i++) {
            countAr[i] = 0;
        }

        for (int i = 0; i < ar.length; i++) {
            var tempCount = countAr[ar[i]];
            countAr[ar[i]] = tempCount+1;
        }

        //Store Commulative Sum
        for (int i = 0; i < countAr.length; i++) {
            if(i > 0)
                countAr[i] = countAr[i] + countAr[i-1];
        }
        //find index of each element of the original array in the count array. This gives the commulative count.
        for (int i = 0; i < ar.length; i++) {
            output[countAr[ar[i]]] = ar[i];
            countAr[ar[i]]--;
        }
        return output;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar. length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }   
        System.out.println("\nBefore Sorting  Array");
        printArray(ar);
        System.out.println("\nAfter Sorting Array");
        var arr = countingSort(ar);
        printArray(arr);
        scanner.close();
    }
}
