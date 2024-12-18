package SearchingAndSorting.Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,4,3,1,2};
        selectionSortRecursive(arr, 0, 1, 0);
        for(var ele: arr){
            System.out.print(ele+ " ");
        }
        System.out.println();
    }

    private static void selectionSortUsingMinElement(int[] arr){
        //if n-1 elements are sorted then the whole array is sorted
        for(int i = 0; i<arr.length-1; i++){
            int minInd = i;
            for(int j = i+1; j<arr.length; j++){
                if(arr[minInd]>arr[j]){
                    minInd = j;
                }
            }
            if(minInd != i){
                int temp = arr[i];
                arr[i] = arr[minInd];
                arr[minInd] = temp;
            }
        }
    }

    private static void selectionSortUsingMaxElement(int[] arr){
        //3,4,3,1,2
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            int maxIdx = 0;
            for(int j = 1; j<n-i; j++){
                if(arr[maxIdx]<arr[j]){
                    maxIdx = j;
                }
            }
            if(maxIdx != n-i-1){
                int temp = arr[maxIdx];
                arr[maxIdx] = arr[n-i-1];
                arr[n-i-1] = temp;
            }
        }
    }

    private static void selectionSortRecursive(int[] arr, int i, int j, int minIdx){
        if(i == arr.length-1) return;
        if(j == arr.length){
            //swap arr[minIdx] & arr[i]
            if(minIdx != i){
                int temp = arr[i];
                arr[i] = arr[minIdx];
                arr[minIdx] = temp;
            }
            selectionSortRecursive(arr, i+1, i+2, i+1);
        }
        else{
            if(arr[minIdx]>arr[j]){
                minIdx = j;
            }
            selectionSortRecursive(arr, i, j+1, minIdx);
        }
    }
}

//3` 4 3 1 2
//1 4 3 3` 2
//1 2 3 3` 4
