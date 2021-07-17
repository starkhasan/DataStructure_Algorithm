/**
 * Calendar Program
 * Enter First Day (1-7): 5
 * Enter Total Days (29-31): 30

    SUN     MON     TUE     WED     THU     FRI     SAT
                                     1       2       3
     4       5       6       7       8       9      10
    11      12      13      14      15      16      17
    18      19      20      21      22      23      24
    25      26      27      28      29      30
 */
import java.util.Scanner;
class Calendar{
    public static void main(String [] args){
        var sc = new Scanner(System.in);
        var first_day = 0;
        var total_day = 0;
        try{
            System.out.print("Enter First Day (1-7): ");
            first_day=sc.nextInt();
            if(first_day==0 || first_day>7){
                throw new NumberFormatException("Please Enter Valid First Day");
            }
            System.out.print("\nEnter Total Days (29-31): ");
            total_day = sc.nextInt();
            if(total_day<29 || total_day>31){
                throw new NumberFormatException("Please Enter Valid Total Days in a Month");
            }
            var count = 1;
            System.out.println("\nSUN  \tMON  \tTUE  \tWED  \tTHU  \tFRI  \tSAT");
            for(int i=0;i<6;i++){
                for(int j=0;j<7;j++){
                    if(count>total_day)
                    break;
                    if(i==0){
                        if(j<first_day-1)
                            System.out.print("  \t");
                        else{
                            System.out.printf("%2d\t",count);
                            count++;
                        }
                    }
                    if(i>0){
                        if(j<7){
                            System.out.printf("%2d\t",count);
                            count++;
                        }
                        else
                            System.out.print("   ");
                    }
                    
                }
                System.out.println();
            }
        }catch(NumberFormatException ae){
            System.out.println(ae.getMessage());
        }
        sc.close();
    }
}

