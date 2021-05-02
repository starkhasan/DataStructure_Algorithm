import java.io.*;
import java.util.*;
public class RearrangeArray {

    public static void rearrangeArray(int[] ar){
        int[] newArr = Arrays.copyOf(ar, ar.length);
        Arrays.sort(newArr);
        int evenPos = ar.length/2;
        int oddPos = ar.length - evenPos;
        int j = oddPos - 1;
        printArray(newArr);
        for(int i=0;i<ar.length;i+=2){

            ar[i] = newArr[j];
            j--;
        }

        j = oddPos;
        for(int i=1;i<ar.length;i+=2){
            ar[i] = newArr[j];
            j++;
        }

        printArray(ar);
    }

    public static void printArray(int[] arr){
        System.out.println();
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        rearrangeArray(arr);
    }
}
