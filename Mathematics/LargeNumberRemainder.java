import java.io.*;
import java.util.*;
public class LargeNumberRemainder {
    static int lcmArray(int[] ar,int m){
        var mod = 0;
        var quotient = "";
        for (int i = 0; i < ar.length; i++) {
            var temp = (mod * 10 + ar[i]) / m;
            mod = (mod * 10 + ar[i]) % m;
            quotient+=String.valueOf(temp);
        }
        System.out.println(quotient);
        return mod;
    }
    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            var input = "";
            while(scanner.hasNext()){
                input = scanner.nextLine();
            }
            var strAr = input.split(" ");
            var ar = new int[strAr.length];
            for (var i = 0; i < ar.length; i++) {
                ar[i] = Integer.parseInt(strAr[i]);
            }
            var result = lcmArray(ar,9);
            System.out.println("LCM of Array = "+result);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
