import java.io.*;
import java.util.*;
public class SearchinRotatedArray {
    static int findPivot(int[] ar,int low,int high){
        if(high < low)
            return -1;
        if(high == low)
            return low;
        int mid = (low+high)/2;
        if(mid < high && ar[mid] > ar[mid+1])
            return mid;
        if(mid > low && ar[mid] < ar[mid-1])
            return mid-1;
        if(ar[low] > ar[mid])
            return findPivot(ar, low, mid-1);
        return findPivot(ar, mid+1, high);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        scanner.close();
    }
}
