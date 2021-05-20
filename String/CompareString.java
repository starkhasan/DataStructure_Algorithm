import java.io.*;
import java.util.*;
public class CompareString {
    static void compareString(String first,String second){
        System.out.println(first.compareTo(second));
        System.out.println(second.compareTo(first));
        //we can also use first.compareToIgnoreCase(second) for comparing string if string are case insensitive
    }
    public static void main(String[] args) {
        try {
            File file = new File("Input.txt");
            Scanner sc = new Scanner(file);
            String input = "";
            while(sc.hasNext()){
                input = sc.nextLine();
            }
            String inputFirst = input.split(" ")[0];
            String inputSecond = input.split(" ")[1];
            compareString(inputFirst, inputSecond);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
