import java.io.*;
class Demo{
    public static int summation(int number){
        if(number == 1) return 1;
        return number +  summation(number-1);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
        int number = 10;
        number = summation(number);
        System.out.println("Summation = "+String.valueOf(number));
        buffer.close();
    }
}