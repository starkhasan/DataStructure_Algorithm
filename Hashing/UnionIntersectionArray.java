import java.util.*;
import java.io.*;
public class UnionIntersectionArray {
    static void intersection(int[] ar1,int[] ar2){
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar1.length; i++) {
            if(!hashMap.containsKey(ar1[i]))
                hashMap.put(ar1[i], 1);
        }
        System.out.println("Intersection ");
        for (int i = 0; i < ar2.length; i++) {
            if(hashMap.containsKey(ar2[i]))
                System.out.print(ar2[i]+" ");
            else
                hashMap.put(ar2[i], 1);
        }

        System.out.println("\nUnion ");
        var keys = hashMap.keySet();
        for (var integer : keys) {
            System.out.print(integer+" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var isFirst = true;
        var inputFirst = "";
        var inputSecond = "";
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                inputFirst = scanner.nextLine();
            }else{
                inputSecond = scanner.nextLine();
            }
        }

        var strAr = inputFirst.split(" ");
        var firstAr = new int[strAr.length];
        for (int i = 0; i < firstAr.length; i++) {
            firstAr[i] = Integer.parseInt(strAr[i]);
        }
        strAr = inputSecond.split(" ");
        var secondAr = new int[strAr.length];
        for (int i = 0; i < secondAr.length; i++) {
            secondAr[i] = Integer.parseInt(strAr[i]);
        }
        intersection(firstAr,secondAr);
        scanner.close();        
    }
}
