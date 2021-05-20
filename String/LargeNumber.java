import java.io.*;
import java.util.*;
public class LargeNumber {
    static boolean numberDivisibleFour(String input){
        var result = false;
        var n = input.length();
        var lastDigit = 0;
        if(n > 2){
            lastDigit = Integer.parseInt(input.substring(n-2));
        }else{
            lastDigit = Integer.parseInt(input);
        }

        if(lastDigit %4 == 0)
            result = true;
        return result;
    }


    static boolean numberDivisibleEleven(String input){
        var isDivisible = false;
        var evenSum = 0;
        var oddSum = 0;
        for (var i = 0; i < input.length(); i++) {
            if(i%2 == 0)
                evenSum += Integer.parseInt(input.substring(i, i+1));
            else
                oddSum += Integer.parseInt(input.substring(i, i+1));
        }
        var diff = Math.abs(evenSum - oddSum);
        if(diff%11 == 0)
            isDivisible = true;
        return isDivisible;
    }


    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            var input = "";
            while(sc.hasNext()){
                input = sc.nextLine();
            }
            var isDivisible = numberDivisibleEleven(input);
            if(isDivisible)
                System.out.println("Yes!! It's Divisible");
            else
                System.out.println("No!! It's not");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
