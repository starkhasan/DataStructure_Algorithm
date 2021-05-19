import java.util.*;
import java.io.*;
public class PrefixInfix {

    static String prefixInfix(String input){
        Stack<String> stack = new Stack<String>();
        String result = "";
        for (int i = input.length()-1; i >= 0; i--) {
            if(Character.isLetterOrDigit(input.charAt(i))){
                stack.push(input.charAt(i)+"");
            }else{
                String temp = "(" +stack.pop() + input.charAt(i) +stack.pop()+ ")";
                stack.push(temp);
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) throws IOException{
       BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
       String input = "";
       while(buffer.readLine()!=null){
           input = buffer.readLine();
       }
       input = prefixInfix(input);
       System.out.println(input);
       buffer.close();
   } 
}
