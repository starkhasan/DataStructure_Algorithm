import java.util.*;
import java.io.*;
public class MinimumDistictSubset{
    static void minimumDistinctSubset(int[] ar){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], 1);
            else{
                var count = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], count);
            }
        }

        var subset = 0;
        for (int i = 0; i < ar.length; i++) {
            var count = hashMap.get(ar[i]);
            subset = Math.max(subset, count);
        }

        System.out.println("Minimum Subset : "+subset);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        minimumDistinctSubset(ar);
        scanner.close();
    }
}