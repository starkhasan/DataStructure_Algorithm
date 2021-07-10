import java.util.*;
import java.io.*;
public class PairSum {
    static void pairSum(int[] ar,int sum){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(hashMap.containsKey(sum-ar[i])){
                var index = hashMap.get(sum-ar[i]);
                System.out.println(ar[index]+","+ar[i]);
            }else
                hashMap.put(ar[i], i);
        }
    }
    public static void main(String[] args)throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var sum = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                sum = Integer.parseInt(scanner.nextLine());
            }
        }
        var strAr = input.split(" ");
        var ar = new int[strAr.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(strAr[i]);
        }
        pairSum(ar, sum);
        scanner.close();
    }
}
