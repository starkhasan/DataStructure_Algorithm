import java.io.*;
import java.util.*;
public class Duplicate {

    // Time Complexity should be O(n) and Space Complexity should be O(1)
    static int removeUplicate(int[] ar){
        int j = 0;
        for (int i = 0; i < ar.length - 1; i++) {
            if(ar[i] != ar[i+1]){
                ar[j++] = ar[i];
            }
        }

        ar[j++] = ar[ar.length-1];
        return j;
    }

    //sort the array using quickSort

    static int partition(int[]ar,int p,int r){
        int key = ar[r];
        int i = p-1;
        int temp = 0;
        for (int j = p; j < r; j++) {
            if(ar[j] < key){
                i+=1;
                temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp; 
            }
        }

        temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;
        return i+1;
    }

    static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }

    public static void main(String[] args) throws IOException{
        // BufferedReader buffer = new BufferedReader(new FileReader("InputArray.txt"));
        // String input = "";
        // List<Integer> _listItem = new ArrayList<Integer>();
        // while(buffer.readLine()!=null){
        //     input = buffer.readLine();
        // }
        // String[] strAr = input.split(" ");
        // for (String string : strAr) {
        //     int item = Integer.parseInt(string);
        //     if(_listItem.contains(item))
        //         System.out.print(item+" ");
        //     else
        //         _listItem.add(item);
        // }
        // buffer.close();
        int[] ar = {1,2,2,3,4,5,5,5,6,7,7,7,8};
        quickSort(ar, 0, ar.length-1);
        int lastIndex = removeUplicate(ar);
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(ar[i]);
        }
    }
}


// Time Complexity should be O(n) and Space Complexity should be O(1)
