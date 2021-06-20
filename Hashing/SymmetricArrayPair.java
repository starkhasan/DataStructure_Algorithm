import java.util.*;
import java.io.*;
public class SymmetricArrayPair {
    static void findSymPairs(int[][] arr){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length; i++)
        {
            // First and second elements of current pair
            int first = arr[i][0];
            int sec   = arr[i][1];
             
            // Look for second element of this pair in hash
            Integer val = hashMap.get(sec);
  
            // If found and value in hash matches with first
            // element of this pair, we found symmetry
            if (val != null && val == first)
               System.out.println("(" + sec + ", " + first + ")");
                
            else  // Else put sec element of this pair in hash
               hashMap.put(first, sec);
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        int arr[][] = new int[5][2];
        arr[0][0] = 11; arr[0][1] = 20;
        arr[1][0] = 30; arr[1][1] = 40;
        arr[2][0] = 5;  arr[2][1] = 10;
        arr[3][0] = 40;  arr[3][1] = 30;
        arr[4][0] = 10;  arr[4][1] = 5;
        findSymPairs(arr);
    }
}