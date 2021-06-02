import java.util.*;
import java.io.*;
public class RemoveConsecutiveVowels {
    static String removeConsecutiveVowels(String input){
        var result = "";
        var vowels = "aeiou";
        input = input.toLowerCase();
        for (int i = 0; i < input.length(); i++) {
            if(!vowels.contains(input.substring(i,i+1)))
                result += input.substring(i,i+1);
            else
                if(i==0)
                    result += input.substring(i,i+1);
                else if(!vowels.contains(input.substring(i-1,i)))
                    result += input.substring(i,i+1);
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        input = removeConsecutiveVowels(input);
        System.out.println(input);
        scanner.close();
    }
}
