import java.io.*;
public class HandShakes {
    static int handShakes(int n){
        return n*(n-1)/2;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter Person Number : ");
        int number = Integer.parseInt(buffer.readLine());
        number = handShakes(number);
        System.out.println("\nTotal HandShakes : "+number);
        buffer.close();
    }
}
