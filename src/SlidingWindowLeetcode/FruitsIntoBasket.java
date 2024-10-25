package SlidingWindowLeetcode;
import java.util.HashMap;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {2,2,3,3,2,2,3,1,4,5,1,2,3,4};
        System.out.println(totalFruit(fruits));
        System.out.println(totalFruitUsingStriverSoln(fruits));
    }

    private static int totalFruit(int[] fruits) {
        //TC = O(n), SC = O(1)
        int maxLen = 0;
        HashMap<Integer, Integer> indFound = new HashMap<>();
        for(int i = 0, j = 0; j<fruits.length; j++){
            if(!indFound.containsKey(fruits[j]) && indFound.size() == 2){
                if(fruits[j-1] == fruits[i]){
                    indFound.remove(fruits[indFound.get(fruits[i])-1]);
                }
                else{
                    indFound.remove(fruits[i]);
                }
                i = indFound.get(fruits[j-1]);
            }
            if(j == 0 || fruits[j] != fruits[j-1]) indFound.put(fruits[j], j);
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }

    private static int totalFruitUsingStriverSoln(int[] fruits) {
        /*
        whenever the window becomes invalid do not let the window shrink beyond the max size of the window obtained so far
        because that will not contribute to the answer
        so move the left pointer by one and accordingly adjust the frequency in the hashmap
         */
        int maxLen = 0;
        HashMap<Integer, Integer> indFound = new HashMap<>();
        for(int i = 0, j = 0; j<fruits.length; j++){
            indFound.put(fruits[j], indFound.getOrDefault(fruits[j], 0) + 1);
            //window invalid
            if(indFound.size() > 2){
                int val = indFound.get(fruits[i]);
                if(val == 1){
                    indFound.remove(fruits[i]);
                }
                else{
                    indFound.put(fruits[i], val - 1);
                }
                i++;
            }
            //window valid so this length of the window can be a possible answer
            else{
                maxLen = Math.max(maxLen, j-i+1);
            }
        }
        return maxLen;
    }
}
