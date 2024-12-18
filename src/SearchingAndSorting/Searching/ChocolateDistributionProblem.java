package SearchingAndSorting.Searching;

public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int n = 4;
        int[] arr = {10, 20, 30};
        int m = 3;
        int sum = 0;
        for(var ele: arr){
            sum+=ele;
        }
        System.out.println(minChocolates(arr, n, m, sum));
    }

    private static int minChocolates(int[] arr, int n, int m, int sum){
        //TC = O(n*log(sum of all arr elements)), SC = O(1)
        int low = arr[0], high = sum, ans = high;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(isValid(arr, mid, m)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int chocolates, int m){
        //to check if chocolates is the maximum chocolate value that can be allocated to a student
        int student = 1, sum = 0;
        for(var ele: arr){
            if(ele > chocolates) return false;
            sum += ele;
            if(sum > chocolates){
                sum = ele;
                student++;
                if(student > m) return false;
            }
        }
        return true;
    }
}
