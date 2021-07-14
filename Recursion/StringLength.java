import java.util.*;
import java.io.*;
public class StringLength {
    static int lengthString(String str){
        if(str.isEmpty())
            return 0;
        else
            return 1+lengthString(str.substring(0,str.length()-1));
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine();
        System.out.println(lengthString(input));
        scanner.close();
    }
}
