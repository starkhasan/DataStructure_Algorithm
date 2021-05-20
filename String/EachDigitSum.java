import java.io.*;
import java.util.*;
public class EachDigitSum {
    static int eachDigitSum(String input){
        var sum = 0;
        for (int i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))){
                sum+=Integer.parseInt(input.substring(i, i+1));
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            var input = "";
            while(sc.hasNext()){
                input = sc.nextLine();
            }
            var result = eachDigitSum(input);
            if(result >= 0)
                System.out.println("All Digit Summation = "+result);
            else
                System.out.println("No! Digit present in the String");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
