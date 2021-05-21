import java.util.*;
import java.io.*;
public class KDistanceString {
    static String distinctString(int n,int k){
        var result = "";
        var chr = 'a';
        var kCount = 0;
        while(n > 0){
            if(kCount < k){
                result+=chr;
                chr+=1;
                kCount+=1;
            }else{
                kCount = 0;
                chr = 'a';
                result+=chr;
                chr+=1;
            }
            n-=1;
        }
        return result;
    }
    public static void main(String[] args) {
        try{
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            var n = 0;
            var k = 0;
            var isFirst = true;
            while(scanner.hasNext()){
                if(isFirst){
                    isFirst = false;
                    n = Integer.parseInt(scanner.nextLine());
                }else{
                    k = Integer.parseInt(scanner.nextLine());
                }
            }
            var result = distinctString(n,k);
            System.out.println(result);
            scanner.close();
        } catch(FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
}
