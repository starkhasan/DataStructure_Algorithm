import java.io.*;
public class Palindrome {
    // public static void main(String[] args) {
    //     String str = "123321";
    //     StringBuffer strBuffer = new StringBuffer(str);
    //     String newStr = strBuffer.reverse().toString();
    //     if(newStr.equals(str))
    //         System.out.println("String is Palidrome");
    //     else
    //         System.out.println("String is not Palidrome");
    // }

    public static boolean checkPalindrome(String str){
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String st = "112233445566778899000000998877665544332211";
        if(checkPalindrome(st)){
            System.out.println("Number is Palindrome");
        }else{
            System.out.println("Number is not Palindrome");
        }
    }
}