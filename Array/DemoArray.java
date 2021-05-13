import java.io.*;

public class DemoArray{
    static int summation(int[] ar,int p,int r){
        int result = 0;
        for (int i = p; i <= r; i++) {
            result+=ar[i];            
        }
        return result;
    }

    static int binarySummation(int[] ar,int p,int r,int mid){
        if(mid >= 0 && mid <= ar.length -1){
            int result1 = 0;
            if(mid != 0)
                result1 = summation(ar, p, mid-1);
            int result2 = 0;
            if(mid != ar.length-1)
                result2 = summation(ar, mid+1, r);
            if(mid == 0 || mid == ar.length-1)
                return result1 == result2 ? 0 : -1;
            else if(result1 == result2)
                return mid;
            
            if(result1 < result2)
                return binarySummation(ar, p, r, mid+1);
            return binarySummation(ar, p, r, mid-1);
        }
        return -1;
    }
    static String balancedSums(int[] arr){
        int mid = (0 + arr.length-1) / 2;
        if(binarySummation(arr, 0, arr.length-1, mid) < 0)
            return "No";
        else
            return "Yes";
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new FileReader("InputArray.txt"));
        String input = "";
        while((buffer.readLine()) != null){
            input = buffer.readLine();
        }
        String[] strArr = input.split(" ");
        int[] arr = new int[strArr.length];
        int count = 0;
        for (String string : strArr) {
            arr[count] = Integer.parseInt(string);
            count++;
        }
        String result = balancedSums(arr);
        System.out.println(result);
        buffer.close();
    }
}