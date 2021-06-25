import java.util.*;
import java.io.*;
public class FibonacciSearch {
    static int min(int x,int y){
        return (x<=y) ? x : y;
    }
    static int fibonacciSearch(int[] arr,int x){
        var n = arr.length;
        int fibMMm2 = 0; // (m-2)'th Fibonacci No.
        int fibMMm1 = 1; // (m-1)'th Fibonacci No.
        int fibM = fibMMm2 + fibMMm1; // m'th Fibonacci
 
        /* fibM is going to store the smallest
        Fibonacci Number greater than or equal to n */
        while (fibM < n) {
            fibMMm2 = fibMMm1;
            fibMMm1 = fibM;
            fibM = fibMMm2 + fibMMm1;
        }
 
        // Marks the eliminated range from front
        int offset = -1;
 
        /* while there are elements to be inspected.
        Note that we compare arr[fibMm2] with x.
        When fibM becomes 1, fibMm2 becomes 0 */
        while (fibM > 1) {
            // Check if fibMm2 is a valid location
            int i = min(offset + fibMMm2, n - 1);
 
            /* If x is greater than the value at
            index fibMm2, cut the subarray array
            from offset to i */
            if (arr[i] < x) {
                fibM = fibMMm1;
                fibMMm1 = fibMMm2;
                fibMMm2 = fibM - fibMMm1;
                offset = i;
            }
 
            /* If x is less than the value at index
            fibMm2, cut the subarray after i+1 */
            else if (arr[i] > x) {
                fibM = fibMMm2;
                fibMMm1 = fibMMm1 - fibMMm2;
                fibMMm2 = fibM - fibMMm1;
            }
 
            /* element found. return index */
            else
                return i;
        }
 
        /* comparing the last element with x */
        if (fibMMm1 == 1 && arr[n-1] == x)
            return n-1;
 
        /*element not found. return -1 */
        return -1;
    }

    static int partition(int[] ar,int p,int r){
        var key = ar[r];
        var temp = 0;
        var i = p-1;
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
            var q = partition(ar,p,r);
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
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var element = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                element = Integer.parseInt(scanner.nextLine());
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        quickSort(ar, 0, ar.length-1);
        var result = fibonacciSearch(ar, element);
        if(result >= 0)
            System.out.println("Element Found : "+result);
        else
            System.out.println("Element Not Found : ");
        scanner.close();        
    }    
}
