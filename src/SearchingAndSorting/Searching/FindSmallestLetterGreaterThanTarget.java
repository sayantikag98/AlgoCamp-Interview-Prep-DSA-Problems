package SearchingAndSorting.Searching;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c', 'f', 'f'};
        char target = 'f';
        System.out.println(nextGreatestLetter(letters, target));
    }

    private static char nextGreatestLetter(char[] letters, char target) {
        int low = 0, high = letters.length-1;
        char ans = letters[0];
        while(low<=high){
            int mid = low + (high - low)/2;
            char ch = letters[mid];
            if(ch > target){
                ans = ch;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}
