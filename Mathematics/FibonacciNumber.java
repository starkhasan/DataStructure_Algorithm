import java.util.*;
public class FibonacciNumber{
    static void printFibonacciNumber(int n){
        var first = 1;
        var second = 0;
        var temp = 0;
        for (int i = 0; i < n; i++) {
            if(i<=1)
                System.out.print(i+" ");
            else{
                temp = first + second;
                System.out.print(temp+" ");
                second = first;
                first = temp;
                
            }
        }
    }
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        var n = scanner.nextInt();
        printFibonacciNumber(n);
        scanner.close();
    }
}