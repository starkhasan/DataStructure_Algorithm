import java.util.*;
import java.io.*;
public class MissingPangram {
    static String missingPangram(String input){
        var result = "";
        input = input.toLowerCase();
        var ch = 'a';
        for (int i = 0; i < 26; i++) {
            if(!input.contains(String.valueOf(ch))){
                result+=ch;
            }
            ch+=1;
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var result = missingPangram(input);
        if(result.isBlank())
            System.out.println("All Character are Present");
        else
            System.out.println("Missing Characters = "+result);
        scanner.close();
    }
}
