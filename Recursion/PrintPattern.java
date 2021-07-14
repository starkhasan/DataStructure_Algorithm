//Microsoft Interview Question
import java.util.*;
import java.io.*;
public class PrintPattern {
    static void printPattern(int num){
        if(num == 0 || num < 0){
            System.out.print(num+" ");
            return;
        }
        System.out.print(num+" ");
        printPattern(num-5);
        System.out.print(num+" ");
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var num = Integer.parseInt(scanner.nextLine());
        printPattern(num);
        scanner.close();
    }
}
