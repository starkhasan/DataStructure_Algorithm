import java.util.*;
import java.io.*;
class Demo{
    static void addEdge(ArrayList<ArrayList<Integer>> adjList,int u, int v){
        if(!adjList.get(u-1).contains(v))
            adjList.get(u-1).add(v);
        adjList.get(u).add(v);
        if(!adjList.get(v-1).contains(u))
            adjList.get(v-1).add(u);
        adjList.get(v).add(u);
    }

    static void printGraph(ArrayList<ArrayList<Integer>> adjList){  
        for (var i = 0; i < adjList.size(); i++) {
            System.out.print("head ("+adjList.get(i).get(0)+")");
            for (var j = 0; j < adjList.get(i).size() - 1; j++) {
                System.out.print(" -> "+adjList.get(i).get(j+1));
            }
            System.out.println();
        }
    }
    public static void main(String[] args) throws FileNotFoundException{
        var file = new File("Input.txt");
        var scanner = new Scanner(file);
        var adjList = new ArrayList<ArrayList<Integer>>();
        var isFirst = true;
        while(scanner.hasNext()){
            if(isFirst){
                isFirst = false;
                var size = Integer.parseInt(scanner.nextLine());
                while(size > 0){
                    adjList.add(new ArrayList<Integer>());
                    size-=1;
                }
            }else{
                var temp = scanner.nextLine().split(" ");
                addEdge(adjList, Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            }
        }
        printGraph(adjList);
        scanner.close();
    }
}