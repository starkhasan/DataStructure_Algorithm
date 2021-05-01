/*
class Example {
    static void fun1(int n)
    {
    int i = 0;  
    if (n > 1)
        fun1(n - 1);
    for (i = 0; i < n; i++)
        System.out.print(" * ");
    System.out.println();
    }
    public static void main(String[] args) {
        int number = 8;
        fun1(number);
    }    
}*/


// class Example {
//     static void fun(int x)
//     {   
//         if(x > 0)
//         {
//             fun(--x);
//             System.out.print(x + " ");
//             fun(--x);
//         }
//     }
//     public static void main(String[] args) {
//         int number = 4;
//         fun(number);
//     }   
    
//     //0 1 2 0 3 1
// }


class Example {
  
    static int fun(int a[],int n)
    {
        int x;
        if(n == 1)
            return a[0];
        else
            x = fun(a, n - 1);
        if(x > a[n - 1]){
            System.out.println(a[n - 1]+" "+x);
            return x;
        }else{
            System.out.println("----"+a[n-1]);
            return a[n - 1];
        }
    }
     
    public static void main (String[] args)
    {
        int arr[] = {12, 10, 30, 50, 100};
        System.out.println(" "+fun(arr, 5)+" ");
    }
}
