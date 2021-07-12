/**
 * Given two sorted arrays of size m and n of distinct elements. Given a value x. 
 * The problem is to count all pairs from both arrays whose sum is equal to x. 
 * Note: The pair has an element from each array.
 */
import java.util.*;
import java.io.*;
public class PairSumTwoArray {
    static int countPair(int[] ar1,int[] ar2,int sum){
        var count = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar1.length; i++) {
            hashMap.put(ar1[i], i);
        }

        for (int i = 0; i < ar2.length; i++) {
            if(hashMap.containsKey(sum - ar2[i])){
                count+=1;
            }
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        String[] firstAr = null;
        String[] secondAr = null;
        var sum = 0;
        var isFirst = true;
        var isSecond = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                firstAr = scanner.nextLine().split(" ");
            }else if(isSecond){
                isSecond = false;
                secondAr = scanner.nextLine().split(" ");
            }else
                sum = Integer.parseInt(scanner.nextLine());
        }
        var ar1 = new int[firstAr.length];
        var ar2 = new int[secondAr.length];
        for (int i = 0,j = 0; i < ar1.length || j < ar2.length; i++,j++) {
            if(i < ar1.length){
                ar1[i] = Integer.parseInt(firstAr[i]);
            }
            if(j < ar2.length){
                ar2[j] = Integer.parseInt(secondAr[j]);
            }
        }
        var result = countPair(ar1, ar2,sum);
        System.out.println("Count Pair = "+result);
        scanner.close();
    }
}
