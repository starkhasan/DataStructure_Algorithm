import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;
public class ReverseWord {
    static void reverseWord(String input){
        String[] strAr = input.split(" ");
        for (int i = strAr.length-1; i >= 0; i--) {
            System.out.print(strAr[i]+" ");
        }
    }

    static void reverseUsingPattern(String input){
        Pattern pattern = Pattern.compile("\\s");
        String[] strAr = pattern.split(input);
        for (int i = strAr.length-1; i >= 0; i--) {
            System.out.print(strAr[i]+" ");
        }   
    }
    public static void main(String[] args){
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            String input = "";
            while(sc.hasNext()){
               input = sc.nextLine();
            }
            reverseUsingPattern(input);
            sc.close();   
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
