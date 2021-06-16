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
        var file  = new File("Input.txt");
        var scanner = new Scanner(file);
        var firstAr = "";
        var secondAr = "";
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                firstAr = scanner.nextLine();
            }else{
                secondAr = scanner.nextLine();
            }
        }

        int[] ar1 = new int[firstAr.split(" ").length];
        int[] ar2 = new int[secondAr.split(" ").length];
        var count = 0;
        for (String item : firstAr.split(" ")) {
            ar1[count] = Integer.parseInt(item);
            count+=1;
        }
        count = 0;
        for (String i : secondAr.split(" ")){
            ar2[count] = Integer.parseInt(i);
            count+=1;
        }
        if(isSubSet(ar1,ar2))
            System.out.println("Yes! arr2[] is subset of arr1[] ");
        else
            System.out.println("No! arr2[] is not subset of arr1[] ");
        scanner.close();
    }   
}
