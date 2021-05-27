import java.io.*;
import java.util.*;
public class RemoveVowels {
    static String removeVowels(String input){
        var result = "";
        for (int i = 0; i < input.length(); i++) {
            var chr = input.charAt(i);
            if(chr != 'a' && chr != 'e' && chr != 'i' && chr != 'o' && chr != 'u')
                result+=input.substring(i, i+1);
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext()){
            input = scanner.nextLine();
        }
        var result = removeVowels(input);
        System.out.println("Ouput = "+result);
        scanner.close();
    }
}
