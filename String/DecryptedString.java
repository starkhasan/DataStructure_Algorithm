import java.util.*;
import java.io.*;
public class DecryptedString {

    static String concat(String input,int n){
        if(n == 1)
            return input;
        else
            return input + concat(input, n-1);
    }

    static String decryptedString(String str,int k){
        var result = "";
        var repeat = "";
        var tempStr = "";  
        for (int i = 0; i < str.length(); i++) {
            if(Character.isDigit(str.charAt(i))){
                if(i+1 == str.length()){
                    repeat += str.substring(i, i+1);
                    result += concat(tempStr, Integer.parseInt(repeat));
                    tempStr = repeat = "";
                }else if(Character.isDigit(str.charAt(i+1))){
                    repeat += str.substring(i, i+1);
                }else{
                    repeat += str.substring(i, i+1);
                    result += concat(tempStr, Integer.parseInt(repeat));
                    tempStr = repeat = "";
                }
                
            }else{
                tempStr += str.substring(i, i+1);
            }
        }
        if(result.isBlank())
            result = str;
        System.out.println("Decrpted String = "+result);

        return String.valueOf(result.charAt(k-1));
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var k = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                k = Integer.parseInt(scanner.nextLine());
            }
        }
        var result = decryptedString(input, k);
        System.out.println("\nDecrypted String = "+result);
        scanner.close();
    }
}
