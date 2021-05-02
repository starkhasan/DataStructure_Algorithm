public class MoveZero {
    public static void moveZero(int[] ar){
        int i = -1,temp = 0;
        for(int j=0;j<ar.length;j++){
            if(ar[j] > 0){
                i+=1;
                temp = ar[j];
                ar[j] = ar[i];
                ar[i] = temp;
            }
        }
    }
    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9};
        moveZero(arr);
        printArray(arr);
    }
}
