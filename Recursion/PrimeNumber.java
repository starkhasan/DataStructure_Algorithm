import java.util.*;
import java.io.*;
public class PrimeNumber {
    static boolean isPrimeNumber(int start,int number){
        if(start  < number/2){
            if(number % start  == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = Integer.parseInt(scanner.nextLine());
        var result = isPrimeNumber(2,input);
        if(result)
            System.out.println("Prime Number");
        else
            System.out.println("Not Prime Number");
        scanner.close();
    }
}
