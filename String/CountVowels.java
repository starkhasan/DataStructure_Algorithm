import java.util.*;
import java.io.*;
public class CountVowels {
    static int countVowels(String input){
        var count = 0;
        var vowels = "aeiou";
        for (int i = 0; i < input.length(); i++) {
            if(vowels.contains(input.substring(i, i+1)))
                count++;
        }
        return count;
    }

   

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input =  "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var result = countVowels(input);
        System.out.println("Total Number of Vowels = "+result);
        scanner.close();
    }
}
