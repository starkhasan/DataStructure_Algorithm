import java.util.*;
import java.io.*;
public class JumpSearch {
    static int partition(int[] ar,int p,int r){
        var key = ar[r];
        var temp = 0;
        var i = p-1;
        for (int j = p; j < r; j++) {
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

    static void quickSort(int[] ar,int p,int r){
        if(p<r){
            var q = partition(ar,p,r);
            quickSort(ar, p, q-1);
            quickSort(ar, q+1, r);
        }
    }

    static int jumpSearch(int[] ar,int element){
        var step = (int) Math.sqrt(ar.length);
        var startPos = -1;
        var prevIndex = -1;
        var j = 0;
        while(j < ar.length){
            if(ar[j] > element){
                startPos = prevIndex;
                break;
            }
            if(ar[j] == element)
                return j; 
            prevIndex = j;
            j+=step;
        }
        if(startPos < 0) startPos = prevIndex;
        for (int i = startPos; i < ar.length; i++) {    
            if(ar[i] == element)
                return i;
        }
        return -1;
    }

    static void printElement(int[] ar){
        for (int i : ar) {
            System.out.print(i+" ");
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var input = "";
        var isFirst = true;
        var element = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                element = Integer.parseInt(scanner.nextLine());
        }
        var ar = new int[input.split(" ").length];
        for (int i = 0; i < input.split(" ").length; i++) {
            ar[i] = Integer.parseInt(input.split(" ")[i]);
        }
        quickSort(ar, 0, ar.length-1);
        printElement(ar);
        var result = jumpSearch(ar,element);
        if(result >= 0)
            System.out.println("Found Element at "+result);
        else
            System.out.println("Element No Found");
        scanner.close();
    }
}
