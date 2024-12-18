package SearchingAndSorting.Sorting;

public class InsertionSort {

    static int count = 0, countOptimized = 0;

    public static void main(String[] args) {
        int[] arr = {1,4,1,1,3,4,12,2,2};
        insertionSortRecursive(arr, 1, 0, arr[1]);
        for(var ele: arr){
            System.out.print(ele+" ");
        }
        System.out.println();
        System.out.println(countOptimized);
    }

    private static void insertionSortUsingSwapsUnoptimized(int[] arr){
        for(int i = 1; i<arr.length; i++){
            for(int j = i-1; j>=0; j--){
                count++;
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
                else{
                    break;
                }
            }
        }
    }

    private static void insertionSortOptimized(int[] arr){
        for(int i = 1; i<arr.length; i++){
            int temp = arr[i], j;
            for(j = i-1; j>=0 && arr[j]>temp; j--){
                countOptimized++;
                arr[j+1] = arr[j];
            }
            arr[j+1] = temp;
        }
    }

    private static void insertionSortRecursive(int[] arr, int i, int j, int temp){
        if(i == arr.length) return;
        if(j == -1 || arr[j]<=temp){
            arr[j+1] = temp;
            insertionSortRecursive(arr, i+1, i, i+1<arr.length ? arr[i+1] : -1);
        }
        else{
            arr[j+1] = arr[j];
            insertionSortRecursive(arr, i, j-1, temp);
        }
    }

}
