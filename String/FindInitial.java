import java.util.*;
import java.io.*;
public class FindInitial {
    static String initialName(String input){
        var result = "";
        var strAr = input.split(" ");
        for (String string : strAr) {
            result+=string.substring(0,1);
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var result = initialName(input);
        System.out.println(result);
        scanner.close();
    }
}
