import java.util.*;
import java.io.*;
class HashingChain{
    static int BUCKET;
    ArrayList[] listAr = null;
    HashingChain(int size){
        BUCKET = size;
        listAr = new ArrayList[BUCKET];
        for (int i = 0; i < BUCKET; i++) {
            listAr[i] = new ArrayList<Integer>();
        }
    }

    static int hasFunction(int x){
        return x % BUCKET;
    }

    void insert(int x){
        int index = hasFunction(x);  
        listAr[index].add(x);
    }

    void deleteItem(int key){
        var index = hasFunction(key);
        var i = 0;
        for (i = 0; i < listAr[index].size(); i++) {
            if(key == (int)listAr[index].get(i))
                break;
        }
        listAr[index].remove(i);
    }

    void displayHash(){
        for (int i = 0; i < BUCKET; i++) {
            System.out.print(i);
            for (var arrayList : listAr[i]) {
                System.out.print(" --> "+arrayList);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var objHash = new HashingChain(7);
        var input = "";
        var isFirst = true;
        var item = 0;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                input = scanner.nextLine();
            }else
                item =Integer.parseInt(scanner.nextLine());
        }
        for (String string : input.split(" ")) {
            objHash.insert(Integer.parseInt(string));
        }
        objHash.displayHash();
        objHash.deleteItem(item);
        System.out.println();
        objHash.displayHash();
        scanner.close();
    }
}