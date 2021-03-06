import java.util.*;
import java.io.*;
public class PairProduct {
    static boolean pairProduct(int[] ar,int k){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(hashMap.containsKey(k/ar[i])){
                return true;
            }else
                hashMap.put(ar[i], i);
        }
        return false;
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
        var result = pairProduct(ar,k);
        System.out.println(result);
        scanner.close();
    }
}
