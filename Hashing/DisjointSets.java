/**
 * Given two sets represented by two arrays, how to check if the given two sets are disjoint or not?
 * It may be assumed that the given arrays have no duplicates.
 */
import java.util.*;
import java.io.*;
public class DisjointSets {
    static boolean disJointSet(int[] ar1,int[] ar2){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar1.length; i++) {
            hashMap.put(ar1[i], 1);
        }

        for (int i = 0; i < ar2.length; i++) {
            if(hashMap.containsKey(ar2[i]))
                return false;
        }
        return true;
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
            }else{
                secondAr = scanner.nextLine().split(" ");
            }
        }
        var ar1 = new int[firstAr.length];
        var ar2 = new int[secondAr.length];

        for (int i = 0, j = 0; i < ar1.length || j < ar2.length; i++ , j++) {
            if(i < ar1.length)
                ar1[i] = Integer.parseInt(firstAr[i]);
            if(j < ar2.length)
                ar2[j] = Integer.parseInt(secondAr[j]);
        }
        var result = disJointSet(ar1,ar2);
        if(result)
            System.out.println("Yes!! Disjoint");
        else
            System.out.println("Not!! Disjoint");
        scanner.close();
    }
}
