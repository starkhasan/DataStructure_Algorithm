import java.util.*;
import java.io.*;
public class LCM {
    static int gcd(int a,int b){
        if(a == 0)
            return b;
        else if(b == 0)
            return a;
        else{
            var rem = a%b;
            return gcd(b,rem);
        }
    }
    static int lcm(int n1,int n2){
        var temp = gcd(n1,n2);
        return (n1*n2)/temp;
    }
    public static void main(String[] args) {
        try {
            var file = new File("Input.txt");
            var scanner = new Scanner(file);
            var n1 = 0;
            var n2 = 0;
            var isFirst = true;
            while(scanner.hasNext()){
                if(isFirst){
                    isFirst = false;
                    n1 = Integer.parseInt(scanner.nextLine());
                }else{
                    n2 = Integer.parseInt(scanner.nextLine());
                }
            }

            var result = lcm(n1,n2);
            System.out.println("\nLCM of "+n1+" and "+n2+" is : "+result);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
