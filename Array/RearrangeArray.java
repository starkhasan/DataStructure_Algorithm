import java.util.Arrays;

// import java.io.*;
// import java.util.*;
// public class RearrangeArray {

//     public static void rearrangeArray(int[] ar){
//         int[] newArr = Arrays.copyOf(ar, ar.length);
//         Arrays.sort(newArr);
//         int evenPos = ar.length/2;
//         int oddPos = ar.length - evenPos;
//         int j = oddPos - 1;
//         printArray(newArr);
//         for(int i=0;i<ar.length;i+=2){
//             ar[i] = newArr[j];
//             j--;
//         }

//         j = oddPos;
//         for(int i=1;i<ar.length;i+=2){
//             ar[i] = newArr[j];
//             j++;
//         }

//         printArray(ar);
//     }

//     public static void printArray(int[] arr){
//         System.out.println();
//         for (int i : arr) {
//             System.out.print(i+" ");
//         }
//     }

//     public static void main(String[] args) {
//         int[] arr = {1, 2, 3, 4, 5, 6, 7};
//         rearrangeArray(arr);
//     }
// }

//Program for rearrange array in order ---smallest , largest , 2nd smallest , 2nd largest


// public class RearrangeArray {
//     public static void printArray(int[] ar){
//         System.out.println();
//         for (int i : ar) {
//             System.out.print(i+" ");
//         }
//     }

//     public static int partition(int[] ar,int p,int r){
//         int key = ar[r],temp = 0;
//         int i = p-1;
//         for(int j=p;j<r;j++){
//             if(ar[j] < key){
//                 i+=1;
//                 temp = ar[i];
//                 ar[i] = ar[j];
//                 ar[j] = temp;
//             }
//         }

//         temp = ar[i+1];
//         ar[i+1] = ar[r];
//         ar[r] = temp;
//         return i+1;
//     }

//     public static int[] rearrange(int[] ar){
//         int n = ar.length;
//         int[] newArr = Arrays.copyOf(ar,n);
//         int arIndex = 0;
//         for(int i=0,j=n-1; i <= n/2 || j > n/2 ; i++,j--){
//             if(arIndex < n){
//                 newArr[arIndex] = ar[i];
//                 arIndex++;
//             }

//             if(arIndex < n){
//                 newArr[arIndex] = ar[j];
//                 arIndex++;
//             }
//         }
//         return newArr;
//     }

//     public static void quickSort(int[] ar,int p,int r){
//         if(p<r){
//             int q = partition(ar,p,r);
//             quickSort(ar, p, q-1);
//             quickSort(ar, q+1, r);
//         }
//     }
//     public static void main(String[] args) {
//         int arr[] = {1, 9, 2, 8, 3, 7, 4, 6, 5};
//         quickSort(arr, 0, arr.length-1);
//         arr = rearrange(arr);
//         printArray(arr);
//     }
// }


//Arrange Positive element at even and negative at odd position
public class RearrangeArray {
    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static int partition(int[] ar){
        int i = -1,temp = 0;
        for(int j=0;j<ar.length;j++){
            if(ar[j] > 0){
                i+=1;
                temp = ar[j];
                ar[j] = ar[i];
                ar[i] = temp;
            }
        }
        temp = ar[i+1];
        ar[i+1] = ar[ar.length-1];
        ar[ar.length-1] = temp;
        return i+1;
    }

    public static int[] separateNumbers(int[] ar){
        int pos = partition(ar);
        int index = 0;
        int[] newArr= new int[ar.length];
        for(int i=0,j=pos;i<pos||j<ar.length;i++,j++){
            if(i<pos){
                newArr[index] = ar[i];
                index++;
            }

            if(j<ar.length){
                newArr[index] = ar[j];
                index++;
            }
        }

        return newArr;
    }
    
    public static void main(String[] args) {
        int arr[] = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
        arr = separateNumbers(arr);
        printArray(arr);
    }
}
