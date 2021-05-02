public class PartitionNumber {
    public static void rearrangeArray(int[] ar,int n){
        int i = -1,temp = 0,j=0;
        for(j=0;j<n;j++){
            if(ar[j] < 0){
                i+=1;
                temp = ar[j];
                ar[j] = ar[i];
                ar[i] = temp;
            }
        }
        int neg = 0,pos = i+1;
        while(pos < n && neg < pos){
            temp = ar[neg];
            ar[neg] = ar[pos];
            ar[pos] = temp;
            neg+=2;
            pos+=1;
        }
        
    }
    public static void printArray(int[] ar){
        System.out.println();
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        int arr[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};
        rearrangeArray(arr, arr.length);
        printArray(arr);
    }
}
