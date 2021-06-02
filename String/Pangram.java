import java.util.*;
import java.io.*;
public class Pangram {
    static boolean isPangram(String input){
        input = input.toLowerCase();
        char chr = 'a';
        for (int i = 0; i < 26; i++) {
            if(!input.contains(String.valueOf(chr)))
                return false;
            else{
                chr+=1;
            }
        }
        return true;

    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext()){
            input = scanner.nextLine();
        }
        if(isPangram(input))
            System.out.println("Yes! It is Pangram");
        else
            System.out.println("No! It is not Pangram");
        scanner.close();
    }
}
