import java.io.*;
public class StrangeGrid {
    public static long strangeGrid(int row, int column) {
        long firstItem = 0;
        if(row%2 == 0){
            firstItem = ((long)row - 2) * 5;
            firstItem = firstItem + 1;
        }else{
            firstItem = ((long)row - 1) * 5;
        }

        while(column > 1){
            firstItem = firstItem + 2;
            column-=1;
        }
        return firstItem;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Row = ");
        int row = Integer.parseInt(buffer.readLine());
        System.out.println("Enter Column = ");
        int column = Integer.parseInt(buffer.readLine());
        long result = strangeGrid(row,column);
        System.out.println("\nStange Grid : "+result);
        buffer.close();
    }
}
