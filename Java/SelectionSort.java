import java.util.Scanner;
public class SelectionSort {

    public void selectionSort(int ar[]){
        int ar_size = ar.length;
        int min=0,pos=0;
        for(int i=0;i<ar_size;i++){
            min = ar[i];
            pos = i;
            for(int j=i;j<ar_size;j++){
                if(min>ar[j]){
                    min = ar[j];
                    pos = j;
                }
            }
            int temp = ar[i];
            ar[i] = min;
            ar[pos] = temp;
        }
    }
    public static void main(String[] args) {
        SelectionSort demo = new SelectionSort();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Size of Array : ");
        int ar_size = sc.nextInt();
        int[] ar = new int[ar_size];
        System.out.println("Enter the Element in Array : ");
        for(int i=0;i<ar_size;i++){
            ar[i] = sc.nextInt();
        }
        demo.selectionSort(ar);
        System.out.println("Sorted Array : ");
        for(int i=0;i<ar_size;i++){
            System.out.print(ar[i]+" ");
        }
        sc.close();
    }

}