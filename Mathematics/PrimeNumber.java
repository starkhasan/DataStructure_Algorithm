import java.util.*;
import java.io.*;
public class PrimeNumber{
    static boolean isPrime(int number){
        if(number  == 1)
            return false;
        for (var i = 2; i <= number/2; i++) {
            if(number%i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var sc = new Scanner(file);
            var input = 0;
            while(sc.hasNext())
                input = Integer.parseInt(sc.nextLine());
            if(isPrime(input))
                System.out.println("Number is Prime");
            else
                System.out.println("Number is not Prime");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}