import java.util.*;
import java.io.*;
public class CountPairSum {
    static int countPairSum(int[] ar,int sum){
        var count = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(hashMap.containsKey(sum - ar[i])){
                count+=1;
            }else
                hashMap.put(ar[i], i);
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        String[] input = null;
        var sum = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine().split(" ");
            }else{
                sum = Integer.parseInt(scanner.nextLine());
            }
        }
        var ar = new int[input.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input[i]);
        }
        var result = countPairSum(ar,sum);
        System.out.println("Total Count = "+result);
        scanner.close();
    }
}
