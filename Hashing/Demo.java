import java.util.*;
import java.io.*;
class Demo{
    static void firstItem(int[] ar,int k){
        var first = -1;
        var pos = Integer.MAX_VALUE;
        var hashMap = new HashMap<Integer,Integer>();
        var posMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < ar.length; i++) {
            if(!hashMap.containsKey(ar[i])){
                hashMap.put(ar[i], 1);
                posMap.put(ar[i], i);
            }else{
                var temp = hashMap.get(ar[i]) + 1;
                hashMap.put(ar[i], temp);

                if(temp == k && pos > posMap.get(ar[i])){
                    first = ar[i];
                    pos = i;
                }
            }
        }
        System.out.println(first);
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var k = 0;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else{
                k = Integer.parseInt(scanner.nextLine());
            }
        }
        var strAr = input.split(" ");
        var ar = new int[strAr.length];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = Integer.parseInt(strAr[i]);
        }
        firstItem(ar,k);
        scanner.close();
    }
}