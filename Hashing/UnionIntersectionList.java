import java.util.*;
import java.io.*;
class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        next = null;
    }
}
public class UnionIntersectionList{
    static Node insert(Node head,int data){
        if(head == null)
            return new Node(data);
        else{
            Node current = head;
            while(current.next!=null)
                current = current.next;
            current.next = new Node(data);
            return head;
        }
    }

    static void unionIntersection(Node head1,Node head2){
        Map<Integer,Integer> hashMap = new HashMap<Integer,Integer>();
        var tempFirst = head1;
        var tempSecond = head2;
        var count = 0;
        while(tempFirst != null || tempSecond != null){
            if(tempFirst != null){
                if(!hashMap.containsKey(tempFirst.data)){
                    hashMap.putIfAbsent(tempFirst.data, 1);
                }else{
                    count  = hashMap.get(tempFirst.data);
                    hashMap.put(tempFirst.data, count+1);
                }
                tempFirst = tempFirst.next;
            }

            if(tempSecond != null){
                if(!hashMap.containsKey(tempSecond.data)){
                    hashMap.putIfAbsent(tempSecond.data, 1);
                }else{
                    count  = hashMap.get(tempSecond.data);
                    hashMap.put(tempSecond.data, count+1);
                }
                tempSecond = tempSecond.next;
            }
        }

        var keys = hashMap.keySet();
        System.out.println("Union of two LinkedList");
        var iterator = keys.iterator();
        while(iterator.hasNext())
            System.out.print(iterator.next()+" ");

        System.out.println("\nIntersection of two LinkedList");
        iterator = keys.iterator();
        while (iterator.hasNext()) {
            var key = iterator.next();
            if(hashMap.get(key) > 1)
                System.out.print(key+" ");
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var firstInput = "";
        var secondInput = "";
        Node headFirst = null;
        Node headSecond = null;
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                firstInput = scanner.nextLine();
            }else{
                secondInput = scanner.nextLine();
            }
        }
        for (String string : firstInput.split(" ")) {
            headFirst = insert(headFirst, Integer.parseInt(string));
        }

        for (String string : secondInput.split(" ")) {
            headSecond = insert(headSecond, Integer.parseInt(string));
        }
        unionIntersection(headFirst, headSecond);
        scanner.close();
    }
}