package RecursionAndBacktracking;

//https://leetcode.com/problems/permutation-sequence/description/
public class PermutationSequence {
    public static void main(String[] args) {
        /////FOR DESCRIPTION OF THE APPROACH SEARCH IN THE HANDWRITTEN NOTES
        System.out.println(getPermutation(4,9));
    }
    private static String getPermutation(int n, int k) {
        //TC = O(n^2), SC = O(n)
        StringBuilder sb = new StringBuilder();
        int factorial = 1;
        //factorial of n-1
        for(int i = 1; i<n; i++){
            factorial *= i;
        }
        k--;
        boolean[] isFound = new boolean[n];
        while(n!=0){
            int whichSmallest = k/factorial;
            int j = 1;
            while(true){
                if(!isFound[j-1]){
                    if(whichSmallest == 0) break;
                    whichSmallest--;
                }
                j++;
            }
            sb.append((char)(j+48));
            isFound[j-1] = true;
            k%=factorial;
            n--;
            if(n!=0) factorial/=n; //division by zero mistake
        }
        return sb.toString();
    }
}
