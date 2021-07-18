import java.util.*;
import java.io.*;
public class Divisibility {
    //Divisible by 2
    static boolean isDivisibleTwo(String input,int k){
        int digit = Integer.parseInt(input.substring(input.length()-1));
        if(digit%2 == 0)
            return true;
        return false;
    }

    //Divisible by 3
    static boolean isDivisibleThree(String input,int k){
        var sum = 0;
        for (var item : input.split("")) {
            sum+=Integer.parseInt(item);
        }
        if(sum%k == 0)
            return true;
        return false;
    }

    //Divisible by 4
    static boolean isDivisibleFour(String input,int k){
        int lastTwoDigit = Integer.parseInt(input.substring(input.length()-2));
        if(lastTwoDigit%4 == 0)
            return true;
        return false;
    }

    //Divisible by 5
    static boolean isDivisibleFive(String input,int k){
        if(input.endsWith("5") || input.endsWith("0"))
            return true;
        return false;
    }

    //Divisible by 6
    static boolean isDivisibleSix(String input,int k){
        if(isDivisibleTwo(input,2) && isDivisibleThree(input, 3))
            return true;
        return false;
    }

    //Divisible by 8
    static boolean isDivisibleEight(String input,int k){
        int lastDigit = Integer.parseInt(input.substring(input.length()-3));
        if(lastDigit%8 == 0)
            return true;
        return false;
    }

    //Divisible by 9
    static boolean isDivisibleNine(String input,int k){
        var sum = 0;
        for (var item : input.split("")) {
            sum+=Integer.parseInt(item);
        }
        if(sum%k == 0)
            return true;
        return false;
    }

    //Divisible by 10
    static boolean isDivisibleTen(String input,int k){
        if(input.endsWith("0"))
            return true;
        return false;
    }

    
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var k = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                k = Integer.parseInt(scanner.nextLine());
        }
        var result = isDivisibleTen(input, k);
        if(result)
            System.out.println(input+" is divisible by "+k);
        else
            System.out.println(input+" is not divisible by "+k);
        scanner.close();
    }
}
