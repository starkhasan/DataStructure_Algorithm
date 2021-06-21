import java.util.*;
import java.io.*;
public class CountPair {
    static void countPair(int[] ar,int sum){
        var output = 0;
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = i+1; j < ar.length; j++) {
                var temp = ar[i] + ar[j];
                if(temp == sum)
                    output+=1;
            }
        }
        System.out.println("Count Pair = "+output);        
    }

    static void countPairEfficient(int[] ar,int sum){
        var hashMap = new HashMap<Integer,Integer>();
        var countPair = 0;
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], 1);
            else{
                var count = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], count);
            }
        }

        for (int i = 0; i < ar.length; i++) {
            if(hashMap.get(sum - ar[i]) != null)
                countPair+=hashMap.get(sum - ar[i]);
            if(sum - ar[i] == ar[i])
                countPair-=1;
        }

        System.out.println("Count Pair = "+countPair/2);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var sum = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                sum = Integer.parseInt(scanner.nextLine());
            }
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        countPairEfficient(ar,sum);
        scanner.close();
    }
}
