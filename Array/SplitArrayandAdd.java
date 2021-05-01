public class SplitArrayandAdd {

    public static void splitArray(int[] ar,int k){
        while(k>0){
            int temp = ar[0];
            for(int i=0;i<ar.length-1;i++){
                ar[i] = ar[i+1];
            }
            ar[ar.length-1] = temp;
            k-=1;
        }
    }

    public static void main(String[] args) {
        int arr[] = {12, 10, 5, 6, 52, 36};
        int index = 2;
        splitArray(arr, index);
        System.out.println();
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
