import java.io.*;
public class Demo{
    static int handShake(int n){
        return n*(n-1)/2;
    }
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Number of People : ");
        int number = Integer.parseInt(buffer.readLine());
        number = handShake(number);
        System.out.println("Total HandShake : "+number);
        buffer.close();
    }
}