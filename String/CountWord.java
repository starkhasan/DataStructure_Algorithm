import java.util.*;
import java.io.*;
public class CountWord {
    static int countWords(String input){
        var count = 0;
        var strAr = input.split("\\s+");
        for (String string : strAr) {
            System.out.println(string);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            var input = "";
            while(scanner.hasNext()){
                input = scanner.nextLine();
            }
            var count = countWords(input);
            System.out.println("Total Word in String : "+count);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
