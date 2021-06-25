import java.util.*;
import java.io.*;
public class BinarySearch {
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

        temp = ar[r];
        ar[r] = ar[i+1];
        ar[i+1] = temp;
        return i+1;
    }
    static void quickSort(int[] ar,int p,int r){
        if(p<r){
            var q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }

    static int binarySearch(int[] ar,int p,int r,int key){
        if(p<=r){
            var mid = (p+r)/2;
            if(ar[mid] == key)
                return mid;
            
            if(ar[mid] > key)
                return binarySearch(ar, p, mid-1,key);
            return binarySearch(ar, mid+1, r, key);
        }
        return -1;
    }

    static void printElement(int[] ar){
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
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        System.out.println("Inserted Element");
        printElement(ar);
        quickSort(ar, 0, ar.length-1);
        System.out.println("\nElements After Sorting");
        printElement(ar);
        var result = binarySearch(ar, 0, ar.length-1, 7);
        if(result > 0)
            System.out.println("\nElement Found ");
        else
            System.out.println("\nElement Not Found");
        scanner.close();
    }
}
