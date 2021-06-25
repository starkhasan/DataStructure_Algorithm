import java.util.*;
import java.io.*;
public class Mean {
    static double mean(int[] ar){
        var n = ar.length;
        var sum = 0;
        for (int i : ar) {
            sum+=i;
        }
        return (double)sum/n;
    }

    static double median(int[] ar){
        var n = ar.length;
        if(n%2 == 0){
            n = n/2;
            return (double)(ar[n-1] + ar[n])/2;
        }else{
            return (double) ar[n/2];
        }
    }

    static int mode(int[] ar){
        var hashMap = new HashMap<Integer,Integer>();
        var modeNumber = Integer.MIN_VALUE;
        var count = 0;
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], 1);
            else{
                var tempCount = hashMap.get(ar[i]) + 1;
                if(count < tempCount){
                    count = tempCount;
                    modeNumber = ar[i];
                }
                hashMap.put(ar[i], tempCount);
            }
        }
        if(modeNumber == Integer.MIN_VALUE)
            return ar[0];
        return modeNumber;
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
        var result = mean(ar);
        System.out.println("Mean of Array = "+String.format("%.1f", result));
        result = median(ar);
        System.out.println("Meidan of Array = "+String.format("%.1f", result));
        var modeNumber = mode(ar);
        System.out.println("Mode of data set = "+modeNumber);
        scanner.close();
    }   
}
