import java.util.*;
import java.io.*;
public class TopRepeatedItem {
    static void topRepeatedItem(int[] ar){
        int minvalue = Integer.MIN_VALUE;
        int x = minvalue;
        int y = minvalue;
        int z = minvalue;
        var countX = 0;
        var countY = 0;
        var countZ = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i])){
                hashMap.put(ar[i], 1);
                if(x == minvalue){
                    x = ar[i];
                    countX = 0;
                }else if(y == minvalue){
                    y = ar[i];
                    countY = 0;
                }else if(z == minvalue){
                    z = ar[i];
                    countZ = 0;
                }
            }else{
                var count = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], count);
            }
        }
        System.out.println(x+" "+y+" "+z);
        for (int i = 0; i < ar.length; i++) {
            if(countX <= hashMap.get(ar[i])){
                countX = hashMap.get(ar[i]);
                x = ar[i];
            }else if(countY <= hashMap.get(ar[i])){
                countY = hashMap.get(ar[i]);
                y = ar[i];
            }else if(countZ <= hashMap.get(ar[i])){
                countZ = hashMap.get(ar[i]);
                z = ar[i];
            }
        }

        System.out.println(x+" "+y+" "+z);
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
        topRepeatedItem(ar);
        scanner.close();
    }
}
