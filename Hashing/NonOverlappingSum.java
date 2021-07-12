/**
 * Given two arrays A[] and B[] of size n. It is given that both array individually contains distinct elements. 
 * We need to find the sum of all elements that are not common.
 */
import java.util.*;
import java.io.*;
public class NonOverlappingSum {
    static int nonOverlappingSum(int[] ar1,int[] ar2){
        var sum = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0,j=0; i < ar1.length || j < ar2.length; i++,j++) {
            if(i < ar1.length){
                hashMap.put(ar1[i], 1);
            }
            if(j < ar2.length){
                hashMap.put(ar2[j], 1);
            }
        }

        var keys = hashMap.keySet();
        for (var item : keys) {
            sum+=item;
        }
        return sum;
    }
   public static void main(String[] args) throws FileNotFoundException{
       var file = new File("Input.txt");
       var scanner = new Scanner(file);
       String[] firstInput = null;
       String[] secondInput = null;
       var isFirst = true;
       while(scanner.hasNext()){
           if(isFirst){
               isFirst = false;
               firstInput = scanner.nextLine().split(" ");
           }else
                secondInput = scanner.nextLine().split(" ");
       }
       var ar1 = new int[firstInput.length];
       var ar2 = new int[secondInput.length];
       for (int i = 0,j=0; i < ar1.length || j < ar2.length; i++ , j++) {
           if(i < ar1.length){
               ar1[i] = Integer.parseInt(firstInput[i]);
           }
           if(j < ar2.length){
               ar2[j] = Integer.parseInt(secondInput[j]);
           }
       }
       var result = nonOverlappingSum(ar1,ar2);
       System.out.println("Non-Overlapping Sum = "+result);
       scanner.close();
   } 
}
