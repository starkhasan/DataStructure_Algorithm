import java.util.*;
import java.io.*;
public class PrimeFactor {
    static void primeFactor(int number){
        while(number % 2 == 0){
            System.out.print(2+" ");
            number/=2;
        }

        for (int i = 3; i <= Math.sqrt(number); i+=2) {
            while(number%i == 0){
                System.out.print(i+" ");
                number/=i;
            }
        }
        if(number > 2)
            System.out.print(number+" ");
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input  = 0;
        while(scanner.hasNext())
            input = Integer.parseInt(scanner.nextLine());
        primeFactor(input);
        scanner.close();
    }
}
