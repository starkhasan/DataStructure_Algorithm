import java.io.*;
import java.util.*;
class Node{
    Node next;
    String data;
    Node(String data){
        this.data = data;
        next = null;
    }
}
public class InfixPrefix {

    static int prec(char symbol){
        switch (symbol) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String convertExpression(String infix){
        String result = "";
        char temp;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < infix.length(); i++) {
            temp = infix.charAt(i);
            if(Character.isLetterOrDigit(temp)){
                result+=temp;
            } else if(infix.charAt(i) == '('){
                stack.push(temp);
            } else if(infix.charAt(i) == '{'){
                stack.push(temp);
            } else if(infix.charAt(i) == '['){
                stack.push(temp);
            } else if(infix.charAt(i) == ')'){
                while (!stack.isEmpty() && stack.peek() != '(')
                    result += stack.pop();
                stack.pop();
            } else if(infix.charAt(i) == '}'){
                while (!stack.isEmpty() && stack.peek() != '}')
                    result += stack.pop();
                stack.pop();
            } else if(infix.charAt(i) == ']'){
                while (!stack.isEmpty() && stack.peek() != ']')
                    result += stack.pop();
                stack.pop();
            } else{
                while (!stack.isEmpty() && prec(temp) <= prec(stack.peek()))
                    result += stack.pop();
                stack.push(temp);
            }
        }
        while(!stack.isEmpty()){
            result += stack.peek();
            stack.pop();
        }
        return result;
    }

    static char changeBracket(char input){
        switch (input) {
            case '(':
                return ')';
            case ')':
                return '(';
            case '{':
                return '}';
            case '}':
                return '{';
            case '[':
                return ']';
        }
        return input;
    }

    static String reverseInfixString(String input){
        String result = "";
        for (int i = input.length()-1 ;i >= 0; i--) {
            if(Character.isLetterOrDigit(input.charAt(i))){
                result += input.charAt(i);
            }else{
                result += changeBracket(input.charAt(i));
            }
        }
        return result;
    }

    static String reverseResult(String result){
        StringBuffer strbuffer = new StringBuffer(result);
        return strbuffer.reverse().toString();
    }

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
        String input = "";
        while(buffer.readLine()!=null){
            input = buffer.readLine();
        }
        input = reverseInfixString(input);
        String result = convertExpression(input);
        result = reverseResult(result);
        System.out.println(result);
        buffer.close();   
    }
}
