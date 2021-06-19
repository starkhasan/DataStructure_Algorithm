import java.util.*;
import java.io.*;
public class MostFrequentElement {
    static int mostFrequentElement(int[] ar){
        var maxCount = 0;
        var element = 0;
        var max = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], 1);
            else{
                maxCount = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], maxCount);
                if(maxCount > max){
                    max = maxCount;
                    element = ar[i];
                }
            }
        }
        return element;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        var result = mostFrequentElement(ar);
        System.out.println("Most Frequent Element = "+result);
        scanner.close();
    }
}
