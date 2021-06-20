import java.util.*;
import java.io.*;
public class PairProduct {
    static int pairProduct(int[] ar){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], 1);
            else{
                var count = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], count);
            }
        }
        for (int i = 0; i < ar.length-1; i++) {
            for (int j = i+1; j < ar.length; j++) {
                var temp = ar[i] * ar[j];
                if(hashMap.containsKey(temp))
                    return temp;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext()){
            input = scanner.nextLine();
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        var result = pairProduct(ar);
        System.out.println(result);
        scanner.close();;
    }
}
