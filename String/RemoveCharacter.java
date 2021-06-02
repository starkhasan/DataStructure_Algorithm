import java.util.*;
import java.io.*;
public class RemoveCharacter {
    static String removeCharacter(String first,String second){
        var result = "";
        for (int i = 0; i < first.length(); i++) {
            if(!second.contains(first.substring(i,i+1))){
                result += first.substring(i,i+1);
            }
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var second = "";
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                second = scanner.nextLine();
            }
        }
        input = removeCharacter(input,second);
        System.out.println("Result = "+input);
        scanner.close();
    }
}
