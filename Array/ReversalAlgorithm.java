import java.util.*;
import java.io.*;
public class ReversalAlgorithm {
    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    static void reverse(int[] ar,int start,int end){
        var temp = 0;
        while(start < end){
            temp = ar[start];
            ar[start] = ar[end];
            ar[end] = temp;
            start+=1;
            end-=1;
        }
    }

    static void reversalAlgorithm(int[] ar,int d){
        int n = ar.length;
        d = d%n;
        reverse(ar,0,d-1);
        reverse(ar,d,n-1);
        reverse(ar,0,n-1);
    }
    public static void main(String[] args) throws FileNotFoundException{
       var file = new File("Input.txt");
       var scanner = new Scanner(file);
       var input = "";
       var isFirst = true;
       var d = 0;
       while(scanner.hasNext()){
           if(isFirst){
               isFirst = false;
               input = scanner.nextLine();
           }else{
               d = Integer.parseInt(scanner.nextLine());
           }
       }
       var strAr = input.split(" ");
       var ar = new int[strAr.length];
       for (int i = 0; i < ar.length; i++) {
           ar[i] = Integer.parseInt(strAr[i]);
       }
       reversalAlgorithm(ar, d);
       printArray(ar);
       scanner.close(); 
    }
}
