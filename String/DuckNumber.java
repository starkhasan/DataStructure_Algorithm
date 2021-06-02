import java.util.*;
import java.io.*;
public class DuckNumber {
    static boolean isDuck(String input){
        if(input.contains("0") && !input.substring(0,1).equals("0"))
            return true;
        return false;
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        if(isDuck(input))
            System.out.println("It is Duck Number");
        else
            System.out.println("It is not Duck Number");
        scanner.close();
    }
}
