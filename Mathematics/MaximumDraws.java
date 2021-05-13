import java.io.*;
public class MaximumDraws {
    static int maximumDraws(int number){
        return number+1;
    }
    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(buffer.readLine());
        System.out.println(maximumDraws(number));
        buffer.close();
    }
}
