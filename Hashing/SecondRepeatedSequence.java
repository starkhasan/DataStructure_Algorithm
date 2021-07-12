/**
 * Given a sequence of strings, the task is to find out the second most repeated (or frequent) string in the given sequence.
 * (Considering no two words are the second most repeated, there will be always a single word)
 */
import java.util.*;
import java.io.*;
public class SecondRepeatedSequence {
    static String secondMostRepeated(String[] input){
        var result = "";
        var hashMap = new HashMap<String,Integer>();
        var max = Integer.MIN_VALUE;
        var maxResult = "";
        for (int i = 0; i < input.length; i++) {
            if(!hashMap.containsKey(input[i]))
                hashMap.put(input[i],1);
            else{
                var temp = hashMap.get(input[i]) + 1;
                hashMap.put(input[i], temp);
                if(max < temp){
                    max = temp;
                    maxResult = input[i];
                } 
            }
        }System.out.println(maxResult);
        max = Integer.MIN_VALUE;
        var keys = hashMap.keySet();
        for (var item : keys) {
            if(!item.equals(maxResult)){
                if(max < hashMap.get(item)){
                    max = hashMap.get(item);
                    result = item;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        String[] input = null;
        while(scanner.hasNext())
            input = scanner.nextLine().split(" ");
        var result = secondMostRepeated(input);
        System.out.println(result);
        scanner.close();
    }
}
