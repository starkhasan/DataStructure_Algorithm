import java.util.*;
import java.io.*;
public class mNaturalSum {
    static int naturalSum(int num){
        if(num == 1)
            return num;
        else
            return num + naturalSum(num-1);
    }
    static int mthSum(int n,int m){
        if(m==1)
            return naturalSum(n);
        else
            return mthSum(naturalSum(n), m-1);  
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine().split(" ");
        var n = Integer.parseInt(input[0]);
        var m = Integer.parseInt(input[1]);
        var result = mthSum(n,m);
        System.out.println(result);
        scanner.close();
    }
}
