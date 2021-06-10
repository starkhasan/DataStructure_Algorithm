import java.util.*;
import java.io.*;
public class QuickSort {

    static int partition(int[] ar,int p,int r){
        var key = ar[r];
        var i = p-1;
        var temp = 0;
        for (int j = p; j < r; j++) {
            if(ar[j] < key){
                i+=1;
                temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }

        temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;
        return i+1;
    }


    static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }
    
    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("InputArray.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        quickSort(ar,0,ar.length-1);
        printArray(ar);
        scanner.close();
    }
}
