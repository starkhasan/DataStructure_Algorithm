import java.util.*;
import java.io.*;
public class TotalArrangement {

    static int duplicateCharacter(String input){
        var result = 1;
        var temp = "";
        for (var i = 0; i < input.length(); i++) {
            if(temp.contains(input.substring(i,i+1)))
                result+=1;
            else
                temp+=input.substring(i,i+1);
        }
        return result;
    }

    static int factorial(int number){
        if(number == 1 || number == 0)
            return 1;
        else
            return number * factorial(number-1);
    }

    static int totalString(String input){
        var totalResult = 0;
        var duplicate = duplicateCharacter(input);
        duplicate = factorial(duplicate);
        var total = input.length();
        total = factorial(total);
        totalResult = total / duplicate;
        return totalResult;
    }

    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            var input = "";
            while(scanner.hasNext())
                input = scanner.nextLine();
            var result = totalString(input);
            System.out.println("Total Arrangement of String = "+result);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }        
    }
}
