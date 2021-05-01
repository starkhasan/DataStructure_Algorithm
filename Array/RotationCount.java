import java.util.Arrays;

//program for finding the rotation count in Rotated Sorted Array
public class RotationCount {
    public static int partition(int[] ar,int p,int r){
        int key = ar[r];
        int temp = 0;
        int i=p-1;
        for(int j=p;j<r;j++){
            if(ar[j] < key){
                i+=1;
                temp = ar[j];
                ar[j] = ar[i];
                ar[i] = temp;
            }
        }

        temp = ar[i+1];
        ar[i+1] = ar[r];
        ar[r] = temp;
        return i+1;
    }
    public static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }

    public static int findRotationCount(int[] old,int[] sorted){
        int min = sorted[0];
        for(int i=0;i<old.length;i++){
            if(min == old[i])
                return i;
        }
        return -1;
    }
    public static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12};
        int[] newArr = Arrays.copyOf(arr, arr.length);
        quickSort(newArr, 0, newArr.length-1);
        System.out.println("Rotation Count = "+findRotationCount(arr,newArr));
        printArray(arr);
    }
}
