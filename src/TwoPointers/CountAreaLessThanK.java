package TwoPointers;

public class CountAreaLessThanK {
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int k = 12;
        System.out.println(countArea(arr, k));
    }

    private static int countArea(int[] arr, int k){
        int i = 0, j = arr.length-1, count = 0;
        while(i<=j){
            if(arr[i] * arr[j]<k){
                count+=2*(j-i)+1;
                i++;
            }
            else{
                j--;
            }
        }
        return count;
    }
}
