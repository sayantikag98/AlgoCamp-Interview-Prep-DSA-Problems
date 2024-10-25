package ArraysAndHashMap;
import java.util.*;

//https://www.codechef.com/problems/LGCD


public class GcdVsLcm {
    public static void main(String[] args) {
        //TC = O(t*n), SC = O(t*n)
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        while(test-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            HashMap<Integer, Integer> freq = new HashMap<>();
            int i = 0;
            while(i<n) {
                arr[i] = sc.nextInt();
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
                i++;
            }
            //Iterate over the hashmap and not the given array bcoz key becomes unique in hashmap
            System.out.println(lgcdBetterApproach(freq));
        }

    }

    private static int lgcdBetterApproach(HashMap<Integer, Integer> freq){
        int total = 0;
        for(int ele : freq.keySet()){
            if(freq.containsKey(2*ele)){
                // let's say the pair formed is (2,4) but we have
                // 3 no of 2's and 5 no of 4's then the total pair that can be formed is 3C1 * 5C1 = 15
                // so, we will have to multiply the frequency count of both the numbers to get the total count
                total += freq.get(ele) * freq.get(2*ele);
            }
        }
        return total;
    }

    private static int lgcd(int[] arr, HashMap<Integer, Integer> freq){
        /*
        You need to find two numbers a & b such that lcm(a,b) = 2 * gcd(a,b)
        This condition gets satisfied if b = 2*a or vice-versa,
        such that lcm(a,b) = b and gcd(a,b) = a
         */
        int total = 0;
        HashSet<Integer> seen = new HashSet<>();
        for(int ele: arr){
            //why seen hashset? -> once the element is checked for its double, it should not be checked again. (case valid for duplicate element)
            if(!seen.contains(ele)){ // MISSED OUT THIS CHECK -> MADE MISTAKE HERE
                int target = 2 * ele;
                if (freq.containsKey(target)) {
                    // let's say the pair formed is (2,4) but we have
                    // 3 no of 2's and 5 no of 4's then the total pair that can be formed is 3C1 * 5C1 = 15
                    // so, we will have to multiply the frequency count of both the numbers to get the total count
                    total += (freq.get(ele) * freq.get(target));
                }
                seen.add(ele);
            }
        }
        return total;
    }

}

/*
2
5
1 2 1 4 2
10
4 2 6 12 8 2 1 2 10 5
 */
