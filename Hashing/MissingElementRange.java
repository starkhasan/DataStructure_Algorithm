import java.util.*;
import java.io.*;
public class MissingElementRange {
    static void missingElementRange(int[] ar,int low,int high){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], 1);
            else{
                var count = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], count);
            }
        }

        for (int i = low; i < high; i++) {
            if(!hashMap.containsKey(i))
                System.out.print(i+" ");
        }
    }
    public static void main(String[] args)throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var low = 0;
        var high = 0;
        var inputSecond = "";
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                inputSecond = scanner.nextLine();
            }
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        var strAr = inputSecond.split(" ");
        low = Integer.parseInt(strAr[0]);
        high = Integer.parseInt(strAr[1]);
        missingElementRange(ar,low,high);
        scanner.close();
    }
}
