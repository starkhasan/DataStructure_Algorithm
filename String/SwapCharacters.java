import java.io.*;
import java.util.*;
public class SwapCharacters{
    static void swapChar(String str){
        String[] strAr = str.split(" ");
        for (String string : strAr) {
            char[] chr = string.toCharArray();
            char temp = chr[0];
            chr[0] = chr[chr.length-1];
            chr[chr.length-1] = temp;
            System.out.print(new String(chr)+" ");

        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        swapChar(str);
        sc.close();       
    }
}