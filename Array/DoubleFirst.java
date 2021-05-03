//Double the first element and move zero to end
public class DoubleFirst {

    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }

    public static void doubleNumber(int[] ar){
        for(int i=0;i<ar.length-1;i++){
            if(ar[i] != 0 && ar[i+1] != 0){
                ar[i] = ar[i]*2;
                ar[i+1] = 0;
            }
        }
    }

    public static void shiftZeroEnd(int[] ar){
        int i = -1,temp = 0;
        for(int j = 0;j< ar.length;j++){
            if(ar[j] > 0){
                i+=1;
                temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }   
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 2, 2, 2, 0, 6, 6, 0, 0, 8};
        doubleNumber(arr);
        shiftZeroEnd(arr);
        printArray(arr);
    }
    
}
