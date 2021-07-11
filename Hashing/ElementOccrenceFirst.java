/**
 * First element occurring k times in an array
 * Given an array of n integers. The task is to find the first element that occurs k number of times. 
 * If no element occurs k times the print -1. The distribution of integer elements could be in any range.
 */
import java.util.*;
import java.io.*;
public class ElementOccrenceFirst {
    static int firstElementOccurrence(int[] ar,int key){
        var result = -1;
        var pos = Integer.MAX_VALUE;
        var count = 0;
        var countMap = new HashMap<Integer,Integer>();
        var posMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!countMap.containsKey(ar[i]) && !posMap.containsKey(ar[i])){
                countMap.put(ar[i], 1);
                posMap.put(ar[i], i);
            }else{
                count = countMap.get(ar[i]) + 1;
                countMap.put(ar[i], count);
                if(count == key && pos > posMap.get(ar[i])){
                    pos = posMap.get(ar[i]);
                    result = ar[i];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var k = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                k = Integer.parseInt(scanner.nextLine());
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        var result = firstElementOccurrence(ar, k);
        System.out.println(result);
        scanner.close();
    }  
}
