import java.io.*;
import java.util.*;
public class MaxDigitInString {
    static int maxDigitInString(String input){
        var result = -1;
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
                var temp = Integer.parseInt(input.substring(startIndex, endIndex));
                if(result < temp)
                    result = temp; 
            } 
        }
        return result;
    }
    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            String input = "";
            while(sc.hasNext()){
                input = sc.nextLine();
            }
            var result = maxDigitInString(input);
            if(result >= 0)
                System.out.println("Maximum Digit in String : "+result);
            else
                System.out.println("No Digit Present in String");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }    
}
