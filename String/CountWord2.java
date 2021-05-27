import java.util.*;
import java.io.*;
public class CountWord2 {
   public static void main(String[] args) throws IOException{
       var file = new File("Input.txt");
       var scanner = new Scanner(file);
       var input = "";
       var string = "";
       var isFirst = true;
       while(scanner.hasNext()){
           if(isFirst){
               isFirst = false;
               input = scanner.nextLine();
           }else{
               string =scanner.nextLine();
           }
       }
       var strAr = input.split(" ");
       var count  = 0;
       for (String string2 : strAr) {
           if(string.contains(string2))
            count++;
       }
       System.out.println("Word Count = "+count);
       scanner.close();
   } 
}
