/**
 * Naive Pattern Searching
 * Slide the pattern over text one by one and check for the match, 
 * if there is match just print the first match index of text String.
 */
import java.util.*;
import java.io.*;
public class NaivePattern {
    static void patternMatch(String text,String pattern){
        var textLength = text.length();
        var patternLength = pattern.length();
        for (int i = 0; i <= textLength - patternLength; i++) {
            var result = text.subSequence(i, i+patternLength);
            if(result.equals(pattern))
                System.out.println("Pattern found at index "+i);
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var text = "";
        var pattern = "";
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                text = scanner.nextLine();
            }else
                pattern = scanner.nextLine();
        }
        patternMatch(text,pattern);
        scanner.close();
    }
}
