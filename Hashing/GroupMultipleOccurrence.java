import java.util.*;
import java.io.*;
public class GroupMultipleOccurrence {
    static void groupMultipleOccurrence(int[] ar){
        var hashMap = new HashMap<Integer,Integer>();
        var listArray = new ArrayList<Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i])){
                listArray.add(ar[i]);
                hashMap.put(ar[i], 1);
            }else{
                var count = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], count);
            }
        }


        for (Integer item : listArray) {
            var count = hashMap.get(item);
            while(count > 0){
                System.out.print(item+" ");
                count-=1;
            }
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        groupMultipleOccurrence(ar);
        scanner.close();
    }    
}
