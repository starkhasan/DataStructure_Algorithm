//We are performing the shuffle using Fisher-Yates Shuffle Algorithm in the O(n) time complexity
import java.util.Random;
public class ShuffleArray {
    public static void shuffle(int[] ar,int n){
        Random random = new Random();
        int temp = 0,j=0;
        for(int i=n-1;i>=0;i--){
            j = random.nextInt(i+1);
            System.out.println(j);
            temp = ar[j];
            ar[j] = ar[i];
            ar[i] = temp;
        }
    }
    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        
        shuffle(arr,arr.length);
        printArray(arr);
    }
}

/*
Generating Random number in java using Random Class 
import using import java.util.Random;

Random random  = new Random();  ///making new instance of Random class

Invoke one of the following methods of rand object:
    nextInt(upperbound) generates random numbers in the range 0 to upperbound-1.
    nextFloat() generates a float between 0.0 and 1.0.
    nextDouble() generates a double between 0.0 and 1.0.

*/