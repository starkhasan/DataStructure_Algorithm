import java.util.*;
import java.io.*;
public class SlidingWindow {
    static void printArray(int[] ar){
        for (var item : ar) {
            System.out.print(item+" ");
        }
    }

    static int slidingWindow(int[] ar,int k){
        var result = 0;
        //computing result of first sliding window
        for (var i = 0; i < k; i++) {
            result+=ar[i];
        }

        var window_sum = result;
        for (var i = k; i < ar.length; i++) {
            window_sum+=ar[i] - ar[i-k];
            result = Math.max(window_sum, result);
        }
        return result;
    }
    public static void main(String[] args) {
        try {
            var file = new File("InputArray.txt");
            var sc = new Scanner(file);
            var input = "";
            while(sc.hasNext())
                input = sc.nextLine();
            var strAr = input.split(" ");
            var ar = new int[strAr.length];
            var index = 0;
            for (var item : strAr) {
                ar[index] = Integer.parseInt(item);
                index++;
            }
            var result = slidingWindow(ar, 4);
            System.out.println("Maximum Sum Using Sliding Window Technique : "+result);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
