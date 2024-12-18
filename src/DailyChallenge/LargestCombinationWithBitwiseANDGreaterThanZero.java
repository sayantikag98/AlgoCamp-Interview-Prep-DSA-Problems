package DailyChallenge;

//https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description/
public class LargestCombinationWithBitwiseANDGreaterThanZero {
    public static void main(String[] args) {
        System.out.println(largestCombination(new int[] {2,3,4,5,2,1,1,3,4,4,5}));
    }

    private static int largestCombination(int[] candidates) {
        /*
        Why outer loop runs 24 times?
            constraint given in the question: 1 <= candidates.length <= 10^5
            so we need to find the maximum bits of the maximum number given in the candidates array
            highest power of 2 greater than 10^5 is 24 (2^24>10^5)
            we could also take 32 because all values of candidates are in integer range and integer can have max of 32 bits

        to solve this question at every bit keep a count of the elements of the candidates array which have a set bit and the answer is the max count out of this
        means the ans is the bit position count which will have maximum set bit across all numbers of the given array

        all one will only result in 1 for bitwise & operator
        */
        int maxLen = 0;
        for(int i = 0; i<24; i++){
            int count = 0;
            for(int ele: candidates){
                ele>>=i;
                if((ele & 1) == 1) count++;
            }
            maxLen = Math.max(maxLen, count);
        }
        return maxLen;
    }

}
