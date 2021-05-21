import java.util.*;
import java.io.*;
public class CountSubstring {
    static boolean distinctCount(String input,int count){
        var resultCount = 0;
        var tempStr = "";
        for (var i = 0; i < input.length(); i++) {
            var temp = input.substring(i, i+1);
            if(!tempStr.contains(temp)){
                tempStr+=temp;
                resultCount+=1;
            }
        }

        if(resultCount == count)
            return true;
        else
            return false;
    }
    static int distinctSubstring(String input,int k){
        var lastIndex = input.length() - k;
        var resultCount = 0;
        for (var i = 0; i <= lastIndex; i++) {
            var subFirstIndex = i;
            var subLastIndex = i+k;
            var tempLastIndex = subLastIndex;
            while(tempLastIndex <= input.length()){
                var temp = input.substring(subFirstIndex, tempLastIndex);
                if(distinctCount(temp,k))
                    resultCount+=1;
                tempLastIndex+=1;
            }
        }
        return resultCount;
    }
    public static void main(String[] args) {
        try {
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
            var count = distinctSubstring(input,k);
            System.out.println("Total Distinct Substring = "+count);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    } 
}
