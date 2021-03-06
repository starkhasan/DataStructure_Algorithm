import java.util.*;
import java.io.*;
public class DigitSum {

    static int digitsSum(String input){
        var result = 0;
        var startIndex = 0;
        var endIndex = 0;
        boolean isCalculate = false;
        System.out.println(input);
        for (var i = 0; i < input.length(); i++) {
            if(Character.isDigit(input.charAt(i))){
                if(i == 0){
                    isCalculate = false;
                    startIndex = i;
                }else if(!Character.isDigit(input.charAt(i-1))){
                    if(i == input.length()-1){
                        isCalculate = true;
                        startIndex = i;
                        endIndex = i+1;
                    }else{
                        isCalculate = false;
                        startIndex = i;
                    }
                }else if(i == input.length()-1){
                    isCalculate = true;
                    endIndex = i+1;
                }
            }else if(i!=0){
                if(Character.isDigit(input.charAt(i-1))){
                    isCalculate = true;
                    endIndex = i;
                }else{
                    isCalculate = false;
                }
            }

            if(isCalculate){
                result+=Integer.parseInt(input.substring(startIndex, endIndex));
            } 
        }
        return result;
    }

    static int digitSumSmall(String input){
        var temp = "0";
        var sum = 0;
        for (var i = 0; i < input.length(); i++) {
            var chr = input.charAt(i);
            if(Character.isDigit(chr)){
                temp+=chr;
            }else{
                sum+=Integer.parseInt(temp);
                temp = "0";
            }
        }
        sum+=Integer.parseInt(temp);
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
            var temp = digitSumSmall(input);
            if(temp != 0)
                System.out.println("Total Sum of Digits Present in String : "+temp);
            else
                System.out.println("No! Digits are present in the String");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
