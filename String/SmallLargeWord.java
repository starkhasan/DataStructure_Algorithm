import java.util.*;
import java.io.*;
public class SmallLargeWord {
    static void smallLarge(String input){
        var smallWord = "";
        var largeWord = "";
        var isFirst = true;
        var strAr = input.split(" ");
        for (String string : strAr) {
            if(isFirst){
                isFirst = false;
                largeWord = smallWord = string;
            }else{
                if(smallWord.length() > string.length())
                    smallWord = string;
                if(largeWord.length() < string.length())
                    largeWord = string;
            }
        }

        System.out.println("Minimum length word : "+smallWord);
        System.out.println("Maximum length word : "+largeWord);
    }
    
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext()){
            input = scanner.nextLine();
        }
        smallLarge(input);
        scanner.close();
    }
}
