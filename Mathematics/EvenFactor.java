import java.util.*;
import java.io.*;
public class EvenFactor {
    static int evenFactorSum(int number){
        var sum = 0;
        for (int i = 1; i <= number; i++) {
            if(number%i == 0 && i%2 == 0){
                System.out.print(i+" ");
                sum+=i;
            }
        }
        return sum;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var number = 0;
        while(scanner.hasNext())
            number = Integer.parseInt(scanner.nextLine());
        var result = evenFactorSum(number);
        System.out.println("Summation of Even Factor = "+result);
        scanner.close();   
    }
}
