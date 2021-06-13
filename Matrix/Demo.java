import java.util.*;
import java.io.*;
class Demo{

    static void printMatrix(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        int[][] arr = null;
        var isFirst = true;
        var row = 0;
        var column = 0;
        var arSize = 0;
        while(scanner.hasNext()){
            if(isFirst){
                arSize = Integer.parseInt(scanner.nextLine());
                isFirst = false;
                arr = new int[arSize][arSize];
            }else{
                for (var item : scanner.nextLine().split(" ")) {
                    arr[row][column] = Integer.parseInt(item);
                    column+=1;
                }
                row+=1;
                column=0;
            }
        }
        printMatrix(arr);
        scanner.close();
    }
}