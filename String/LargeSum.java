import java.io.*;
import java.util.*;
public class LargeSum {
    static String reverseString(String input){
        StringBuffer strBuffer = new StringBuffer(input);
        return strBuffer.reverse().toString();
    }
    static String largeSummation(String first,String second){
        first = reverseString(first);
        second = reverseString(second);
        var result = "";
        var firstIndex = 0;
        var secondIndex = 0;
        var carry = 0;
        var temp = 0;
        while(firstIndex < first.length() || secondIndex < second.length()){
            temp = carry;
            if(firstIndex < first.length()){
                temp+=Integer.parseInt(first.substring(firstIndex, firstIndex+1));
                firstIndex+=1;
            }

            if(secondIndex < second.length()){
                temp+=Integer.parseInt(second.substring(secondIndex, secondIndex+1));
                secondIndex+=1;
            }

            carry = temp / 10;
            temp = temp % 10;
            result += String.valueOf(temp);
        }
        result = reverseString(result);
        return result;
    }
    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            var firstInput = "";
            var secondInout = "";
            boolean isFirst = true;
            while(sc.hasNext()){
                if(isFirst){
                    isFirst = false;
                    firstInput = sc.nextLine();
                }else{
                    secondInout = sc.nextLine();
                }
            }
            var result = largeSummation(firstInput,secondInout);
            System.out.println(result);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
