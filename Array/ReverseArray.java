// public class ReverseArray {

//     public static void reverseArray(int[] ar){
//         int ar_size = ar.length;
//         int n = ar_size;
//         if(ar_size%2 == 0){
//             ar_size = ar_size/2;
//         }else{
//             ar_size = (ar_size+1)/2;
//         }
//         for(int i=0;i<ar_size;i++){
//             int temp = ar[i];
//             ar[i] = ar[n-1-i];
//             ar[n-1-i] = temp;
//         }
//     }
//     public static void printArray(int[] ar){
//         for (int i : ar) {
//             System.out.print(i+" ");
//         }
//     }
//     public static void main(String[] args) {
//         int arr[] = {12, 10, 5, 6, 52, 36};
//         printArray(arr);
//         reverseArray(arr);
//         System.out.println();
//         printArray(arr);
//     }
// }



//using recursive method
public class ReverseArray{
    public static void reverseArray(int[] ar,int start,int end){
        if(start >= end)
            return;
        int temp = ar[start];
        ar[start] = ar[end];
        ar[end] = temp;
        reverseArray(ar, start+1, end-1);
    }

    public static void printArray(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {12, 10, 5, 6, 52, 36};
        reverseArray(arr, 0, arr.length-1);
        printArray(arr);
    }
}