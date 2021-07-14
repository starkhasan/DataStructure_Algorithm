public class DigitSum {
    static int digitSum(int num){
        var x = 0;
        if(num == 0)
            return 0;
        else{
            x = num%10;
            return x+digitSum(num/10);
        }
    }
    public static void main(String[] args) {
        var num = 12345;
        var result = digitSum(num);
        System.out.println(result);
    }
}
