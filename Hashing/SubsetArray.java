import java.util.*;
import java.io.*;
public class SubsetArray {
    static boolean isSubSet(int[] ar1,int[] ar2){
        var hashSet = new HashSet<Integer>();
        for (int i = 0; i < ar1.length; i++) {
            if(!hashSet.contains(ar1[i]))
                hashSet.add(ar1[i]);
        }
        for (int i = 0; i < ar2.length; i++) {
            if(!hashSet.contains(ar2[i]))
                return false;
        }
        return true;
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
        if(isSubSet(firstAr,secondAr))
            System.out.println("Yes! arr2[] is subset of arr1[] ");
        else
            System.out.println("No! arr2[] is not subset of arr1[] ");
        scanner.close();
    }   
}
