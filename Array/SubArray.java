import java.util.*;
import java.io.*;
public class SubArray {
    static void printSubArray(String str){
        var n = str.length();
        var pos = 0;
        var j = 0;
        for (int i = 0; i < n; i++) {
            pos = i;
            j = 0;
            while (pos < n) {
                System.out.println(str.subSequence(j, pos+1));
                pos+=1;
                j+=1;
            }
        }
    }

    static String subArray(String str,int i){
        if(i == str.length()-1)
            return array(str,i,i);
        else{
            var temp = array(str,i,i);
            return temp+" "+subArray(str, i+1);
        }
    }

    //this program for substring
    static String array(String str,int start,int end){
        if(end == str.length()-1)
            return str.substring(start, end+1);
        else{
            var temp = str.substring(start,end+1);
            return temp+" "+array(str, start, end+1);
        }
    }

    static void subArray(String str,int start,int end){
        if(end == str.length()-1)
            System.out.println(str.substring(start, end+1));
        else{
            System.out.println(str.substring(start,end+1));
            subArray(str, start, end+1);
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner  = new Scanner(file);
        var input = scanner.nextLine();
        //Iteratively
        //printSubArray(input);

        //using rescursion
        var result = subArray(input, 0);
        for(var string : result.split(" ")){
            System.out.println(string);
        }
        System.out.println("\nTotal SubArray = "+result.split(" ").length);
        scanner.close();
    }
}
