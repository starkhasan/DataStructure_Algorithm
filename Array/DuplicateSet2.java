import java.io.*;
import java.util.*;
public class DuplicateSet2 {
    static int removeDuplicate(int[] ar){
        int j = 0;
        boolean isFirst = true;
        for (int i = 0; i < ar.length-1; i++) {
            if(ar[i] != ar[i+1]){
                ar[j++] = ar[i]; 
            }else {
                if (isFirst) {
                    isFirst = false;
                    System.out.println("\nDuplicate Items : ");
                    System.out.print(ar[i]+" "); 
                } else {
                    System.out.print(ar[i]+" ");
                }
            }
        }
        ar[j++] = ar[ar.length-1];
        return j;
    }

    static void printArray(int[] ar){
        System.out.println("Original Array : ");
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("InputArray.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext()){
            input = scanner.nextLine();
        }
        var strAr = input.split(" ");
        var count = 0;
        var ar = new int[strAr.length];
        for (String string : strAr) {
            ar[count] = Integer.parseInt(string);
            count++;
        }
        printArray(ar);
        int pos = removeDuplicate(ar);
        System.out.println("\nArray After Removal of Duplicate Items : ");
        for (int i = 0; i < pos; i++) {
            System.out.print(ar[i]+" ");
        }
        scanner.close();
    }
}
