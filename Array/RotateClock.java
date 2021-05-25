import java.util.*;
import java.io.*;
public class RotateClock {
    static void rotateClock(int[] ar,int k){
        if(ar.length != 0 && ar.length != 1 && k != 0){
            int size = ar.length;
            int n = size;
            n = k%n;
            if(n != 0){
                var count = 0;
                while(count < k){
                    var temp = ar[size-1];
                    for(int i = size-2;i>=0;i--){
                        ar[i+1] = ar[i];
                    }
                    ar[0] = temp;
                    count+=1;
                }
            }
        }
    }

    static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("InputArray.txt");
        var scanner = new Scanner(file);
        var input = "";
        var k = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                k = Integer.parseInt(scanner.nextLine());
            }
        }
        var strAr = input.split(" ");
        var ar = new int[strAr.length];
        for (var i = 0; i < strAr.length; i++) {
            ar[i] = Integer.parseInt(strAr[i]);
        }
        rotateClock(ar,k);
        printArray(ar);
        scanner.close();
    }
}
