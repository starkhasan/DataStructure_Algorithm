/**
 * Return maximum occurring character in an input string
 */
import java.util.*;
import java.io.*;
public class RepeatedCharacter {
    static char maximumCharacter(String input){
        var count = Integer.MIN_VALUE;
        var chr = Character.MIN_VALUE;
        var hashMap = new HashMap<Character,Integer>();
        var charArray = input.toCharArray();
        for (var i = 0; i < charArray.length; i++) {
            if(!hashMap.containsKey(charArray[i])){
                hashMap.put(charArray[i], 1);
            }else{
                var temp = hashMap.get(charArray[i]) + 1;
                hashMap.put(charArray[i], temp);
                if(count < temp){
                    count = temp;
                    chr = charArray[i];
                }
            }
        }
        return chr;

    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        while(scanner.hasNext())
            input = scanner.nextLine();
        var result = maximumCharacter(input);
        System.out.println(result);
        scanner.close();
    }
}
