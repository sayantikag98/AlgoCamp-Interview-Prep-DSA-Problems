package ArraysAndHashMap;
//https://leetcode.com/problems/valid-mountain-array/description/

public class ValidMountainArray {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{0,3,2,1}));
    }

    private static boolean validMountainArray(int[] arr) {
        //TC = O(n), SC = O(1)
        int n = arr.length;
        //valid mountain array
        //1. length>=3
        //2. input array cannot be strictly decreasing at the start of the array (i.e. index i = 0)
        //3. input array cannot be strictly increasing at the end of the end of the array (i.e. index i = n-1)
        if(n<3 || arr[0]>=arr[1] || arr[n-2]<=arr[n-1]) return false;

        boolean isDecreasing = false;
        for(int i = 0; i<n-1; i++){
            if(!isDecreasing){
                if(arr[i]>arr[i+1]) isDecreasing = true;
                else if(arr[i] == arr[i+1]) return false;
            }
            if(isDecreasing && arr[i]<=arr[i+1]) return false;
        }
        return true;

    }
}
