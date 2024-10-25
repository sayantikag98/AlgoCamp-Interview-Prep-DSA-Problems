package ArraysAndHashMap;
import java.util.HashMap;

//https://leetcode.com/problems/rabbits-in-forest/description/
public class RabbitsInForest {
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1,5,4,1,3,2,1}));
        System.out.println(numRabbitsSinglePass(new int[]{1,5,4,1,3,2,1}));
    }

    private static int numRabbitsSinglePass(int[] answers) {
        int[] c = new int[1000];
        int res = 0;
        for (int i : answers)
            if (c[i]++ % (i + 1) == 0)
                res += i + 1;
        return res;
    }

    private static int numRabbits(int[] answers) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int ele: answers){
            freq.put(ele, freq.getOrDefault(ele, 0) + 1);
        }

        int ans = 0;
        for(int key: freq.keySet()){
            int val = freq.get(key);
            ans +=  val/(key+1) * (key+1);
            if(val % (key+1) != 0) ans+=(key+1);
        }

        return ans;
    }
}
