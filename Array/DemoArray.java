
// public class DemoArray {
//     public static void printArray(int[] ar){
//         System.out.println();
//         for (int i : ar) {
//             System.out.print(i+" ");
//         }
//     }

//     public static int partition(int[] ar,int p,int r){
//         int key = ar[r];
//         int i = p-1,temp = 0;
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
//     public static void quickSort(int[] ar,int p,int r){
//         if(p<r){
//             int q = partition(ar,p,r);
//             quickSort(ar, p, q-1);
//             quickSort(ar, q+1, r);
//         }
//     }


//     public static int[] makeArrange(int[] ar){
//         int[] newArr = new int[ar.length];
//         int index = 0,n = ar.length;
//         for(int i=0,j=n-1;i <= n/2 || j > n/2;i++,j--){
//             if(index < n){
//                 newArr[index] = ar[j];
//                 index++;
//             }

//             if(index < n){
//                 newArr[index] = ar[i];
//                 index++;
//             }
//         }
//         return newArr;
//     }
//     public static void main(String[] args) {
//         int arr[] = {1, 2, 3, 4, 5, 6, 7} ;
//         arr = makeArrange(arr);
//         printArray(arr);
//     }
// }



public class DemoArray{
    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static int partition(int[] ar,int p,int r){
        int key = ar[r],temp = 0;
        int i = p-1;
        for(int j=p;j<r;j++){
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
    public static void quickSort(int[] ar,int p,int r){
        if(p<r){
            int q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar,q+1,r);
        }
    }
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15} ;
        int k = 3;
        quickSort(arr, 0, arr.length-1);
        System.out.println(arr[k-1]);
        //printArray(arr);
    }
}