import java.util.*;
import java.util.stream.Collectors;
public class AllCommonElementMatrix {
    static void printCommonElement(int[][] matrix){
        var hashMap = new HashMap<Integer,Integer>();
        var commonElement = new ArrayList<Integer>();
        for (int i = 0; i < matrix[0].length; i++) {
            hashMap.put(matrix[0][i], 1);
        }
        var keyPresent = true;
        for (var key : hashMap.keySet()) {
            keyPresent = true;
            for (int i = 0; i < matrix.length; i++) {
               var matList = Arrays.stream(matrix[i]).boxed().collect(Collectors.toList());
               if(!matList.contains(key)){
                   keyPresent = false;
                   break;
               }
            }
            if(keyPresent)
                commonElement.add(key);
        }

        for (var integer : commonElement) {
            System.out.print(integer+" ");
        }
    }

    public static void main(String[] args){
        int mat[][] =
        {
            {1, 2, 1, 4, 8},
            {3, 7, 8, 5, 1},
            {8, 7, 7, 3, 1},
            {8, 1, 2, 7, 9},
        };
        printCommonElement(mat);       
    }
}