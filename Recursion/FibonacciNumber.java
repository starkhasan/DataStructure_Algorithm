public class FibonacciNumber {
    public static int fib(int number){
        if(number == 0){
            return 0;
        } 
        if(number <= 1 || number == 2){
            return 1;
        }else
            return (fib(number-1) + fib(number-2));
    }
    public static void main(String[] args) {
        int number  = 0;
        while(number<=5){
            System.out.print(fib(number)+" ");
            number+=1;
        }
        //System.out.println("Fibonacci Number = "+String.valueOf(number));
    }
}
