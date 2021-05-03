public class MeanMedian {
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
            quickSort(ar, q+1, r);
        }
    }

    public static double arraySum(int[] ar){
        int result = 0;
        for (int i : ar) {
            result+=i;
        }
        return (double)result;
    }

    public static void meanMedian(int[] ar){
        quickSort(ar, 0, ar.length-1);
        double mean = arraySum(ar) / (double)ar.length;
        System.out.println("Mean = "+mean);
        double median = 0.0;
        if(ar.length%2 != 0){
            median = (double)ar[ar.length/2];
        }else{
            median = (double)(ar[(ar.length - 1)/2] + ar[ar.length/2]) / 2.0;
        }
        System.out.println("Median = "+median);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 4, 2, 7, 5, 8, 6 };
        meanMedian(arr);
    }
}
