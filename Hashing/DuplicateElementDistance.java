import java.util.*;
import java.io.*;
public class DuplicateElementDistance {
    static boolean duplicateElementKDistance(int[] ar,int k){
        var tempDistance = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], i);
            else{
                tempDistance = i - hashMap.get(ar[i]);
                if(tempDistance == k)
                    return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var k = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                k = Integer.parseInt(scanner.nextLine());
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        if(duplicateElementKDistance(ar,k))
            System.out.println("True");
        else
            System.out.println("False");
        scanner.close();
    }
}
