import java.util.*;
import java.io.*;
public class TwoNumberProduct {
    static int product(int x,int y){
        if(y == 0)
            return 0;
        else{
            return x+product(x, y-1);
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine();
        var x = Integer.parseInt(input.split(" ")[0]);
        var y = Integer.parseInt(input.split(" ")[1]);
        var result = product(x,y);
        System.out.println(result);
        scanner.close();
    }
}
