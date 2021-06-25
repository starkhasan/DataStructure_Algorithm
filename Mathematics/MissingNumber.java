import java.util.*;
import java.io.*;
public class MissingNumber {
    static int summationNumber(int n){
        return n*(n+1)/2;
    }
    static int missingNumber(int[] ar){
        var totalSum = summationNumber(ar.length+1);
        var sum = 0;
        for (int i : ar) {
            sum+=i;
        }
        return totalSum - sum;
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
        var result = missingNumber(ar);
        System.out.println("Missing Number = "+result);
        scanner.close();
    }
}
