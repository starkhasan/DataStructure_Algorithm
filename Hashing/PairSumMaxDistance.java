import java.util.*;
import java.io.*;
public class PairSumMaxDistance {
    static void pairSumMaxDistance(int[] ar,int k){
        var hashMap = new HashMap<Integer,Integer>();
        var maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if(hashMap.containsKey(k-ar[i])){
                var tempDistance = Math.max(hashMap.get(k-ar[i]),i+1);
                if(maxDistance < tempDistance)
                    maxDistance = tempDistance;
            }else{
                hashMap.put(ar[i], i+1);
            }
        }
        System.out.println(maxDistance);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        String[] input = null;
        var k = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine().split(" ");
            }else{
                k = Integer.parseInt(scanner.nextLine());
            }
        }
        var ar = new int[input.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input[i]);
        }
        pairSumMaxDistance(ar,k);
        scanner.close();
    }
}
