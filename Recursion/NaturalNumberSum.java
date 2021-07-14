import java.util.*;
import java.io.*;
public class NaturalNumberSum {
    static int sum(int num){
        if(num == 1)
            return 1;
        else
            return num + sum(num-1);
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = Integer.parseInt(scanner.nextLine());
        var result = sum(input);
        System.out.println("Sum of Natural Number = "+result);
        result = sum(input);
        result = (int)Math.pow((double)result, 2.0);
        System.out.println("Sum of Square of Natural Number = "+result);
        scanner.close();
    }
}
