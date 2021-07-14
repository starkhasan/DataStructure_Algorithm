import java.util.*;
import java.io.*;
public class PalindromeString {
    static String reverseString(String str){
        if(str.length() == 1)
            return str.substring(0, 1);
        else{
            var temp = str.substring(str.length()-1);
            return temp+reverseString(str.substring(0,str.length()-1));
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine();
        var result = reverseString(input);
        if(result.equals(input))
            System.out.println("String is Palindrome");
        else
            System.out.println("String is not Palindrome");
        scanner.close();
    }
}
