import java.util.*;
import java.io.*;
public class CountCharacter {
    static void countCharacter(String input){
        var countUpper = 0;
        var countLower = 0;
        var countSpecial = 0;
        var countDigit = 0;
        for (int i = 0; i < input.length(); i++) {
            if(Character.isUpperCase(input.charAt(i)))
                countUpper+=1;
            else if(Character.isLowerCase(input.charAt(i)))
                countLower+=1;
            else if(Character.isDigit(input.charAt(i)))
                countDigit+=1;
            else
                countSpecial+=1;
        }

        System.out.println("Upper Case : "+countUpper);
        System.out.println("Lower Case : "+countLower);
        System.out.println("Nunmber : "+countDigit);
        System.out.println("Special : "+countSpecial);
    }
    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            var input = "";
            while(sc.hasNext()){
                input = sc.nextLine();
            }
            countCharacter(input);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
