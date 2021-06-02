import java.util.*;
import java.io.*;
public class BinaryString {
    static int countBinaryString(String input){
        var count = 0;
        var i = 0;
        var j = 0;
        while(i < input.length()){
            if(input.substring(i, i+1).equals("1")){
                j = i+1;
                while(j < input.length()){
                    if(input.substring(j, j+1).equals("1")){
                        count+=1;
                    }
                    j+=1;
                }
            }
            i+=1;
        }
        return count;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var result = countBinaryString(input);
        System.out.println(result);
        scanner.close();        
    }
}
