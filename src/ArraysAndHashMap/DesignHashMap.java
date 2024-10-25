package ArraysAndHashMap;


//https://leetcode.com/problems/design-hashmap/
class MyHashMap {

    int[] arr;
    public MyHashMap() {
        this.arr = new int[1000001];
    }

    public void put(int key, int value) {
        this.arr[key] = value+1;
    }

    public int get(int key) {
        return this.arr[key]-1;
    }

    public void remove(int key) {
        this.arr[key] = 0;
    }
}
public class DesignHashMap {
    public static void main(String[] args) {
        MyHashMap obj = new MyHashMap();
        obj.put(1,1);
        obj.put(2,2);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        obj.put(2,1);
        System.out.println(obj.get(2));
        obj.remove(2);
        System.out.println(obj.get(2));
    }
}

/*
["MyHashMap","put","put","get","get","put","get","remove","get"]
[[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]
 */
