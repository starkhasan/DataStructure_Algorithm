import java.util.*;
import java.io.*;
public class ReverseIndividual {
    static String reverse(String str){
        var strBuffer = new StringBuffer(str);
        return strBuffer.reverse().toString()+" ";
    }
    static String reverseIndividual(String string){
        var result = "";
        var strAr = string.split(" ");
        for (String string2 : strAr) {
            result+=reverse(string2);
        }
        return result;
    }
    public static void main(String[] args) throws IOException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        input = reverseIndividual(input);
        System.out.println(input);
        scanner.close();
    }
}
