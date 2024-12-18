package SearchingAndSorting.Sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2,44,2,1,13,4,42,1,2,33,9,9};
        mergeSort(arr, 0, arr.length-1);
        for(var ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
    }


    private static void mergeSort(int[] arr, int l, int r){
        if(l>=r) return;
        int mid = l + (r-l)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r){
        int[] ans = new int[r-l+1];
        int i = l, j = mid+1, k = 0;
        while(i<=mid && j<=r){
            if(arr[i]<=arr[j]){
                ans[k] = arr[i];
                i++;
            }
            else{
                ans[k] = arr[j];
                j++;

            }
            k++;
        }

        while(i<=mid){
            ans[k] = arr[i];
            i++;
            k++;
        }

        while(j<=r){
            ans[k] = arr[j];
            j++;
            k++;
        }

        for(k = 0; k<ans.length; k++){
            arr[k+l] = ans[k];
        }
    }
}
