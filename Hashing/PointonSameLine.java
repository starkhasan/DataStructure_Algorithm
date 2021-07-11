/**
 * Given N point on a 2D plane as pair of (x, y) co-ordinates, 
 * we need to find maximum number of point which lie on the same line.
 */
import java.util.*;
public class PointonSameLine {
    static int slop(int x1,int y1,int x2,int y2){
        try{
            var m = (y2-y1)/(x2-x1);
            return Math.abs(m);
        }catch(ArithmeticException e){
            return -1;
        }
    }
    static void maxPointonPlane(int[][] arr){
        var maxPoint = Integer.MIN_VALUE;
        var slopMap = new HashMap<Integer,Integer>();
        for (int i = 0; i < arr.length-1; i++) {
            var m = slop(arr[i][0] ,arr[i][1], arr[i+1][0], arr[i+1][1]);
            if(!slopMap.containsKey(m))
                slopMap.put(m, 1);
            else{
                var temp = slopMap.get(m) + 1;
                slopMap.put(m, temp);
                if(maxPoint < temp) maxPoint = temp;
            }
        }
        var keys = slopMap.keySet();
        for (var item : keys) {
            System.out.println(item);
        }
        System.out.println("Maximum points on Same Point = "+maxPoint);
    }
    public static void main(String[] args) {
        int[][] arr = {{-1, 1}, {0, 0}, {1, 1}, {2, 2},{3, 3}, {3, 4}};
        maxPointonPlane(arr);
    }
}
