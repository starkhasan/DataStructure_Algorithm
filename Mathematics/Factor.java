import java.util.*;
import java.io.*;
public class Factor {
    static List<Integer> factors(int number){
        var listFactor = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
            if(number%i == 0)
                listFactor.add(i);
        }
        return listFactor;
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var number = 0;
        while(scanner.hasNext())
            number = Integer.parseInt(scanner.nextLine());
        var result = factors(number);
        for (Integer integer : result) {
            System.out.print(integer+" ");
        }
        scanner.close();   
    }
}
