public class ReorderArray {
    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static int[] reorder(int[] ar,int[] index){
        int[] newArr = new int[ar.length];
        for(int i=0;i<index.length;i++){
            newArr[i] = ar[index[i]];
        }
        return newArr;
    }
    
    public static void main(String[] args) {
        int arr[]   = {10, 11, 12};
        int index[] = {1, 0, 2};
        arr = reorder(arr, index);
        printArray(arr);
    }
}
