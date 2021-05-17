import java.io.*;
import java.util.*;

public class CountingTowns {
    
    static int connectingTowns(int towns,List<Integer> routes){
        int roads = 0;
        for(int i : routes){
            roads*=i;
            roads%=1234567;
        }
        return roads;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("Input.txt"));
        List<Integer> _listRoute = new ArrayList<>();
        String input = "";
        while((buffer.readLine())!=null){
            input = buffer.readLine();
        }
        String[] strAr = input.split(" ");
        for(String temp:strAr){
            _listRoute.add(Integer.parseInt(temp));
        }
        int result = connectingTowns(_listRoute.size(),_listRoute);
        System.out.println("Total Roads = "+result);
        buffer.close();
    }
}
