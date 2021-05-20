import java.util.*;
import java.io.*;
public class PrimeProduct {
    static boolean isPrime(int number){
        if(number == 1)
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
            var scanner = new Scanner(file);
            
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
