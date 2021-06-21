import java.util.*;
import java.io.*;
public class NoCommonElement {
    static void noCommonElement(int[] ar,int[] br){
        var hashMapA = new HashMap<Integer,Integer>();
        var hashMapB = new HashMap<Integer,Integer>();
        var commonElement = 0;
        for (int i = 0; i < ar.length; i++) {
            if(!hashMapA.containsKey(ar[i]))
                hashMapA.put(ar[i], 1);
            else{
                var count = hashMapA.get(ar[i]) + 1;
                hashMapA.put(ar[i], count);
            }
        }

        for (int i = 0; i < br.length; i++) {
            if(!hashMapB.containsKey(br[i]))
                hashMapB.put(br[i], 1);
            else{
                var count = hashMapB.get(br[i]) + 1;
                hashMapB.put(br[i], count);
            }
        }

        var keys = hashMapA.keySet();
        for (var item : keys) {
            if(hashMapB.containsKey(item)){
                commonElement+= Math.min(hashMapA.get(item), hashMapB.get(item));
            }
        }
        System.out.println(commonElement);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var inputSecond = "";
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                inputSecond = scanner.nextLine();
        }
        var ar = new int[input.split(" ").length];
        var br = new int[inputSecond.split(" ").length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        for (int i = 0; i < br.length; i++) {
            br[i] = Integer.parseInt(inputSecond.split(" ")[i]);
        }
        noCommonElement(ar,br);
        scanner.close();
    }
}
