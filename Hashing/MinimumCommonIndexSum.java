import java.util.*;
import java.io.*;
public class MinimumCommonIndexSum {
    static void minimumCommonIndexSum(String[] strA, String[] strB){
        var hashMap = new HashMap<String,Integer>();
        var listResult = new ArrayList<String>();
        var min = Integer.MAX_VALUE;
        var sum = 0;
        for (int i = 0; i < strA.length; i++)
            hashMap.put(strA[i], i);
        
        for (int i = 0; i < strB.length; i++) {
            if(hashMap.containsKey(strB[i])){
                sum = i + hashMap.get(strB[i]);
                if(sum < min){
                    min = sum;
                    listResult.clear();
                    listResult.add(strB[i]);
                }else if(sum == min)
                    listResult.add(strB[i]);
            }
        }

        for (String string : listResult) {
            System.out.print(string+" ");
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var inputFirst = "";
        var inputSecond = "";
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                inputFirst = scanner.nextLine();
            }else{
                inputSecond = scanner.nextLine();
            }
        }

        var strA = inputFirst.split(" ");
        var strB = inputSecond.split(" ");
        minimumCommonIndexSum(strA, strB);
        scanner.close();
    }
}
