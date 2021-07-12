/**
 * Given two arrays A[] and B[] consisting of n and m elements respectively. 
 * Find the minimum number of elements to remove from each array such that no common element exist in both.
 */
import java.util.*;
import java.io.*;
public class RemoveMinimumElement {

    static int removeMinimumNumber(int[] ar1,int[] ar2){
        var count = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar1.length; i++) {
            hashMap.put(ar1[i], 1);
        }
        for (int i = 0; i < ar2.length; i++) {
            if(hashMap.containsKey(ar2[i])){
                count++;
                hashMap.remove(ar2[i]);
            }
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        String[] firstAr = null;
        String[] secondAr = null;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                firstAr = scanner.nextLine().split(" ");
            }else
                secondAr = scanner.nextLine().split(" ");
        }
        var ar1 = new int[firstAr.length];
        var ar2 = new int[secondAr.length];
        for (int i = 0,j=0; i < firstAr.length || j < secondAr.length; i++,j++) {
            if(i < firstAr.length)
                ar1[i] = Integer.parseInt(firstAr[i]);
            if(j < secondAr.length)
                ar2[j] = Integer.parseInt(secondAr[j]);
        }
        var result = removeMinimumNumber(ar1,ar2);
        System.out.println(result);
        scanner.close();
    }
}
