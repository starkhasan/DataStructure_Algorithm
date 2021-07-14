import java.util.*;
import java.io.*;
public class CountConsonent {
    static int countConsonent(String input,String vowels){
        if(input.isEmpty())
            return 0;
        else{
            var chr = input.substring(input.length()-1);
            if(!vowels.contains(chr))
                return 1+countConsonent(input.substring(0,input.length()-1), vowels);
            else
                return countConsonent(input.substring(0,input.length()-1), vowels);
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine();
        var vowels = "aeiou";
        var result = countConsonent(input,vowels);
        System.out.println("Number of Consonent = "+result);
        scanner.close();
    }
}
