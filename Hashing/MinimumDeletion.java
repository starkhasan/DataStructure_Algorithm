/**
 * Given an array of n elements such that elements may repeat. We can delete any number of elements from the array. 
 * The task is to find a minimum number of elements to be deleted from the array to make it equal.
 * Input: arr[] = {4, 3, 4, 4, 2, 4}
 * Output: 2
 * After deleting 2 and 3 from array, array becomes 
 * arr[] = {4, 4, 4, 4} 
 */
import java.util.*;
import java.io.*;
public class MinimumDeletion {
    static void minimumDeletion(int[] ar){
        var count = 1;
        var uniqueElement = true;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i])){
                hashMap.put(ar[i], 1);
            }else{
                var temp = hashMap.get(ar[i]) + 1;
                count = temp;
                hashMap.put(ar[i], temp);
                uniqueElement = false;
            }
        }
        if(uniqueElement)
            System.out.println("All Elements are equal");
        else
            System.out.println("Minimum deletion = "+(ar.length-count));
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var strAr = input.split(" ");
        var ar = new int[strAr.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(strAr[i]);
        }
        minimumDeletion(ar);
        scanner.close();
    }
}
