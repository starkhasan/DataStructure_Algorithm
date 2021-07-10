import java.util.*;
import java.io.*;
class Demo{
    
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        scanner.close();       
    }
}