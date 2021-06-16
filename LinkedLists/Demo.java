import java.util.*;
class Demo{
    public static void main(String[] args) {
        ArrayList<Integer>[] list = new ArrayList<Integer>[5];
        for (int i = 0; i < 5; i++) {
            list[i] = new ArrayList<Integer>();
        }
        list[0].add(5);
        System.out.println(list[0].get(0));
    }
}