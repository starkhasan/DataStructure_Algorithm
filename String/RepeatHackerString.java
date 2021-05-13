import java.io.*;
public class RepeatHackerString {
    static String summation(String number){
        if(number.length() == 1)
            return number;
        else{
            int result = 0;
            for (int i = 0; i < number.length(); i++) {
                result+=Integer.parseInt(String.valueOf(number.charAt(i)));
            }
            return summation(String.valueOf(result));
        }
    }

    static int superDigit(String n, int k){
        if(n.length() == 1)
            return Integer.parseInt(n);
        else{
            n = n.repeat(k);
            return Integer.parseInt(summation(n));
        }
    }

    static String repeatString(String str,int count){
        //use this method below Java 11
        //since string repeat method is added  in Java 11, so i will have to implement repeation of string manually below Java 11
        if(count == 1)
            return str;
        else
            return str + repeatString(str, count-1);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String number = buffer.readLine();
        int repeat = Integer.parseInt(buffer.readLine());
        int result = superDigit(number, repeat);
        System.out.println(result);
        buffer.close();
    }
}
