import java.io.*;
public class InsertionSort{
    public static void sort(int[] ar){
        for(int j=1;j<ar.length;j++){
            int key = ar[j];
            int i = j-1;
            while(i>=0 && ar[i] > key){
                ar[i+1] = ar[i];
                i-=1;
            }
            ar[i+1] = key;
        }
    }
    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int[] ar = {3,4,2,6,8,9,1,23,7};
        sort(ar);
        printArray(ar);
        buffer.close();
    }
}