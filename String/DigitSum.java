import java.util.*;
import java.io.*;
public class DigitSum {
    static int digitSummation(String input){
        var result = 0;
        
        return result;
    }
    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            var input = "";
            while(sc.hasNext()){
                input = sc.nextLine();
            }
            var temp = digitSummation(input);
            System.out.println(temp);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
