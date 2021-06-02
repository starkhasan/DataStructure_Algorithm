import java.util.*;
import java.io.*;
class Demo{

    static String removeDuplicateVowels(String input){
        var result = "";
        var vowels = "aeiou";
        for (int i = 0; i < input.length(); i++) {
            if(!vowels.contains(input.substring(i, i+1)))
                result += input.substring(i, i+1);
            else{
                if(i==0)
                    result += input.substring(i, i+1);
                else if(!vowels.contains(input.substring(i-1, i)))
                    result += input.substring(i, i+1);   
            }
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        input = removeDuplicateVowels(input);
        System.out.println(input);
        scanner.close();
    }
}