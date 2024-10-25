package TwoPointers;

//https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/
public class TakeKOfEachCharacterFromLeftAndRight {
    public static void main(String[] args) {
        System.out.println(takeCharacters("cbbac", 1));
    }

    private static int takeCharacters(String s, int k) {
        //TC = O(n), O(1)
        /*
        valid window -> frequencies of a, b, and c are k individually
        initially left valid window and no right window
        then gradually decrease the left window by one
        */
        int n = s.length(), l = 0, countA = 0, countB = 0, countC = 0;

        //left window having frequency of a,b and c as k if possible
        while(l<n && (countA<k || countB<k || countC<k)){
            char ch = s.charAt(l);
            if(ch == 'a') countA++;
            else if(ch == 'b') countB++;
            else countC++;
            l++;
        }

        //if after the iteration of the whole array the frequencies are not k return -1
        if(countA<k || countB<k || countC<k) return -1;

        int r = n, minLen = l;

        l--;
        while(l>=0){
            //shrink the left window by one
            char ch = s.charAt(l);
            if(ch == 'a') countA--;
            else if(ch == 'b') countB--;
            else countC--;

            //left window invalid and move the right window till both window together makes it valid
            while(countA < k || countB < k || countC < k){
                char chr = s.charAt(r-1);
                if(chr == 'a') countA++;
                else if(chr == 'b') countB++;
                else countC++;
                r--;
            }
            //compute min length by adding the length of left and right window
            minLen = Math.min(minLen, l+n-r);
            l--;
        }

        return minLen;
    }
}
