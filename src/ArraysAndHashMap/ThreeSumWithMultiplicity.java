package ArraysAndHashMap;
import java.util.Arrays;

//https://leetcode.com/problems/3sum-with-multiplicity/

public class ThreeSumWithMultiplicity {
    public static void main(String[] args) {
        System.out.println(threeSumMulti(new int[]{1,1,2,2,3,3,4,4,5,5}, 8));
    }
    private static int threeSumMulti(int[] arr, int target) {
        //TC = O(n^2), SC = O(1)

        //Three sum most optimized approach given by striver with a litte tweak
        //There unique triplets required, here all possible triplets need to be counted
        int n = arr.length, ans = 0, mod = 1000000007;
        Arrays.sort(arr);
        for(int i = 0; i<n-2; i++){
            int j = i+1, k = n-1;
            while(j<k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum == target){
                    if(arr[j] == arr[k]){
                        //logic -> count of triplets will be sum of (k-j) natural numbers

                        //This will also work but the one done is much simpler
                        // int mul = (((k-j)%mod) * ((k-j+1)%mod))%mod;
                        // mul = (int)((mul%mod) * (0.5%mod))%mod;
                        // or
                        // mul = (int)(mul * 0.5);
                        // ans = ((ans%mod) + (mul%mod))%mod;


                        // 3 <= n <= 3000 (given as constraints)
                        // so (k-j) * (k-j+1) * 0.5 will never be outside int range
                        // what can go outside the range is adding up the ans
                        // so ans%=mod is done
                        ans += (int)((k-j) * (k-j+1) * 0.5);
                        ans%=mod;
                        break;
                    }
                    else{
                        //logic -> count of triplets will be no of duplicates of arr[j] and no of duplicates of arr[k]
                        int countJ = 1;
                        while(j<k && arr[j] == arr[j+1]){
                            j++;
                            countJ++;
                        }
                        int countK = 1;
                        while(j<k && arr[k] == arr[k-1]){
                            k--;
                            countK++;
                        }

                        //This will also work but the one done is much simpler
                        // int mul = ((countJ%mod)*(countK%mod))%mod;
                        // ans = ((ans%mod) + (mul%mod))%mod;


                        // 3 <= n <= 3000 (given as constraints)
                        // so countJ * countK will never be outside int range
                        // what can go outside the range is adding up the ans
                        // so ans%=mod is done
                        ans += (countJ * countK);
                        ans%=mod;
                        j++;
                        k--;
                    }
                }
                else if(target < sum){
                    //decrease sum
                    while(j<k && arr[k] == arr[k-1]) k--;
                    k--;
                }
                else{
                    //increase sum
                    while(j<k && arr[j] == arr[j+1]) j++;
                    j++;
                }
            }
        }
        return ans;
    }
}
