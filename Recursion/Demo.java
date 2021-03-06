import java.util.*;
import java.io.*;
class Demo{
    static int consonent(String input,String vowels){
        if(input.isEmpty())
            return 0;
        else{
            var chr = input.substring(input.length()-1);
            if(!vowels.contains(chr))
                return 1+consonent(input.substring(0,input.length()-1), vowels);
            else
                return consonent(input.substring(0,input.length()-1), vowels);
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine();
        var vowels = "aeiou";
        var result = consonent(input,vowels);
        System.out.println(result);
        scanner.close();
    }
}