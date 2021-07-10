import java.util.*;
import java.io.*;
class Demo{
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        scanner.close();
    }
}