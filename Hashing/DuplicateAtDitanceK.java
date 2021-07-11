import java.util.*;
import java.io.*;
public class DuplicateAtDitanceK {
    static boolean duplicateAtDistanceK(int[] ar,int k){
        var hashMap = new HashMap<Integer,Integer>();
        var count = 0;
        var j = 0;
        for (int i = 0; i < ar.length - k; i++) {
            hashMap.clear();
            count = 0;
            j = i+1;
            while(count < k){
                if(!hashMap.containsKey(ar[j]))
                    hashMap.put(ar[j], 1);
                else{
                    return true;
                }
                j+=1;
                count+=1;
            }
        }
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var distance = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                distance = Integer.parseInt(scanner.nextLine());
            }
        }
        var strAr = input.split(" ");
        var ar = new int[strAr.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(strAr[i]);
        }
        var result = duplicateAtDistanceK(ar, distance);
        if(result)
            System.out.println("Duplicate Present ");
        else
            System.out.println("Duplicate Element not present");
        scanner.close();
    }
}
