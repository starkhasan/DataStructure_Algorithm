/**
 * Given an array with n positive integers. We need to find the minimum number of operation to make all elements equal.
 * We can perform addition, multiplication, subtraction or division with any element on an array element. 
 * 
 * Input : arr[] = {1, 2, 3, 4}
 * Output : 3
 * Since all elements are different, 
 * we need to perform at least three operations to make them same. For example, we can make them all 1
 * by doing three subtractions. Or make them all 3 by doing three additions.
 */
import java.util.*;
import java.io.*;
public class MinimumOperation {
    static void minimumOperation(int[] ar){
        var count = 1;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i])){
                hashMap.put(ar[i], 1);
            }else{
                var temp = hashMap.get(ar[i]) + 1;
                count = temp;
                hashMap.put(ar[i], temp);
            }
        }
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
        minimumOperation(ar);
        scanner.close();
    }
}
