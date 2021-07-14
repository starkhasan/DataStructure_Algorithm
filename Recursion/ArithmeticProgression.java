import java.util.*;
import java.io.*;
public class ArithmeticProgression {
    static int ap(int a,int d,int n){
        if(n == 0)
            return a-d;
        else{
            return ap(a,d,n-1)+d;
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine().split(" ");
        var a = Integer.parseInt(input[0]);
        var d = Integer.parseInt(input[1]);
        var n = Integer.parseInt(input[2]);
        var result = ap(a,d,n);
        System.out.println("Arithmetic Progression of "+n+" Number = "+result);
        scanner.close();
    }
}
