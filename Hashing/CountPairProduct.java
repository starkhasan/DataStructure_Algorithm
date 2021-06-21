import java.util.*;
import java.io.*;
public class CountPairProduct {
    static void countPairProduct(int[] ar){
        var countPair = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            hashMap.put(ar[i], 1);
        }
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = i+1; j < ar.length; j++) {
                var temp = ar[i] * ar[j];
                if(hashMap.containsKey(temp))
                    countPair+=1;
            }
        }
        System.out.println("Count Product Pair = "+countPair);
    }
    public static void main(String[] args) throws  FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        countPairProduct(ar);
        scanner.close();
    }
}
