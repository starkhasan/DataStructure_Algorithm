import java.io.*;
import java.util.*;
public class Demo {
    static void subString(String input){
        var variable =  input.substring(0);
        System.out.println(variable);
    }
    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            String input = "";
            while(sc.hasNext()){
                input = sc.nextLine();
            }
            subString(input);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
