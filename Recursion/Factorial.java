public class Factorial {
  public static int fact(int number){
      if(number == 1) return 1;
      return number * fact(number-1);
  }
  public static void main(String[] args) {
      int number = 5;
      number = fact(number);
      System.out.println("Factorial  = "+String.valueOf(number));
  }  
}
