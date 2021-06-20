import java.util.*;
import java.io.*;
public class MultipleRepeatingItem {
    static void multipleRepeatingItem(int[] ar){
        var count = 0;
        var hashMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i]))
                hashMap.put(ar[i], 1);
            else{
                count = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], count);
                System.out.print(ar[i]+" ");
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
       var file = new File("Input.txt");
       var scanner = new Scanner(file);
       var input = "";
       while(scanner.hasNext()){
           input = scanner.nextLine();
       }
       var arr = new int[input.split(" ").length];
       for (int i = 0; i < input.split(" ").length; i++) {
           arr[i] = Integer.parseInt(input.split(" ")[i]);
       }
       multipleRepeatingItem(arr);
       scanner.close();
   } 
}
