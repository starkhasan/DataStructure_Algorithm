public class LeftRightRotation {

    public static void leftRotation(int[] ar,int k){
        while(k>0){
            int first = ar[0];
            for(int i = 0; i < ar.length-1; i++){
                ar[i] = ar[i+1];
            }
            ar[ar.length-1] = first;
            k--;
        }
    }

    public static void rightRotation(int[] ar,int k){
        int lastIndex = ar.length - 1;
        while(k>0){
            int last = ar[lastIndex];
            for(int i = lastIndex; i > 0; i--){
                ar[i] = ar[i-1];
            }
            ar[0] = last;
            k--;
        }
    }

    public static int summation(int[] ar,int l,int r){
        int result = 0;
        for(int i=l;i<=r;i++){
            result+=ar[i];
        }
        return result;
    }
    
    public static void main(String[] args) {
        int result = 0;
        int[] ar = {1,2,3,4,5};
        rightRotation(ar, 3);
        result = summation(ar, 0, 2);
        System.out.println("Summation = "+result);
        leftRotation(ar, 1);
        result = summation(ar, 1, 4);
        System.out.println("Summation = "+result);
    }
}
