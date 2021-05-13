import java.io.*;

public class ReverseString {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str =buffer.readLine();
        System.out.println("String Before Reverse : "+str);
        str = new StringBuffer(str).reverse().toString();
        System.out.println("String After Reverse : "+str);
        buffer.close();
    }    
}
