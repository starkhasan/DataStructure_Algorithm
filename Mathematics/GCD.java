import java.util.*;
import java.io.*;
public class GCD {
    static int gcd(int a,int b){
        if(a == 0)
            return b;
        else if(b == 0)
            return a;
        else{
            var rem = a%b;
            return gcd(b,rem);
        }
    }
    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            var firstNumber = 0;
            var secondNumber = 0;
            var isFirst = true;
            while(scanner.hasNext()){
                if(isFirst){
                    isFirst = false;
                    firstNumber = Integer.parseInt(scanner.nextLine());
                }else{
                    secondNumber = Integer.parseInt(scanner.nextLine());
                }
            }
            var result = gcd(firstNumber,secondNumber);
            System.out.println("\nGCD of "+firstNumber+" and "+secondNumber+" is : "+result);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
