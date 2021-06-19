import java.util.*;
import java.io.*;
public class ElementMaxDistance {
    static int maximumElementDistance(int[] ar){
        var max = 0;
        var tempDistance = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i])){
                hashMap.put(ar[i], i);
            }else{
                tempDistance = i - hashMap.get(ar[i]);
                if(tempDistance > max)
                    max = tempDistance;
            }
        }
        return max;
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
        var result = maximumElementDistance(ar);
        System.out.println("Maximum Distance = "+result);
        scanner.close();
    }
}
