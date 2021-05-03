import java.io.*;

import jdk.internal.org.jline.utils.InputStreamReader;
public class AddFront {
    public static void main(String[] args) throws IOException{
        Node head = null;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int list_size = Integer.parseInt(buffer.readLine());
        while(list_size > 0){
            head = insert(head,Integer.parseInt(buffer.readLine()));
            list_size-=1;
        }
    }
}
