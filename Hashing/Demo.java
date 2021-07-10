import java.util.*;
import java.io.*;
class Demo{
    static int maxDiatance(int[] ar){
        var hashMap = new HashMap<Integer, Integer>();
        var max = Integer.MIN_VALUE;
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i])){
                hashMap.put(ar[i], i);
            }else{
                var tempDistance = i - hashMap.get(ar[i]);
                if(tempDistance > max) max = tempDistance;
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
        var strAr = input.split(" ");
        var ar = new int[strAr.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(strAr[i]);
        }
        var result = maxDiatance(ar);
        System.out.println("Maximum Distance = "+result);
        scanner.close();
    }
}