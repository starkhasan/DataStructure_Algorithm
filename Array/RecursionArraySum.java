public class RecursionArraySum {
    static int sum(int[] ar,int n){
        if(n==1)
            return ar[0];
        else
            return ar[n-1] + sum(ar,n-1);
    }
    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5,6,7,8,9,10};
        var result = sum(ar,ar.length);
        System.out.println("Total Sum = "+result);
    } 
}
