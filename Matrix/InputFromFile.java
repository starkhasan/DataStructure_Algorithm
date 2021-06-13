import java.util.*;
import java.io.*;
public class InputFromFile {
    static void printMatrix(int[][] arr){
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    static void totalSum(int[][] arr){
        var sum = 0;
        for (var i = 0; i < arr.length; i++) {
            for (var j = 0; j < arr.length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("\nTotal Summation = "+sum);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var row = 0;
        var column = 0;
        int[][] arr = null;
        var arSize = 0;
        while (scanner.hasNext()) {
            if(isFirst){
                arSize = Integer.parseInt(scanner.nextLine());
                isFirst = false;
                arr = new int[arSize][arSize];
            }else{
                for (var item : scanner.nextLine().split(" ")) {
                    arr[row][column] = Integer.parseInt(item);
                    column+=1;
                }
                row += 1;
                column = 0;
            }
        }
        printMatrix(arr);
        totalSum(arr);
        scanner.close();
    }
}
