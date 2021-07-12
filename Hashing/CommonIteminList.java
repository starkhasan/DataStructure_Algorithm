class Item{
    String name;
    int price;
    Item(String name,int price){
        this.name = name;
        this.price = price;
    }
}
public class CommonIteminList {
    static int countItem(Item list1[],Item list2[]){
        var count = 0;
        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if(list1[i].name.compareTo(list2[j].name) == 0 && list1[i].price != list2[j].price)
                    count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Item list1[] = {new Item("apple", 60),new Item("bread", 20),new Item("wheat", 50), new Item("oil", 30)};
        Item list2[] = {new Item("milk", 20), new Item("bread", 15),new Item("wheat", 40), new Item("apple", 60)};
        var result = countItem(list1,list2);
        System.out.println("Count = "+result);
    }
}
