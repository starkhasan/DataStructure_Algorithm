import java.util.*;
import java.io.*;
public class LinearSearch {
    static int linearSearch(int[] ar,int element){
        for (int i = 0; i < ar.length; i++) {
            if(ar[i] == element)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var element = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                element = Integer.parseInt(scanner.nextLine());
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        var result = linearSearch(ar,element);
        if(result > 0)
            System.out.println("Element Found at "+result);
        else
            System.out.println("Element Not Found");
        scanner.close();
    }
}
