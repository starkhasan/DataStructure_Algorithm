public class DecimaltoBinary {
    static String binarynumber(int num,String bin){
        if(num > 0){
            bin+=String.valueOf((num%2));
            return binarynumber((num/2),bin);
        }else
            return bin;
    }
    public static void main(String[] args) {
        var num = 10;
        var bin = "";
        bin = binarynumber(num,bin);
        bin = new StringBuffer(bin).reverse().toString();  
        System.out.println(bin);     
    }
}
