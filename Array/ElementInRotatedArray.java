import java.util.*;
import java.io.*;
public class ElementInRotatedArray {
    static void rightRotation(int[] ar,int start,int end){
        var item = ar[end];
        for (int i = end; i > start; i--) {
            ar[i] = ar[i-1];
        }
        ar[start] = item;
    }
    static void findElement(int[] ar,int[][] range,int index){
        for (int i = 0; i < range.length; i++) {
            var start = range[i][0];
            var end = range[i][1];
            rightRotation(ar, start, end);
        }
        System.out.println(ar[index]);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = scanner.nextLine().split(" ");
        var ar = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            ar[i] = Integer.parseInt(input[i]);
        }
        int[][] ranges = { { 0, 2 }, { 0, 3 } };
        int index = 1;
        findElement(ar,ranges,index);
        scanner.close();
    }
}
